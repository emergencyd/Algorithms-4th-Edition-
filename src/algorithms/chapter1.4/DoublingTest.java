package Chapter_1_4;

import java.util.ArrayList;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class DoublingTest {
	public static double timeTrial(int N) {
		int MAX = 1000000;
		int[] a = new int[N];
		for (int i = 0; i < N; i++) {
			a[i] = StdRandom.uniform(-MAX, MAX);
		}
		Stopwatch timer = new Stopwatch();
		ThreeSum.count(a);
		return timer.elapsedTime();
	}
	
	public static void main(String[] args)  {
		ArrayList<Double> Ns = new ArrayList<Double>();
		ArrayList<Double> times = new ArrayList<Double>();
		int count = 0;
		for (int N = 250; N < 10000; N += N) {
			double time = timeTrial(N);
			Ns.add(Math.log10(N));
			times.add(Math.log10(time));
			count++;
			System.out.printf("%7d %5.1f\n", N, time);
		}
		// Draw
		StdDraw.setXscale(Ns.get(0), Ns.get(count - 1));
		StdDraw.setYscale(times.get(0), times.get(count - 1));
		StdDraw.setPenRadius(0.01);
		StdDraw.setPenColor(StdDraw.RED);
		for (int i = 0; i < count; i++) {
			StdDraw.point(Ns.get(i), times.get(i));
		}
	}

}
