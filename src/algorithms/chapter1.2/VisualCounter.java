import edu.princeton.cs.algs4.StdDraw;

public class VisualCounter {
	private final String name;
	private int count;
	private int n;
	private int N;
	private int max;
	public VisualCounter(String name, int N, int max) {
		this.name = name;
		this.N = N;
		this.max = max;
		StdDraw.setXscale(0, N);
		StdDraw.setYscale(-max, max);
		StdDraw.setPenRadius(0.02);
	}
	public void increment() {
		count++;
		n++;
		assert Math.abs(count) <= max: "Exceed the maximum absolute value for the counter";
		assert n <= N: "Exceed the maximum number of operations";
		StdDraw.point(n, count);
	}
	public void decrement() {
		count--;
		n++;
		assert Math.abs(count) <= max: "Exceed the maximum absolute value for the counter";
		assert n <= N: "Exceed the maximum number of operations";
		StdDraw.point(n, count);
	}
	public int tally() {
		return count;
	}
	public String toString() {
		return count + " " + name;
	}
	public static void main(String[] args) {
		int N = 5;
		int max = 3;
		VisualCounter counter = new VisualCounter("items", N, max);
		for (int i = 0; i < max; i++) {
			counter.increment();
		}
		for (int i = 0; i < N - max; i++) {
			counter.decrement();
		}
		System.out.println(counter);
	}
}
