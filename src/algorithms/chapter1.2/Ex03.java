import edu.princeton.cs.algs4.Interval2D;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdDraw;

public class Ex03 {
	public static void main(String[] args) {
		System.out.println("Please type in the number of interval pairs:");
		int N = StdIn.readInt();
		assert N > 1: "Please type in more than 1 pair";
		System.out.println("Please type in the min and max coordinates:");
		double min = StdIn.readDouble();
		double max = StdIn.readDouble();
		StdDraw.setXscale(min, max);
		StdDraw.setYscale(min, max);
		Interval2D[] inter = new Interval2D[N];
		Interval1D inter1, inter2;
		Point2D[] leftbottom = new Point2D[N];
		Point2D[] righttop = new Point2D[N];
		double x1, x2, y1, y2;
		for (int i = 0; i < N; i++) {
			// x coordinates
			x1 = StdRandom.uniform(min, max);
			x2 = StdRandom.uniform(min, max);
			if (x1 < x2) {
				inter1 = new Interval1D(x1, x2);	
			}
			else inter1 = new Interval1D(x2, x1);
			
			// y coordinates
			y1 = StdRandom.uniform(min, max);
			y2 = StdRandom.uniform(min, max);
			if (y1 < y2) inter2 = new Interval1D(y1, y2);
			else inter2 = new Interval1D(y2, y1);
			
			inter[i] = new Interval2D(inter1, inter2);
			leftbottom[i] = new Point2D(inter1.left(), inter2.left());
			righttop[i] = new Point2D(inter1.right(), inter2.right());
			inter[i].draw();
		}
		
		int intersect = 0;
		int contain = 0;
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				if (inter[i].intersects(inter[j])) {
					intersect++;
					if (inter[i].contains(leftbottom[j]) && inter[i].contains(righttop[j])) contain++;
					else if (inter[j].contains(leftbottom[i]) && inter[j].contains(righttop[i])) contain++;
				}
				
			}
		}
		System.out.println(intersect + " pairs intersect each other");
		System.out.println(contain + " pairs contain the other");
	}
}