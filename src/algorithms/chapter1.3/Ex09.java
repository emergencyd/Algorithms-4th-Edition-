import edu.princeton.cs.algs4.StdIn;

public class Ex09 {
	public static void main(String[] args) {
		Stack<String> val = new Stack<String>();
		Stack<String> op = new Stack<String>();
		
		String op_pick;
		String val_pick;
		String subval;
		
		while (!StdIn.isEmpty()) {
			String item = StdIn.readString();
			if (item.equals("+") || item.equals("-") || item.equals("*") || item.equals("/") || item.equals("sqrt")) {
				op.push(item);
			}
			else if (item.equals(")")) {
				op_pick = op.pop();
				val_pick = val.pop();
				
				if (op_pick.equals("sqrt")) subval = "sqrt(" + val_pick + ")";
				else subval = "(" + val.pop() + op_pick + val_pick + ")";
				val.push(subval);
			}
			else val.push(item);
		}
		
		for (String item: val) {
			System.out.print(val.pop());
		}
	}
}
