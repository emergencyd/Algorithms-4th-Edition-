import java.util.Iterator;

public class Steque<Item> implements Iterable<Item> {
	private Node first;
	private Node last;
	private int N;
	
	private class Node {
		Item item;
		Node next;
	}
	
	public boolean isEmpty() {return N == 0;}
	public int size() {return N;}
	
	public void push(Item item) {
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		if (isEmpty()) last = first;
		N++;
	}
	
	public Item pop() {
		if (isEmpty()) {throw new RuntimeException("Empty steque!");}
		Item item = first.item;
		first = first.next;
		N--;
		if (isEmpty()) last = null;
		return item;
	}
	
	public void enqueue(Item item) {
		Node oldlast = last;
		last = new Node();
		last.item = item;
		if (isEmpty()) first = last;
		else oldlast.next = last;
		N++;
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
		Steque<String> steque = new Steque<String>();
		for (String item: input) {
			if (!item.equals("-")) {
				if (item.equals("+")) steque.enqueue(item);
				else steque.push(item);
			}
			else if (!steque.isEmpty()) steque.pop();
		}
		
		for (String item: steque) System.out.print(item + " ");
	}
}
