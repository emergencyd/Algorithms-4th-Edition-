import edu.princeton.cs.algs4.StdIn;

public class Ex21 {
	public static void main(String[] args) {
		System.out.println("Please input 'name(<6 byte) number1(<6 byte) number2(<6 byte)'"); // ctrl + z to terminate
		String[] input = StdIn.readAllLines();
		System.out.println("*------*------*------*------*");
		System.out.println("| name | num1 | num2 |num1/2|");
		System.out.println("*------*------*------*------*");
		for (int i = 0; i < input.length; i++) {
			String[] parts = input[i].split(" ");
			String name = parts[0];
			int num1 = Integer.parseInt(parts[1]);
			int num2 = Integer.parseInt(parts[2]);
			System.out.printf("|%6s|%6d|%6d|%6.3f|\n", name, num1, num2, (float)num1/(float)num2);
			System.out.println("*------*------*------*------*");
		}
		
	}

}
