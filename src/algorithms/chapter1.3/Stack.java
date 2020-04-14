import java.util.Iterator;

public class Stack<Item> implements Iterable<Item> {
	private Node first;
	private int N;
	
	private class Node {
		Item item;
		Node next;
	}
	
	public boolean isEmpty() {return N == 0;}
	public int size() {return N;}
	
	public Stack() {}
	
	public Stack(Stack<Item> s) {
		// copy stack s to generate a new stack
		Stack<Item> temp = new Stack<Item>();
		
		for (Item item: s) {
			temp.push(item);
		}
		
		for (Item item: temp) {
			push(item);
		}
	}
	
	public void push(Item item) {
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		N++;
	}
	
	public Item pop() {
		Item item = first.item;
		first = first.next;
		N--;
		return item;
	}
	
	public Item peek() {
		if (isEmpty()) throw new RuntimeException("Stack is empty!");
		return first.item;
	}
	
	public static Stack<String> copy(Stack<String> stack) {
		Stack<String> temp = new Stack<String>();
		Stack<String> result = new Stack<String>();
		
		for (String item: stack) {
			temp.push(item);
		}
		
		for (String item: temp) {
			result.push(item);
		}
		
		return result;
	}
	
	public Iterator<Item> iterator() {return new StackIterator();}
	
	private class StackIterator implements Iterator<Item> {
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
		String[] input = {"I", "hate", "-", "love", "small", "-", "cats"};
		Stack<String> stack = new Stack<String>();
		for (String item: input) {
			if (!item.equals("-")) {
				stack.push(item);
				System.out.print(stack.peek() + " ");
			}
			else if (!stack.isEmpty()) stack.pop();
		}
		
		Stack<String> copy = Stack.copy(stack);
		System.out.println();
		System.out.println(stack.size() + " left in stack");
		System.out.println(copy.size() + " left in copy");
		
		Stack<String> copy_new = new Stack<String>(stack);
		copy_new.pop();
		for (String i: copy_new) {System.out.print(i + " ");}
		System.out.println();
		for (String i: stack) {System.out.print(i + " ");}
		
	}
}
