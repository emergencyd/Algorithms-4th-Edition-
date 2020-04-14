import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdRandom;

public class Ex15 {
	public static void main(String[] args) {
		String[] input = {"I", "hate", "-", "love", "small", "-", "cats"};
		Queue<String> queue = new Queue<String>();
		
		for (String item: input) {
			if (!item.equals("-")) {
				queue.enqueue(item);
			}
			else if (!queue.isEmpty()) System.out.println(queue.dequeue());
		}
		
		int num = queue.size();
		System.out.println(num + " left in stack");
		
		int k = StdRandom.uniform(1, num + 1);
		for (int i = 0; i < num - k; i++) {
			queue.dequeue();
		}
		System.out.println(k + ": " + queue.dequeue());
	}

}
