public class Ex14 {
	public static int lg(int N) {
		int k = 0;
		int ini = 1;
		while (ini < N) {
			k += 1;
			ini *= 2;
		}
		return k - 1;
	}
	public static void main(String[] args) {
		int N = 50;
		System.out.println(lg(N));	
	}
}
