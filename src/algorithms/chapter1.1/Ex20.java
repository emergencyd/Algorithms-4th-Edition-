
public class Ex20 {
	public static int factorial(int N) {
		if (N == 0) return 1;
		else return factorial(N - 1) * N;
	}
	
	public static void main(String[] args) {
		System.out.println(Math.log(factorial(3)));
	}
}
