import edu.princeton.cs.algs4.Counter;

public class Ex09 {
	public static int BinarySearch(int[] a, int key, Counter num) {
		int lo = 0;
		int hi = a.length;
		while (lo <= hi) {
			num.increment();
			int mid = lo + (hi - lo) / 2;
			if (a[mid] == key) return mid;
			else if (a[mid] > key) hi = mid - 1;
			else lo = mid + 1;
		}
		return -1;
	}
	public static void main(String[] args) {
		Counter num = new Counter("key");
		int[] a = {1, 23, 456, 7890};
		int key = 2;
		System.out.println(BinarySearch(a, key, num));
		System.out.println(num);
	}

}
