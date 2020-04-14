import java.util.Iterator;

public class CircularQueue<Item> implements Iterable<Item> {
	//private Node first;
	private Node last;
	private int N;
	
	private class Node {
		Item item;
		Node next;
	}
	
	public CircularQueue() {
		last = new Node();
		last.next = last;
		}
	
	public boolean isEmpty() {return N == 0;}
	public int size() {return N;}
	
	public void enqueue(Item item) {
		if (isEmpty()) {
			last.item = item;
		}
		else {
			Node oldlast = last;
			last = new Node();
			last.item = item;
			last.next = oldlast.next;
			oldlast.next = last;
		}
		N++;
	}
	
	public Item dequeue() {
		if (isEmpty()) {throw new RuntimeException("Empty queue");}
		Item item = last.next.item;
		if (N == 1) {last.next.item = null;}
		else {
			last.next = last.next.next;
		}
		N--;
		return item;
	}
	
	public Iterator<Item> iterator() {
		return new CircularQueueIterator();
	}
	
	public class CircularQueueIterator implements Iterator<Item> {
		private Node current = last.next;
		int count = N;
		
		public boolean hasNext() {return count != 0;}
		public void remove() {}
		public Item next() {
			Item item = current.item;
			current = current.next;
			count--;
			return item;
		}
	}
	
	public static void main(String[] args) {
		CircularQueue<Integer> list = new CircularQueue<Integer>();
		for (int i = 0; i < 10; i++) {
			list.enqueue(i);
		}
		System.out.println(list.size());
		for (int item: list) {System.out.print(item + " ");}
	}

}
