
public class Ex33 {
	public static class Matrix{
		public static double dot(double[] x, double[] y) {
			assert x.length == y.length;
			double result = 0;
			for (int i = 0; i < x.length; i++) {
				result += x[i] * y[i];
			}
			return result;
		}
		public static double[][] mult(double[][] a, double[][] b) {
			assert a[0].length == b.length;
			double[][] result = new double[a.length][b[0].length];
			for (int i = 0; i < a.length; i++)
				for (int k = 0; k < b[0].length; k++)
					for (int j = 0; j < a[0].length; j++)				
						result[i][k] += a[i][j] * b[j][k];
			return result;
		}
		public static double[][] transpose(double[][] a) {
			double[][] result = new double[a[0].length][a.length];
			for (int i = 0; i < a.length; i++)
				for (int j = 0; j < a[0].length; j++)
					result[j][i] = a[i][j];
			return result;
		}
		public static double[] mult(double[][] a, double[] x) {
			assert a[0].length == x.length;
			double[] result = new double[a.length];
			for (int i = 0; i < a.length; i ++)
				for (int j = 0; j < a[0].length; j++)
					result[i] += a[i][j] * x[j];
			return result;
		}
		public static double[] mult(double[] y, double[][] a) {
			assert y.length == a.length;
			double[] result = new double[a[0].length];
			for (int i = 0; i < a[0].length; i ++)
				for (int j = 0; j < a.length; j++)
					result[i] += y[j] * a[j][i];
			return result;
		}
	}
	public static void print1D(double[] x) {
		System.out.println("print 1-D result:");
		for (int i = 0; i < x.length; i++)
			System.out.print(x[i] + " ");
		System.out.println();
	}
	
	public static void print2D(double[][] x) {
		System.out.println("print 2-D result:");
		for (int i = 0; i < x.length; i++) {
			for (int j = 0; j < x[0].length; j++) {
				System.out.print(x[i][j] + " ");
			}
			System.out.println();
		}		
	}
	
	public static void main(String[] args) {
		double[] x = {1, 2, 3};
		double[] y = {1, 2, 3};
		double[][] a = {{1, 1, 1}, {2, 2, 2}, {3, 3, 3}};
		double[][] b = {{1, 1, 1}, {2, 2, 2}, {3, 3, 3}};
		System.out.println((Matrix.dot(x, y)));
		print2D(Matrix.mult(a, b));
		print2D(Matrix.transpose(a));
		print1D(Matrix.mult(a, x));
		print1D(Matrix.mult(y, a));
		
	}

}
