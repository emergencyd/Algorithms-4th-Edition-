public class Ex30 {
	public static int gcd(int p, int q) {
		if (q == 0) return p;
		else return(gcd(q, p % q));
	}
	public static void main(String[] args) {
		int M = 20;
		int N = 10;
		boolean[][] a = new boolean[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (gcd(i, j) == 1) a[i][j] = true;
		        System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}
}
