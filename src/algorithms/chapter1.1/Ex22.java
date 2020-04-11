
public class Ex22 {
	public static void main(String[] args) {
		int[] a = {10, 11, 12, 16, 18, 23, 29, 33, 48, 54, 57, 68, 77, 84, 98};
		int key = 23;
		int lo = 0;
		int hi = a.length - 1;
		int mid = rank(key, a, lo, hi, 1);
		System.out.printf("mid=%d", mid);
	}
	public static int rank(int key, int[] a, int lo, int hi, int count) {
		for (int i = 0; i < count; i++) {
			System.out.print(" ");
		}
		System.out.printf("lo=%d, hi=%d", lo, hi);
		System.out.println();
		count++;
		if (lo > hi) return -1;
		int mid = lo + (hi - lo) / 2;
		if (key < a[mid]) return rank(key, a, lo, mid - 1, count);
		else if (key > a[mid]) return rank(key, a, mid + 1, hi, count);
		else return mid;
	}
}
