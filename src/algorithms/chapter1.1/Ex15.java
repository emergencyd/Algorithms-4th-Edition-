public class Ex15 {
	public static int[] histogram(int[] a, int M) {
		int[] sta = new int[M];
		for (int i = 0; i < a.length; i++) {
			if (a[i] >= 0 && a[i] < M) sta[a[i]] += 1;
		}
		return sta;
	}
	public static void main(String[] args) {
		int[] a = {0, 0, 1, 2, 2, 2, 3, 3};
		int M = 4;
		int[] sta = histogram(a, M);
		for (int i = 0; i < sta.length; i++) {
			System.out.println(sta[i]);
		}
	}

}
