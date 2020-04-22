package Chapter_1_4;

import java.util.Arrays;

import edu.princeton.cs.algs4.BinarySearch;

public class StaticSETofInts {
	private int[] a;
	
	public StaticSETofInts(int[] keys) {
		a = new int[keys.length];
		for (int i = 0; i < keys.length; i++)
			a[i] = keys[i];
		Arrays.sort(a);
	}
	
	public boolean contains(int key) {
		return BinarySearch.indexOf(a, key) != -1;
	}
	
	public int rank(int key, int lo, int hi) {
		if (lo > hi) return -1;
		else {
            int mid = lo + (hi - lo) / 2;
            if      (key < a[mid]) return rank(key, lo, mid - 1);
            else if (key > a[mid]) return rank(key, mid + 1, hi);
            else return mid;
        }
    }
	
	public int howMany(int key) {
		int loc = BinarySearch.indexOf(a, key);
		int count = 0;
		if (loc >= 0) {
			//left boundary
			int left = loc;
			int hi = loc - 1;
			while (hi >= -1) {
				left = hi + 1;
				hi = rank(key, 0, hi) - 1;
			}
			//right boundary
			int right = loc;
			int lo = loc + 1;
			while (lo > 0) {
				right = lo - 1;
				lo = rank(key, lo, a.length - 1) + 1;
			}
			count = right - left + 1;
		}
		return count;
	}
	
	public static void main(String[] args) {
		int[] a = {2, 2, 4, 4, 4, 4, 4, 4, 5, 6, 7, 7, 7, 7};
		StaticSETofInts ssi = new StaticSETofInts(a);
		System.out.println(ssi.howMany(2));
		System.out.println(ssi.howMany(4));
		System.out.println(ssi.howMany(7));
	}

}