import java.util.ArrayList;
import java.util.Arrays;

import edu.princeton.cs.algs4.BinarySearch;

public class Ex28 {
	public static int[] redu(int[] a) {
		Arrays.sort(a);
		ArrayList<Integer> whitelist = new ArrayList<>();
		for (int i = 0; i < a.length - 1; i++)
			if (a[i] != a[i + 1]) {
				System.out.print(a[i] + " ");
				whitelist.add(a[i]);
			}
		System.out.print(a[a.length - 1] + " ");
		System.out.println();
		whitelist.add(a[a.length - 1]);
		
		int[] result = new int[whitelist.size()];
		for (int i = 0; i < whitelist.size(); i++)
			result[i] = whitelist.get(i);
		return result;
	}
	public static void main(String[] args) {
		int[] a = {7, 1, 5, 1, 9, 5, 7, 7, 5, 1};
		int key = 5;
		
		System.out.println(BinarySearch.indexOf(redu(a), key));
	}
}
