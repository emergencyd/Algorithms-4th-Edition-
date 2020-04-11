import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

public class Ex01 {
	public static void main(String[] args) {
		int N = StdIn.readInt();
		Point2D[] point = new Point2D[N];
		for (int i = 0; i < N; i++) {
			point[i] = new Point2D(StdRandom.uniform(), StdRandom.uniform());
			StdDraw.setPenRadius(0.02);
			point[i].draw();
		}
		double min = 2;
		double dis = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				dis = point[i].distanceTo(point[j]);
				if (dis < min) min = dis;
			}
		}
		System.out.print("Minimum distance is " + dis);
		
	}

}
