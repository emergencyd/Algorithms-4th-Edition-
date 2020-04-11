
public class Ex16 {
	public static String exR1(int n) {
		if (n <= 0) return "";
		return exR1(n - 3) + n + exR1(n - 2) + n; 
		//  (3)                                   + 6 + (4)                                                    + 6 
		//= [(0) + 3 + (1)                   + 3] + 6 + [(1)                   + 4 + (2)                  + 4] + 6
		//= {""  + 3 + [(-2) + 1 + (-1) + 1] + 3} + 6 + {[(-2) + 1 + (-1) + 1] + 4 + [(-1) + 2 + (0) + 2] + 4} + 6
		//= {""  + 3 + [""   + 1 + ""   + 1] + 3} + 6 + {[""   + 1 + ""   + 1] + 4 + [""   + 2 + ""  + 2] + 4} + 6
		//= 311361142246
	}
	public static void main(String[] args) {
		int x = 6;
		System.out.println(exR1(x));
	}

}
