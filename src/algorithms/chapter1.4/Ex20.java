package Chapter_1_4;

public class Ex20 {
	public static int Rank(int key, int[] a, int lo, int hi) {
		if (lo > hi) return -1;
		int mid = lo + (hi - lo) / 2;
		if (key < a[mid]) return Rank(key, a, lo, mid - 1);
		else if (key > a[mid]) return Rank(key, a, mid + 1, hi);
		else return mid;
	}
	
	public static int ReverseRank(int key, int[] a, int lo, int hi) {
		if (lo > hi) return -1;
		int mid = lo + (hi - lo) / 2;
		if (key > a[mid]) return ReverseRank(key, a, lo, mid - 1);
		else if (key < a[mid]) return ReverseRank(key, a, mid + 1, hi);
		else return mid;
	}
	
	public static int MaxLoc(int[] a) {
		int lo = 0;
		int hi = a.length - 1;
		int mid = -1;
		while (lo < hi) {
			mid = (hi - lo) / 2 + lo;
			if (mid > 0 && a[mid] < a[mid - 1]) hi = mid - 1;
			else if (mid < a.length - 1 && a[mid] < a[mid + 1]) lo = mid + 1;
			else break;
		}
		return mid;
	}
	
	public static boolean Bitonic(int key, int[] a) {
		assert a.length > 2: "invalid array a!";
		int loc = MaxLoc(a);
		if (Rank(key, a, 0, loc) != -1) return true;
		else if (ReverseRank(key, a, loc, a.length - 1)!= -1) return true;
		else return false;
	}

	public static void main(String[] args) {
		int key = -1;
		int[] a = {1, 2, 3, 4, -1, -2, -3};
		System.out.println(Bitonic(key, a));
	}
}
