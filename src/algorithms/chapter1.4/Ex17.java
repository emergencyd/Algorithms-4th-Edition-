package Chapter_1_4;

import java.util.Arrays;

public class Ex17 {
	public static double[] pair(double[] a) {
		double[] result = new double[2];
		Arrays.sort(a);
		double up = Double.NEGATIVE_INFINITY;
		double down = Double.POSITIVE_INFINITY;
		for (int i = 0; i < a.length; i++) {
			if (a[i] > up) up = a[i];
			if (a[i] < down) down = a[i];
		}
		result[0] = down;
		result[1] = up;
		return result;
	}
	
	public static void main(String[] args) {
		double[] a = {-10, -3, 0, 2, 4, 20};
		double[] result = pair(a);
		System.out.println(result[0] + " " + result[1]);
	}

}
