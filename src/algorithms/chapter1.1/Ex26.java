
public class Ex26 {
	public static int[] asc(int[] list) {
		int a = list[0];
		int b = list[1];
		int c = list[2];
		int t;
		if (a > b) {t = a; a = b; b = t;}
		if (a > c) {t = a; a = c; c = t;}
		if (b > c) {t = b; b = c; c = t;}
		int[] new_list = {a, b, c};
		return new_list;
	}
	public static void main(String[] args) {
		int[] list = {3, 2, 1};
		int[] new_list = asc(list);
		System.out.printf("%d, %d, %d", new_list[0], new_list[1], new_list[2]);
	}
}
