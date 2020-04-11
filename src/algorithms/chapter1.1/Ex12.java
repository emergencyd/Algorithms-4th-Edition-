public class Ex12 {
	public static void main(String[] args) {
		int[] a = new int[10];
		for (int i = 0; i < 10; i++)
			a[i] = 9 - i;          // 9, 8, ..., 0
		for (int i = 0; i < 10; i++)
			a[i] = a[a[i]];        // 0, 1, ..., 9
		for (int i = 0; i < 10; i++)
			System.out.println(i); // 0, 1, ..., 9
	}

}
