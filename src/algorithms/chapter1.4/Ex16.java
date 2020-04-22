package Chapter_1_4;

import java.util.Arrays;

public class Ex16 {
	public static double[] pair(double[] a) {
		double[] result = new double[2];
		Arrays.sort(a);
		double dif = Double.POSITIVE_INFINITY;
		for (int i = a.length - 1; i > 0; i--) {
			if (a[i] - a[i - 1] < dif) {
				dif = a[i] - a[i - 1];
				result[0] = a[i - 1];
				result[1] = a[i];
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		double[] a = {-5.2, 9.4, 20, -10, 21.1, 40, 50, -20};
		double[] result = pair(a);
		System.out.println(result[0] + " " + result[1]);
	}

}
