import java.util.Stack;

import edu.princeton.cs.algs4.StdIn;

public class Parentheses {
	public static void main(String[] args) {
		Stack<String> left = new Stack<String>();
		
		while (!StdIn.isEmpty()) {
			String item = StdIn.readString();
			if (item.equals("{") || item.equals("[") || item.equals("(")) {
				left.push(item);
			}
			else if (left.isEmpty()) {
				System.out.print(false);
				return;
			}
			else {
				if (item.equals("}")) {
					if (!(left.pop().equals("{"))) {
						System.out.print(false);
						return;
					}
				}
				else if (item.equals("]")) {
					if (!(left.pop().equals("["))) {
						System.out.print(false);
						return;
					}
				}
				else if (item.equals(")")) {
					if (!(left.pop().equals("("))) {
						System.out.print(false);
						return;
					}
				}
				else throw new RuntimeException("Please input braces!");
			}
		}
		System.out.print(left.isEmpty());
	}
}
