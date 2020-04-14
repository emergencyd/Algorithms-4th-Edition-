
public class DoublyLinkedList<Item> {
	private class Node {
		Item item;
		Node next;
		Node pre;
	}
	
	private Node first;
	private Node last = first;
	
	public void print() {
		Node current = first;
		while (current != null) {
			System.out.print(current.item + " ");
			current = current.next;
		}
		System.out.println();
	}
	
	public void insertEnd(Item key) {
		Node oldlast = last;
		last = new Node();
		last.item = key;
		
		if (first == null) {
			first = last;
		}
		else {
			oldlast.next = last;
			
		}
		last.pre = oldlast;
	}
	
	public void insertBegin(Item item) {
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		if (oldfirst != null) oldfirst.pre = first;
		else last = first;
	}

	
	public void deleteFirstNode() {
		if (first == null) return;
		first = first.next;
		if (first != null) first.pre = null;
		else last = null;
	}
	
	public void deleteLastNode() {
		if (first == null) return;
		last = last.pre;
		if (last != null) last.next = null;
		else first = null;
	}
	
	public void insertBefore(Node node, Item item) {
		if (node == null) return;
		Node before = node.pre;
		Node temp = new Node();
		temp.item = item;
		temp.next = node;
		temp.pre = before;
		node.pre = temp;
		if (before != null) before.next = temp;
		else first = temp;
	}
	
	public void insertAfter(Node node, Item item) {
		if (node == null) return;
		Node after = node.next;
		Node temp = new Node();
		temp.item = item;
		temp.next = after;
		temp.pre = node;
		node.next = temp;
		if (after != null) after.pre = temp;
	}
	
	public void remove(Node node) {
		if (node == null) return;
		if (node == first) deleteFirstNode();
		else if (node == last) deleteLastNode();
		else {
			node.pre.next = node.next;
			node.next.pre = node.pre;
		}
	}
	
	public static void main(String[] args) {
		DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
		for (int i = 0; i < 10; i++) {
			list.insertEnd(i);
		}
		// 1st
		list.insertBegin(100);
		list.print();
		// 2nd
		list.deleteFirstNode();
		list.print();
		// 3th
		list.deleteLastNode();
		list.print();
		// 4th
		list.insertBefore(list.first, 99);
		list.print();
		// 5th
		list.insertAfter(list.first, 98);
		list.print();
		// 6th
		list.remove(list.first);
		list.print();
	}
}
