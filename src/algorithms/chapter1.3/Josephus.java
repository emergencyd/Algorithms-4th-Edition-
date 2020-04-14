import edu.princeton.cs.algs4.Queue;

public class Josephus {
	public static void main(String[] args) {
		int N = 41;
		int M = 3;
		int item = 0;
	
		Queue<Integer> queue = new Queue<Integer>();
	
		for (int i = 0; i < N; i++) {
			queue.enqueue(i);
		}
	
		while(!queue.isEmpty()) {
			for (int i = 0; i < M - 1; i++)  {
				queue.enqueue(queue.dequeue());
			}
			item = queue.dequeue() + 1;
		}
	
		System.out.println("Josephus should sit at " + item);
	}
}
