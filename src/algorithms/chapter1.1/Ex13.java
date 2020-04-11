import java.util.Arrays;

public class Ex13 {
	
	public static double[][] trans(double[][] x) {
		int M = x.length;
		int N = x[0].length;
		double[][] y = new double[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				y[i][j] = x[j][i];
			}
		}
		return y;
	}
	
	public static void main(String[] args) {
		double[][] x = {{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}};
		for (int i = 0; i < x.length; i++) {
			System.out.println(Arrays.toString(x[i]));
		}
		System.out.println("do transpose");
		x = trans(x);
		for (int i = 0; i < x.length; i++) {
			System.out.println(Arrays.toString(x[i]));
		}
	}
}
