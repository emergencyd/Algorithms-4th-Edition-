package Chapter_1_4;

import java.util.Arrays;

import edu.princeton.cs.algs4.In;

public class Ex08 {
	public static void main(String[] args) {
		int[] a = {1, 2, 3, 4, 1, 2, 3, 4, 1, 2, 3, 4};
		Arrays.sort(a);
		int count = 0;
		int j;
		for (int i = 0; i < a.length - 1; i++) {
			j = i + 1;
			while (j < a.length && a[j] == a[i]) {
				count++;
				j++;
			}
		}
		System.out.println("The number of pairs that are equal: " + count);
	}

}
