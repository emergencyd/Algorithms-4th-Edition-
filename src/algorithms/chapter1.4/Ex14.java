package Chapter_1_4;

import java.util.Arrays;

import edu.princeton.cs.algs4.BinarySearch;

public class Ex14 {
	public static int FourSum(int[] a) {
		int N = a.length;
		int count = 0;
		Arrays.sort(a);
		for (int i = 0; i < N; i++)
			for (int j = i + 1; j < N; j++)
				for (int k = j + 1; k < N; k++)
					if (BinarySearch.indexOf(a, -a[i]-a[j]-a[k]) > k) count++;
		return count;
	}
	
	public static void main(String[] args) {
		int[] a = {10, 1, -1, -10, -1};
		System.out.println(FourSum(a));
	}

}
