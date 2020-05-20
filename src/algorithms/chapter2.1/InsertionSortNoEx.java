package Chapter_2_1;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class InsertionSortNoEx {
	public static boolean less(Comparable v, Comparable w) {return v.compareTo(w) < 0;}
	
	private static void show(Comparable[] a) {
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");
		System.out.println();
	}
	
	public static boolean isSorted(Comparable[] a) {
		for (int i = 1; i < a.length; i++) 
			if (less(a[i], a[i - 1])) return false;
		return true;
	}
	
	public static void sort(Comparable[] a) {
		int N = a.length;
		
		for (int i = 1; i < N; i++) {
			Comparable temp = a[i];
			int j = i;
			while (j > 0 && less(temp, a[j - 1])) {
				a[j] = a[j - 1];
				j--;
			}
			a[j] = temp;
		}
	}
	
	public static void main(String[] args) {
		String[] a = {"E", "A", "S", "Y", "Q", "U", "E", "S", "T", "I", "O", "N"};
		sort(a);
		assert isSorted(a);
		show(a);
	}
}
