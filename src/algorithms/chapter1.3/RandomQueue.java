import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import RandomBag.RandomIterator;
import edu.princeton.cs.algs4.StdRandom;

public class RandomQueue<Item> implements Iterable<Item> {
	private Item[] a;
	private int N;
	
	public RandomQueue() {
		a = (Item[]) new Object[1];
		N = 0;
	}
	
	public boolean isEmpty() {return N == 0;}
	public int size() {return N;}
	
	private void resize(int max) {
		Item[] temp = (Item[]) new Object[max];
		for (int i = 0; i < N; i++) {
			temp[i] = a[i];
		}
		a = temp;
	}
	
	public void enqueue(Item item) {
		if (N == a.length) resize(2 * a.length);
		a[N++] = item;
	}
	
	public Item dequeue() {
		if (isEmpty()) {throw new RuntimeException("The Queue is empty!");}
		int loc = StdRandom.uniform(N);
		Item item = a[loc];
		a[loc] = a[N - 1];
		N--;
		if (N > 0 && N == a.length / 4) {resize(a.length / 2);}
		return item;
	}
	
	public Item sample() {
		if (isEmpty()) {throw new RuntimeException("The Queue is empty!");}
		int loc = StdRandom.uniform(N);
		Item item = a[loc];
		return item;
	}
	
	public Iterator<Item> iterator() {
		return new RandomIterator();
	}
	
	private class RandomIterator implements Iterator<Item> {
		private int i = N;
		private List<Item> list;
		public RandomIterator() {
			list = new ArrayList<Item>();
			for (int k = 0; k < N; k++) list.add(a[k]);
			Collections.shuffle(list);
		}
		
		public boolean hasNext() {return i > 0;}
		public Item next() {
			return list.get(--i);
			}
		public void remove()  {}
	}

	public static void main(String[] args) {
		RandomQueue<Integer> queue = new RandomQueue<Integer>();
		for (int i = 0; i < 10; i++) {
			queue.enqueue(i);
		}
		System.out.println("the size is: " + queue.size());
		System.out.println(queue.dequeue());
		System.out.println("the size is: " + queue.size());
		System.out.println(queue.sample());
		System.out.println("the size is: " + queue.size());
		
		for (int item: queue) System.out.print(item + " ");
		System.out.println();
		for (int item: queue) System.out.print(item + " ");
	}
}
