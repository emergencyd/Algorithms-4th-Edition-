import edu.princeton.cs.algs4.StdIn;

public class EvaluatePostfix {
	public static void main(String[] args) {
		Stack<Integer> val = new Stack<Integer>();
		int num;
		
		while (!StdIn.isEmpty()) {
			String item = StdIn.readString();
			switch (item) {
			case "+":
				num = val.pop() + val.pop();
				break;
			case "-":
				num = val.pop();
				num = val.pop() - num;
				break;
			case "*":
				num = val.pop() * val.pop();
				break;
			case "/":
				num = val.pop();
				num = val.pop() / num;
				break;
			default:
				num = Integer.parseInt(item);
				break;
			}
			val.push(num);
		}
		System.out.println(val.pop());
		assert(val.isEmpty()): "something wrong with the code";
	}
}
