import edu.princeton.cs.algs4.StdIn;

public class Ex05 {
	public static void main(String[] args) {
		double x = StdIn.readDouble();
		double y = StdIn.readDouble();
		
		// method 1
		System.out.println(x > 0 && x < 1 && y > 0 && y < 1);
		
		// method 2
		if (x > 0 && x < 1 && y > 0 && y < 1) System.out.println("true");
		else System.out.println("false");
	}
}