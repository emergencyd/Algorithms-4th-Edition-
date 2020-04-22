package Chapter_1_4;

public class FibonacciSearch {
	public static int index(int[] a, int key) {
		int N = a.length;
		int f2 = 0;
		int f1 = 1;
		int f = f1 + f2;
		while (f < N) {
			f2 = f1;
			f1 = f;
			f = f1 + f2;
		}
		
		int offset = -1;
		int mid;
		while (f > 1) {
			mid = Math.min(offset + f2, N - 1);
			if (a[mid] > key) {
				f = f2;
				f1 = f1 - f2;
				f2 = f - f1;
			}
			
			if (a[mid] < key) {
				offset = mid;
				f = f1;
				f1 = f2;
				f2 = f - f1;
			}
			
			if (a[mid] == key) return mid;
		}
		
		// in case f = 1, f1 = 1, f2 = 0;
		if (f1 == 1 && offset < N - 1 && a[offset + 1] == key) return offset + 1;
		
		return -1;
	}
	
	public static void main(String[] args) {
		int[] a = {10, 22, 35, 40, 45, 50, 80, 82, 85, 90};
		System.out.println(index(a, 10));
		System.out.println(index(a, 22));
		System.out.println(index(a, 35));
		System.out.println(index(a, 40));
		System.out.println(index(a, 45));
		System.out.println(index(a, 50));
		System.out.println(index(a, 80));
		System.out.println(index(a, 82));
		System.out.println(index(a, 85));
		System.out.println(index(a, 90));
		System.out.println(index(a, 0));
		System.out.println(index(a, 55));
		System.out.println(index(a, 100));
	}
}
