import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.StdIn;

public class Ex02 {
	public static void main(String[] args) {
		System.out.println("Please type in the number of interval pairs:");
		int N = StdIn.readInt();
		assert N > 1: "Please type in more than 1 pair";
		Interval1D[] inter = new Interval1D[N];
		for (int i = 0; i < N; i++) {
			System.out.println("Please type in the " + i + "(min, max) interval pairs:");
			inter[i] = new Interval1D(StdIn.readInt(), StdIn.readInt());
		}
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				if (inter[i].intersects(inter[j])) System.out.println("(" + inter[i].min() + ", " + inter[i].max() + ") " 
										+ "(" + inter[j].min() + ", " + inter[j].max() + ")");
			}
		}
	}

}
