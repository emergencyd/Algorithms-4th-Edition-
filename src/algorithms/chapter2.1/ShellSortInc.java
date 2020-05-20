package Chapter_2_1;

import java.util.ArrayList;

import edu.princeton.cs.algs4.StdRandom;

public class ShellSortInc {
	public static boolean less(Comparable v, Comparable w) {return v.compareTo(w) < 0;}
	
	private static void exch(Comparable[] a, int i, int j) {Comparable t = a[i]; a[i] = a[j]; a[j] = t;}
	
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
		int h = 1;
		int num = 0;
		ArrayList hs = new ArrayList();
		while (h < N/3) h = 3*h + 1;
		while (h >= 1) {
			hs.add(h);
			h = h/3;
		}
		for (int k = 0; k < hs.size(); k++) {
			h = (int)hs.get(k);
			for (int i = h; i < N; i++) {
				for (int j = i; j >= h; j -= h) {
					num++;
					if (less(a[j], a[j - h])) exch(a, j, j - h);
					else break;
				}
			}
			System.out.print(h + ": " + num / N + "  ");
			//show(a);
		}	
	}
	
	public static void main(String[] args) {
		// 100
		Double[] a = new Double[100];
		for (int i = 0; i < 100; i++) {
			a[i] = StdRandom.uniform(0.0, 1.0);
		}
		sort(a);
		assert isSorted(a);
		System.out.println();
		
		// 1000
		Double[] b = new Double[1000];
		for (int i = 0; i < 1000; i++) {
			b[i] = StdRandom.uniform(0.0, 1.0);
		}
		sort(b);
		assert isSorted(b);
		System.out.println();
		
		// 10000
		Double[] c = new Double[10000];
		for (int i = 0; i < 10000; i++) {
			c[i] = StdRandom.uniform(0.0, 1.0);
		}	
		sort(c);
		assert isSorted(c);
		System.out.println();
		
		// 100000
		Double[] d = new Double[100000];
		for (int i = 0; i < 100000; i++) {
			d[i] = StdRandom.uniform(0.0, 1.0);
		}	
		sort(d);
		assert isSorted(d);
	}
}
