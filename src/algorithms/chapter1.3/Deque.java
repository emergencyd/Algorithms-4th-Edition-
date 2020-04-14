import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {
	private Node first;
	private Node last;
	private int N;
	
	private class Node {
		Item item;
		Node next;
		Node pre;
	}
	
	public Deque() {
		first = null;
		last = null;
		N = 0;
	}
	
	public boolean isEmpty() {return N == 0;}
	public int size() {return N;}
	
	public void pushleft(Item item) {
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		if (isEmpty()) last = first;
		else oldfirst.pre = first;
		N++;
	}
	
	public void pushright(Item item) {
		Node oldlast = last;
		last = new Node();
		last.item = item;
		if (isEmpty()) first = last;
		else {
			oldlast.next = last;
			last.pre = oldlast;
		}
		N++;
	}
	
	public Item popleft() {
		if (isEmpty()) {throw new RuntimeException("Empty steque!");}
		Item item = first.item;
		first = first.next;
		N--;
		if (isEmpty()) last = null;
		else first.pre = null;
		return item;
	}
	
	public Item popright() {
		if (isEmpty()) {throw new RuntimeException("Empty steque!");}
		Item item = last.item;
		last = last.pre;
		N--;
		if (isEmpty()) first = null;
		else last.next = null;
		return item;
	}
                
	public Iterator<Item> iterator() {
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<Item> {
		private Node current = first;
		
		public boolean hasNext() {return current != null;}
		public void remove() {}
		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}
	}
	
	public static void main(String[] args) {
		String[] input = {"I", "hate", "-", "+", "love", "small", "-", "+", "cats"};
		Deque<String> deque = new Deque<String>();
		for (String item: input) {
			if (!item.equals("-")) {
				if (item.equals("+")) deque.pushright(item);
				else deque.pushleft(item);
			}
			//else if (!deque.isEmpty()) deque.popright();
			else if (!deque.isEmpty()) deque.popleft();
		}
		for (String item: deque) System.out.print(item + " ");
	}
}