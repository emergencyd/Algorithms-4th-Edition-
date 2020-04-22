package Chapter_1_4;

import java.util.Arrays;

public class Ex15 {	
	public static int ThreeSumFaster(int[] a) {
		Arrays.sort(a);
		int N = a.length;
		int count = 0;
		for (int i = 0; i < N - 2; i++) {
			int tail = N - 1;
			int key = -a[i];
			for (int head = i + 1; head < tail; head++) {
				while (tail > head && a[head] + a[tail] > key) {
					tail--;
				}
				if (a[head] + a[tail] == key) {
					count++;
				}
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		int[] a = {-10, -10, -5, 0, 5, 10, 10, 15, 20};
		System.out.println(ThreeSumFaster(a));
	}
}
