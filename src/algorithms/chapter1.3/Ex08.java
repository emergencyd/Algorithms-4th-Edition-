import edu.princeton.cs.algs4.ResizingArrayStack;

public class Ex08 {
	public static void main(String[] args) {
		String input = "it was - the best - of times - - - it was - the - -";
		String[] items = input.split("\\s");
		ResizingArrayStack<String> stack = new ResizingArrayStack<String>();
		for (String item: items) {
			if (!item.equals("-")) {
				stack.push(item);
				System.out.print("push [" + item + "] into the stack (");
			}
			else {
				System.out.print("pop [" + stack.pop() + "] from the stack (");
			}
			System.out.print(stack.size() + " left in stack: ");
			for (String s: stack) {
				System.out.print(s + " ");
			}
			System.out.println(")");
		}
		System.out.println("finally, " + stack.size() + " left in stack)");
	}

}
