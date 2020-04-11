import edu.princeton.cs.algs4.StdOut;

public class Ex06 {
	public static void main(String[] args) {
		int f = 0;
		int g = 1;
		for (int i = 0; i <= 15; i++) {
			StdOut.println(f);
			f = f + g; // 1 1 2 3 5 8 13 ...
			g = f - g; // 0 1 1 2 3 5 8 ...
		}
	}
}