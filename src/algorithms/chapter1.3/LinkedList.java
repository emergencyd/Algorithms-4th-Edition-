
public class LinkedList<Item> {
	private class Node {
		Item item;
		Node next;
	}
	
	private Node first;
	private Node last = first;
	
	public void add(Item key) {
		Node oldlast = last;
		last = new Node();
		last.item = key;
		last.next = null;
		
		if (first == null) first = last;
		else oldlast.next = last;
	}
	
	public void print() {
		Node current = first;
		while (current != null) {
			System.out.print(current.item + " ");
			current = current.next;
		}
		System.out.println();
	}
	
	public void deleteLastNode() {
		Node current = first;
		if (current == null) {throw new RuntimeException("Empty list");}
		
		if (current.next == null) {
			first = null;
			return;
		}
		while (current.next.next != null) {
			current = current.next;
		}
		current.next = null;
		return;
	}
	
	public void delete(int k) {
		if (k <= 0) {throw new RuntimeException("Invalid location!");}
		if (k == 1) {
			first = first.next;
			return;}
		
		Node current = first;
		int loc = 1; // the location of "current"
		while (loc < k - 1) {
			if (current == null) {throw new RuntimeException("The length of the list is " + k);}
			current = current.next;
			loc++;
		}
		if (current.next != null) current.next = current.next.next;
	}
	
	public boolean find(Item key) {
		Node current = first;
		while (current != null) {
			if (current.item.equals(key)) {return true;}
			current = current.next;
		}
		return false;
	}

	public void removeAfter(Node node) {
		if (node == null || node.next == null) return;
		node.next = node.next.next;
	}
	
	public void insertAfter(Node node, Node add) {
		if (node == null || add == null) return;
		add.next = node.next;
		node.next = add;
	}

	public void remove(Item key) {
		Node fake = new Node();
		fake.next = first;
		Node current = fake;
		while (current != null && current.next != null) {
			if (current.next.item.equals(key)) {
				current.next = current.next.next;
				}
			current = current.next;
		}
		first = fake.next;
	}
	
	public int max() {
	// require the list item to be positive integer
		int num = 0;
		Node current = first;
		while (current != null) {
			if ((int)current.item > num) {
				num = (int)current.item;
			}
			current = current.next;
		}
		return num;
	}
	
	public int RecursiveMax(LinkedList<Item> list) {
	// require the list item to be positive integer
		int num = 0;
		Node current = list.first;
		if (current != null) {
			list.first = current.next;
			num = RecursiveMax(list);
			if ((int)current.item > num) {
				num = (int)current.item;
			}
		}
		return num;
	}

	
	
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int i = 0; i < 10; i++) {
			list.add(i);
		}
		// 1st
		list.deleteLastNode();
		list.print();
		// 2nd
		list.delete(2);
		list.print();
		// 3rd
		System.out.println(list.find(2));
		// 4th
		list.removeAfter(list.first);
		list.print();
		// 5th
		list.remove(8);
		list.print();
		// 6th
		System.out.println(list.max());
		// 7th
		System.out.println(list.RecursiveMax(list));
	}
}
