import edu.princeton.cs.algs4.StdIn;

public class InfixToPostfix {
	public static void main(String[] args) {
		Stack<String> ops = new Stack<String>();
		Stack<String> vals = new Stack<String>();
		String item;
		String val;
		String sub;
		
		while (!StdIn.isEmpty()) {
			item = StdIn.readString();
			switch (item) {
			case "+":
			case "-":
			case "*":
			case "/":
				ops.push(item);
				break;
			case "(":
				break;
			case ")":
				val = vals.pop();
				sub = "" + vals.pop() + val + ops.pop();
				vals.push(sub);
				break;
			default:
				vals.push(item);
			}
		}
		for (String i: vals) {
			System.out.print(i);
		}
	}
}
