package Chapter_1_4;

public class Ex10 {
	public static int BinarySearch(int key, int[] a) {
		int lo = 0;
		int hi = a.length - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (key < a[mid]) hi = mid - 1;
			else if (key > a[mid]) lo = mid + 1;
			else if (mid > 0 && a[mid - 1] == a[mid]) hi = mid - 1;
			else return mid;
		}
		return -1;
	}
	public static void main(String[] args) {
		int[] a = {0, 0, 1, 1, 2, 2, 2, 2};
		System.out.println(BinarySearch(0, a));
		System.out.println(BinarySearch(1, a));
		System.out.println(BinarySearch(2, a));
	}
}
