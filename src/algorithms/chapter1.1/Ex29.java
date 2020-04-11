import java.util.Arrays;

import edu.princeton.cs.algs4.BinarySearch;

public class Ex29 {
	public static int rank(int[] a, int key) {
		int loc = BinarySearch.indexOf(a, key);
		return loc;
	}
	public static int count(int[] a, int key) {
		int loc = BinarySearch.indexOf(a, key);
		int count = 0;
		for (int i = loc; i < a.length; i++)
			if (a[i] == key) count++;
		return count;
	}
	public static void main(String[] args) {
		int[] a = {84, 48, 68, 10, 18, 98, 12, 23, 54, 57, 33, 16, 77, 11, 29, 11, 29, 77, 77};
		Arrays.sort(a);
		System.out.println(rank(a, 29));
		System.out.println(count(a, 48));
	}
}