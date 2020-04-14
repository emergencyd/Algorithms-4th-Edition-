import java.util.Stack;

public class Ex02 {
	public static void main(String[] args) {
		String input = "it was - the best - of times - - - it was - the - - ";
		String[] items = input.split("\\s");
		Stack<String> s = new Stack<String>();
		for (String item: items) {
			if (!item.equals("-")) s.push(item);
			else if (!s.isEmpty()) System.out.print(s.pop() + " ");
		}
		System.out.println("(" + s.size() + " left in stack)");	
	}

}
