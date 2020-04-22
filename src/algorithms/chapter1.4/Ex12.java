package Chapter_1_4;

import java.util.ArrayList;

public class Ex12 {
	public static ArrayList<Integer> both(int[] a, int[] b) {
		int N = a.length;
		assert N == b.length: "the lengths of a and b are not equal!";
		int loc = 0;
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for (int i = 0; i < N; i++) {
			if (loc == N) break;
			while (a[i] > b[loc]) {
				loc++;
			}
			if (a[i] == b[loc]) {
				nums.add(a[i]);
				loc++;
			}
		}
		return nums;
	}
	
	public static void main(String[] args) {
		int[] a = {2, 3, 4, 5, 6, 7, 8, 9};
		int[] b = {5, 6, 7, 8, 9, 10, 11, 12};
		ArrayList<Integer> nums = both(a, b);
		for (int num: nums) System.out.println(num);
	}
}
