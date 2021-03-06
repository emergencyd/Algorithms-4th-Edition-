package Chapter_2_1;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class InsertionSort {
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
		//StdDraw.setCanvasSize(300, 600); // Ex17 & 18
		for (int i = 1; i < N; i++) {
			for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
				exch(a, j, j - 1);
				//draw(a); // Ex17
			}
			
			/*
			StdDraw.setYscale(0, N);
			DrawTrace(a, i - 1);
			*/ // Ex18
			
			//show(a); // Ex02
		}
	}
	
	private static void DrawTrace(Comparable[] a, int i) {
		for (int k = 0; k < a.length; k++) {
			if (k == i) StdDraw.setPenColor(StdDraw.RED);
			else if (k < i) StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
			else StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.filledRectangle(1.0 * k / a.length, (double)a[k] / 2 + i, 0.25 / a.length, (double)a[k] / 2);
		}
	}
	
	private static void draw(Comparable[] a) {
		for (int k = 0; k < a.length; k++) {
			StdDraw.filledRectangle(1.0 * k / a.length, (double)a[k] / 2, 0.25 / a.length, (double)a[k] / 2);
		}
		try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		StdDraw.clear();
	}
	
	
	public static void main(String[] args) {
		/*
		String[] a = {"E", "A", "S", "Y", "Q", "U", "E", "S", "T", "I", "O", "N"};
		sort(a);
		assert isSorted(a);
		*/
		
		// Ex17
		int length = 20;
		Double[] a = new Double[length];
		for (int i = 0; i < length; i++) {
			a[i] = StdRandom.uniform(0.0, 1.0);
		}
		sort(a);
		assert isSorted(a);
	}
}
