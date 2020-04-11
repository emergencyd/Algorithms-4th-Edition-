import java.util.Arrays;

import edu.princeton.cs.algs4.StdIn;

public class Ex23 {
	public static int rank(int key, int[] a) {
		int lo = 0;
		int hi = a.length - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (key < a[mid]) hi = mid - 1;
			else if (key > a[mid]) lo = mid + 1;
			else return mid;
		}
		return -1;
	}
	public static void main(String[] args) {
		System.out.println("+ (not in the whitelist) or - (in the whitelist)");
		char arg = StdIn.readChar();
		
		int[] whitelist = {84, 48, 68, 10, 18, 98, 12, 23, 54, 57, 48, 33};
		Arrays.sort(whitelist);
		System.out.println("please type a key (ctrl+z to exit)");
		while (!StdIn.isEmpty()) {			
			int key = StdIn.readInt();
			if (rank(key, whitelist) == -1 && arg == '+')
				System.out.println(key);
			else if (rank(key, whitelist) > 0 && arg == '-')
				System.out.println(key);
			else
				System.out.println("not meet requirment");
			System.out.println("please type a key (ctrl+z to exit)");
		}
	}
}
