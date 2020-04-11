import java.util.Arrays;

import edu.princeton.cs.algs4.StdRandom;

public class Ex39 {
	public static int BinarySearch(int key, int[] a) {
		int lo = 0;
		int hi = a.length - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (key == a[mid]) return mid;
			else if (key > a[mid]) lo = mid + 1;
			else hi = mid - 1;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int T = Integer.parseInt(args[0]);
		int[] all = {1000, 10000, 100000, 1000000};
		int num;
		for (int i = 0; i < all.length; i++) {
			num = 0;
			int N = all[i];
			int[] list1 = new int[N];
			int[] list2 = new int[N];
			for (int k = 0; k < T; k++) {				
				for (int j = 0; j < N; j++) {
					list1[j] = StdRandom.uniform(100000, 1000000);
					list2[j] = StdRandom.uniform(100000, 1000000);
				}
				Arrays.sort(list1);
				// statistics
				for (int j = 0; j < N; j++) {
					if (BinarySearch(list2[j], list1) >= 0) {
						num++;
					}
				}
			}
			System.out.printf("%d: %.2f\n", N, (float)num/T);
		}
	}
}