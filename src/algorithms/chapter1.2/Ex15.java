import edu.princeton.cs.algs4.In;

public class Ex15 {
	public static int[] readInts(String name) {
		In in = new In(name);
		String input = in.readAll();
		String[] input_set = input.split("\\s+");
		int[] output = new int[input_set.length];
		for (int i = 0; i < input_set.length; i++) {
			output[i] = Integer.parseInt(input_set[i]);
		}
		return output;
	}
	
	public static void main(String[] args) {
		int[] test = readInts("tinyT.txt");
		for (int i = 0; i < test.length; i++) {
			System.out.println(test[i]);
		}
	}
}
