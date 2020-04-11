
public class Accumulator {
	private double m;
	private double s;
	private int N;
	
	public void addDataValue(double x) {
		N++;
		s = s + (x - m) * (x - m) * (N - 1) / N;
		m = m + (x - m) / N;
	}
	
	public double mean() {
		return m; 
	}
	
	public double var() {
		return s / (N - 1);
	}
	
	public double stddev() {
		return Math.sqrt(this.var());
	}
	
	public static void main(String[] args) {
		Accumulator acc = new Accumulator();
		acc.addDataValue(5);
		acc.addDataValue(6);
		acc.addDataValue(7);
		acc.addDataValue(8);
		System.out.println(acc.mean());
		System.out.println(acc.var());
		System.out.println(acc.stddev());
	}

}
