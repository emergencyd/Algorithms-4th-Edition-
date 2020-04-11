import edu.princeton.cs.algs4.StdIn;

public class Ex24 {
	public static int gcd(int p, int q) {
		System.out.printf("p=%d, q=%d", p, q);
		System.out.println();
		if (q == 0) return p;
		int r = p % q;
		return gcd(q, r);
	}
	public static void main(String[] args) {
		System.out.println("Please type two integers");
		int[] nums = StdIn.readAllInts();
		int p = nums[0];
		int q = nums[1];
		System.out.printf("the greatest divider is %d", gcd(p, q));
	}

}
