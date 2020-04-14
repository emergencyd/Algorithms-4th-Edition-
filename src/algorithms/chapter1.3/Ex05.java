//import java.util.Stack;

public class Ex05 {
	public static void main(String[] args) {
		int N = 50;
		Stack<Integer> stack = new Stack<Integer>();
		while (N > 0) {
			stack.push(N % 2);
			N = N / 2;
		}
		for (int d: stack) System.out.print(d);
		System.out.println();
		System.out.println(stack.size() + " left in stack");
	}
}
