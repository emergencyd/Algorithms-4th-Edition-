import edu.princeton.cs.algs4.StdIn;

public class Ex06 {
	public static boolean CirCheck(String str1, String str2) {
		if (str1.length() != str2.length()) return false;
		String str = str1 + str1;
		if (str.indexOf(str2) != -1) return true;
		else return false;
	}
	public static void main(String[] args) {
		System.out.println("Please type in two strings");
		String str1 = StdIn.readString(); // ACTGACG 
		String str2 = StdIn.readString(); // TGACGAC
		System.out.println(CirCheck(str1, str2));
	}

}
