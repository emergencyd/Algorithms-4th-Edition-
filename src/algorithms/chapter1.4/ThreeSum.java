package Chapter_1_4;

import edu.princeton.cs.algs4.In;

public class ThreeSum {
	public static int count(int[] a) {
		int N = a.length;
		int cnt = 0;
		for (int i = 0; i < N; i++) 
			for (int j = i + 1; j < N; j++)
				for (int k = j + 1; k < N; k++)
					if ((long)a[i] + (long)a[j] + (long)a[k] == 0)
						cnt++;
		return cnt;
	}
	
	public static void main(String[] args) {
		In in = new In("1Kints.txt");
		int[] a = in.readAllInts();
		System.out.println(count(a));
	}

}
