import edu.princeton.cs.algs4.StdRandom;

public class GeneralizeQueue<Item> {
	private Item[] a;
	private int N;
	
	public GeneralizeQueue() {
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
	
	public void insert(Item x) {
		if (N == a.length) resize(2 * a.length);
		a[N++] = x;
	}
	
	public Item delete(int k) {
		if (k > N || k < 1) {throw new RuntimeException("Invalid location k!");}
		Item item = a[k - 1];
		for (int i = k - 1; i < N - 1; i++) {
			a[i] = a[i + 1];
		}
		N--;
		if (N > 0 && N == a.length / 4) {resize(a.length / 2);}
		return item;
	}
	
	public static void main(String[] args) {
		GeneralizeQueue<Integer> queue = new GeneralizeQueue<Integer>();
		for (int i = 0; i < 10; i++) {
			queue.insert(i);
		}
		System.out.println("The size is " + queue.size());
		System.out.println(queue.delete(5));
		System.out.println("The size is " + queue.size());
		System.out.println(queue.delete(5));
		System.out.println(queue.delete(8));
	}
}
