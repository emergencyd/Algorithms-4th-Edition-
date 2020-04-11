
public class Ex18 {
	public static int mystery(int a, int b) {
		if (b == 0) return 1; //0;
		if (b % 2 == 0) return mystery(a * a, b / 2);
		return mystery(a * a, b / 2) * a;
	}
	
	public static void main(String[] args){
		System.out.println(mystery(2, 25)); // mystery(4, 12) + 2 = mystery(8, 6) + 2 = mystery(16, 3) + 2 
											//= mystery(32, 1) + 18 = mystery(64, 0) + 50 = 50
		System.out.println(mystery(3, 11)); // mystery(6, 5) + 3 = mystery(12, 2) + 9 = mystery(24, 1) + 9
											//= mystery(48, 0) + 33 = 33
	}

}
