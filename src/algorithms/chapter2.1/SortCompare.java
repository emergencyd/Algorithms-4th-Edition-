package Chapter_2_1;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class SortCompare {
	public static double time(String alg, Double[] a) {
		Stopwatch timer = new Stopwatch();
		if (alg.equals("InsertionSort")) InsertionSort.sort(a);
		if (alg.equals("InsertionSortNoEx")) InsertionSortNoEx.sort(a);
		return timer.elapsedTime();
	}
	
	public static double timeRandomInput(String alg, int N, int T) {
		double total = 0.0;
		Double[] a = new Double[N];
		for (int t = 0; t < T; t++) {
			for (int i = 0; i < N; i++)
				a[i] = StdRandom.uniform();
			total += time(alg, a);
		}
		return total;
	}
	
	public static void main(String[] args) {
		int N = 1000;
		int T = 1000;
		double t1 = timeRandomInput("InsertionSort", N, T);
		double t2 = timeRandomInput("InsertionSortNoEx", N, T);
		System.out.println("t1 = " + t1 + ", t2 = " + t2);
	}

}
