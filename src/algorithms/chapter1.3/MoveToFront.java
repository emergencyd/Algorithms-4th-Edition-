import java.util.Iterator;

import edu.princeton.cs.algs4.StdIn;

public class MoveToFront<Item> implements Iterable<Item> {
	private Node first;
	
	public boolean isEmpty() {return first == null;}
	
	private class Node {
		private Item item;
		private Node next;
	}

	private void delete(Item item) {
		Node current = first;
		if (current.item.equals(item)) {
			System.out.println("delete " + item);
			first = first.next;
			return;
			}
		while (current.next != null) {
			if (current.next.item.equals(item)) {
				current.next = current.next.next;
				System.out.println("delete " + item);
				return;
			}
			current = current.next;
		}
	}
	
	public void insert(Item item) {
		if (!isEmpty()) {delete(item);}
		Node temp = first;
		first = new Node();
		first.item = item;
		first.next = temp;
	}
	
	public Iterator<Item> iterator() {return new MTFiterator();}
	
	public class MTFiterator implements Iterator<Item> {
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
		String item;
		MoveToFront<String> mtf = new MoveToFront<String>();
		while (!StdIn.isEmpty()) {
			item = StdIn.readString();
			mtf.insert(item);
		}
		for (String s: mtf) {
			System.out.println(s);
		}
	}

}
