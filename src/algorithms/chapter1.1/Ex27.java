public class Ex27 {
	public static double binomial(int N, int k, double p, double[][] save) {
		if (N == 0 && k == 0) save[N][k] = 1.0;
		else if (N < 0 || k < 0) return 0.0;
		else if (save[N][k] >= 0) save[N][k] = save[N][k];
		else save[N][k] = (1.0 - p) * binomial(N - 1, k, p, save) + p * binomial(N - 1, k - 1, p, save);		
		return save[N][k];
	}
	public static void main(String[] args) {
		int N = 100;
		int k = 50;
		double p = 0.25;
		double[][] save = new double[N + 1][k + 1];
		for (int i = 0; i < N + 1; i++)
			for (int j = 0; j < k + 1; j++)
				save[i][j] = -1;
		System.out.println(binomial(N, k, p, save));
	}

}
