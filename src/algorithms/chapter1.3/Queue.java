import java.util.Iterator;

public class Queue<Item> implements Iterable<Item> {
	private Node first;
	private Node last;
	private int N;
	
	private class Node {
		Item item;
		Node next;
	}
	
	public boolean isEmpty() {return first == null;}
	public int size() {return N;}
	
	public Queue() {}
	public Queue(Queue<Item> q) {
		for (Item item: q) {
			enqueue(item);
		}
	}
	
	public void enqueue(Item item) {
		Node oldlast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if (isEmpty()) first = last;
		else oldlast.next = last;
		N++;
	}
	
	public Item dequeue() {
		Item item = first.item;
		first = first.next;
		if (isEmpty()) last = null;
		N--;
		return item;
	}
	
	public Iterator<Item> iterator() {return new QueueIterator();}
	
	private class QueueIterator implements Iterator<Item> {
		private Node current = first;
		
		public boolean hasNext() {return current != null;}
		public void remove() {};
		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}
	}
	
	public static void main(String[] args) {
		Queue<Integer> q = new Queue<Integer>();
		for (int i = 0; i < 10; i++) {
			q.enqueue(i);
		}
		Queue<Integer> r = new Queue<Integer>(q);
		r.dequeue();
		for (int i: q) {System.out.print(i + " ");}
		System.out.println();
		for (int i: r) {System.out.print(i + " ");}
	}
}
