public class Ex11 {
	public static void BoolPrint(boolean[][] x) {
		String sym;  
		System.out.print("   ");
		for (int j = 0; j < x[0].length; j++) {
			System.out.print(j + " ");
		}
		for (int i = 0; i < x.length; i++) {
			System.out.println();
			System.out.print(i + "  ");
			for (int j = 0; j < x[0].length; j++) {
				if (x[i][j] == true) sym = "*";
				else sym = " ";
				System.out.print(sym + " ");
			}				
		}			
	}
	public static void main(String[] args) {
		boolean[][] x = {{true, false, true, false}, {false, true, false, true}};
		BoolPrint(x);
	}

}
