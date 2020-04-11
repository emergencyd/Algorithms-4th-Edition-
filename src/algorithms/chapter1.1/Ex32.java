import java.util.ArrayList;
import java.util.Scanner;

import edu.princeton.cs.algs4.StdDraw;

public class Ex32 {
	public static void main(String[] args) {
		ArrayList<Double> list = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNextDouble()) {
			list.add(scanner.nextDouble());
		}
		int N = Integer.parseInt(args[0]);
		double l = Double.parseDouble(args[1]);
		double r = Double.parseDouble(args[2]);
		
		int[] num = new int[N];
		int max = 0;
		double step = (r - l) / N;
		for (int i = 0; i < list.size(); i++) {
			double element = list.get(i);
			if (element >= 1 && element <= r) {
				for (int j = 0; j < N; j++) {
					if (element > l + step * j && element <= l + step * j + step) {
						num[j]++;
						if (max < num[j]) {
							max = num[j];
						}
					}
				}
			}
		}
		for (int i = 0; i < N; i++) {
			double x = (i + 0.5) / N; // the step for drawing is 1/N
			double y = num[i] / 2.0 / max; // normalize by max
			double rw = 0.4 / N;
			StdDraw.filledRectangle(x, y, rw, y);
		}
	}

}
