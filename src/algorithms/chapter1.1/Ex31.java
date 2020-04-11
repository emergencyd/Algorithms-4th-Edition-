import java.awt.Color;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class Ex31 {
	public static String getType(Object o){
		return o.getClass().toString();
		}
	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);
		double p = Double.parseDouble(args[1]);
		assert ((String)getType(N)).equals("class java.lang.Integer");
		assert (p < 1 && p > 0);
		double r = 0.4;
		StdDraw.circle(0.5, 0.5, r);
		StdDraw.setPenRadius(0.05);
		double angle = 2 * Math.PI / N;
		double[] x = new double[N];
		double[] y = new double[N];
		for (int i = 0; i < N; i++) {
			x[i] = r * Math.cos(angle * i) + 0.5;
			y[i] = r * Math.sin(angle * i) + 0.5;
			StdDraw.point(x[i], y[i]);
		}
		StdDraw.setPenRadius(0.01);
		StdDraw.setPenColor(Color.gray);
		for (int i = 0; i < N - 1; i++) {
			if (StdRandom.bernoulli(p)) StdDraw.line(x[i], y[i], x[i + 1], y[i + 1]);
		}
		if (StdRandom.bernoulli(p)) StdDraw.line(x[N - 1], y[N - 1], x[0], y[0]);
	}
}
