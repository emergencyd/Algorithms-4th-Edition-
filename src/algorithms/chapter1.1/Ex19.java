import edu.princeton.cs.algs4.StdOut;

public class Ex19 {  //Fibonacci
	public static long[] F(int N) {
		long[] fibonacci = new long[N + 2];
		fibonacci[0] = -1;
		fibonacci[1] = 1;
		for (int i = 2; i < N + 2; i++) {
			fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
		}
		return fibonacci;
	}
	public static void main(String[] args) {
		long[] fibonacci = F(100);
		for (int N = 0; N < 100; N++)
			StdOut.println(N + " " + fibonacci[N + 2]);
	}

}