public class ResizingArrayQueueOfStrings {
	private String[] a = new String[1];
	private int N;
	
	public boolean isEmpty() {return N == 0;}
	public int size() {return N;}
	
	public void resize(int length) {
		String[] temp = new String[length];
		for (int i = 0; i < N; i++) {
			temp[i] = a[i];
		}
		a = temp;
	}
	
	public void enqueue(String item) {
		if (N == a.length) {resize(2 * a.length);}
		a[N++] = item;
	}
	
	public String dequeue() {
		String item = a[0];
		for (int i = 0; i < N - 1; i++) {
			a[i] = a[i + 1];
		}
		N--;
		if (N > 0 && N == a.length / 4) {resize(a.length / 2);}
		return item;
	}

	public static void main(String[] args) {
		String[] input = {"I", "hate", "-", "love", "small", "-", "cats"};
		ResizingArrayQueueOfStrings queue = new ResizingArrayQueueOfStrings();
		
		for (String item: input) {
			if (!item.equals("-")) {
				queue.enqueue(item);
			}
			else if (!queue.isEmpty()) System.out.println(queue.dequeue());
		}
		System.out.println(queue.size() + " left in stack");
	}
}
