import edu.princeton.cs.algs4.StdRandom;

public class Ex37 {
	public static void shuffle(int[] a) {
		int N = a.length;
		for (int i = 0; i < N; i++) {
			// Exchange a[i] with random element in a[0..N-1]
			int r = StdRandom.uniform(N);
			int temp = a[i];
			a[i] = a[r];
			a[r] = temp;
		}
	}
	public static void main(String[] args) {
		int M = Integer.parseInt(args[0]);
		int N = Integer.parseInt(args[1]);
		int[][] record = new int[M][M];
		for (int k = 0; k < N; k++) {
			int[] list = new int[M];
			for (int i = 0; i < M; i++)
				list[i] = i;
			shuffle(list);
			for (int i = 0; i < M; i++)
				record[list[i]][i] += 1;
		}
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(record[i][j] + " ");
			}
			System.out.println();
		}	
	}
}
