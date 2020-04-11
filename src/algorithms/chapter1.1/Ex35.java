import edu.princeton.cs.algs4.StdRandom;

public class Ex35 {
	public static void main(String[] args) {
		int SIDES = 6;
		double[] dist = new double[2*SIDES + 1];
		for (int i = 1; i <= SIDES; i++)
			for (int j = 1; j <= SIDES; j++)
				dist[i + j] += 1.0;
		for (int k = 2; k <= 2 * SIDES; k++) {
			dist[k] /= 36.0;
			System.out.printf("%d: %.3f\n", k, dist[k]);
		}
		System.out.println("====== Experiment ======");
		// simulate
		int N = 4000000;
		double[] exp = new double[2*SIDES + 1];
		for (int i = 0; i < N; i++) {
			int D1 = StdRandom.uniform(1, SIDES + 1);
			int D2 = StdRandom.uniform(1, SIDES + 1);
			exp[D1 + D2] += 1.0;			
		}
		for (int k = 2; k <= 2 * SIDES; k++) {
			exp[k] /= N;
			if (Math.abs(exp[k] - dist[k]) >= 0.001) System.out.printf("%d: %.3f (false)\n", k, exp[k]);
			else System.out.printf("%d: %.3f\n", k, exp[k]);
				
		}
	}
}
