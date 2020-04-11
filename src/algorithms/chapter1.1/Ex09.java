import edu.princeton.cs.algs4.StdIn;

public class Ex09 {
	public static void main(String[] args) {
		int N = StdIn.readInt();
		String s = "";
		for (int n = N; n > 0; n /= 2)
			s = (n % 2) + s;
		System.out.println(s);
	}
}
