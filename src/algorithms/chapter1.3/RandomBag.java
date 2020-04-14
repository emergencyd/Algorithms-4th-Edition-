import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class RandomBag<Item> implements Iterable<Item> {
	private Item[] a = (Item[]) new Object[1];
	private int N = 0;
	
	public boolean isEmpty() {return N == 0;}
	public int size() {return N;}
	
	private void resize(int max) {
		Item[] temp = (Item[]) new Object[max];
		for (int i = 0; i < N; i++) {
			temp[i] = a[i];
		}
		a = temp;
	}
	
	public void add(Item item) {
		if (N == a.length) resize(2 * a.length);
		a[N++] = item;
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
		RandomBag<Integer> bag = new RandomBag<Integer>();
		for (int i = 0; i < 10; i++)
			bag.add(i);
		for (int item: bag)
			System.out.println(item);
	}
}
