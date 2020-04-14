
public class Buffer {	
	private Stack<Character> left;
	private Stack<Character> right;
	
	public Buffer() {
		left = new Stack<Character>();
		right = new Stack<Character>();
	}
	
	public int size() {
		return left.size() + right.size();
	}
	
	public void insert(char c) {
		left.push(c);
	}
	
	public char delete() {
		return left.pop();
	}
	
	public void left(int k) {
		assert k <= left.size(): "invalid k!";
		for (int i = 0; i < k; i++) {
			right.push(left.pop());
		}
	}
	
	public void right(int k) {
		assert k <= right.size(): "invalid k!";
		for (int i = 0; i < k; i++) {
			left.push(right.pop());
		}
	}
	
	public static void main(String[] args) {
		Buffer buffer = new Buffer();
		String text = "strawberry";
		for (int i = 0; i < text.length(); i++) {
			buffer.insert(text.charAt(i));
		}
		System.out.println(buffer.size());
		buffer.left(3);
		System.out.println(buffer.delete());
		buffer.right(2);
		System.out.println(buffer.delete());
		System.out.println(buffer.size());
	}
}
