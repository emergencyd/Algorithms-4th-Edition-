import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;

public class Ex38 {
	public static int BruteForceSearch(int key, int[] a) {
		for (int i = 0; i < a.length; i++)
			if (a[i] == key) return i;
		return -1;
	}
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
		In in = new In(args[0]);
		int[] whitelist = in.readAllInts();
		Arrays.sort(whitelist); // this should not be included for BruteForceSearch
		int quick = 0;
		int slow = 0;
		long start;
		long end;
		while(!StdIn.isEmpty()) {
			int key = StdIn.readInt();
			// BinarySearch
			start=System.currentTimeMillis();
			System.out.println(key + "(Binary): " + rank(key, whitelist));
			end=System.currentTimeMillis();
			quick += end - start;
			
			//ForceSearch 
			start=System.currentTimeMillis();
			System.out.println(key + "(Force): " + BruteForceSearch(key, whitelist));
			end=System.currentTimeMillis();
			slow += end - start;
		}
		System.out.println("Run time (Binary): " + quick + "ms");
		System.out.println("Run time (Force): " + slow + "ms");
	}

}
