package Chapter_1_4;

public class Ex24 {
	public static int floor(int[] a) {
		if (a[0] == 1) return 0;
		
		int lo = 1; // 0th could not be 1
		int hi = a.length - 1;
		int mid;
		while (lo <= hi) {
			mid = lo + (hi - lo) / 2;
			if (a[mid] == 1) {
				if (a[mid - 1] == 0) return mid;
				else {hi = mid - 1;}
			}
			else {
				lo = mid + 1;
			}
		}
		return -1;
	}
	
	public static int floor2(int[] a) {
		if (a[0] == 1) return 0;
		
		int loc = 1;
		while (loc < a.length) {
			if (a[loc] == 1) break;
			else loc *= 2;
		}
		
		int lo = loc / 2 + 1;
		int hi = Math.min(a.length - 1, loc);
		int mid;
		while (lo <= hi) {
			mid = lo + (hi - lo) / 2;
			if (a[mid] == 1) {
				if (a[mid - 1] == 0) return mid;
				else {hi = mid - 1;}
			}
			else {
				lo = mid + 1;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] a = {0, 0, 0, 0, 0, 0, 1};
		System.out.println(floor(a));
		System.out.println(floor2(a));
		int[] b = {1, 1, 1};
		System.out.println(floor(b));
		System.out.println(floor2(b));
		int[] c = {0};
		System.out.println(floor(c));
		System.out.println(floor2(c));
		int[] d = {0, 0, 0};
		System.out.println(floor(d));
		System.out.println(floor2(d));
		int[] e = {0, 0, 1, 1, 1};
		System.out.println(floor(e));
		System.out.println(floor2(e));
	}
}
