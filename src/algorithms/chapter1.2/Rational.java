
public class Rational {
	private int numerator;
	private int denominator;
	
	public Rational(int numerator, int denominator) {
		assert denominator !=0: "the denominator cannot be 0!";
		if (numerator * denominator >= 0) {
			numerator = Math.abs(numerator);
			denominator = Math.abs(denominator);
		}
		else {
			numerator = -Math.abs(numerator);
			denominator = Math.abs(denominator);
		}
		
		int common = gcd(numerator, denominator);
		
		this.numerator = numerator / common;
		this.denominator = denominator / common;
	}
	
	public int numerator() {
		return numerator;
	}
	
	public int denominator() {
		return denominator;
	}
	
	private int gcd(int p, int q) {
		if (q == 0) return p;
		return gcd(q, p % q);
	}
	
	private int lcm(int p, int q) {
		assert !isTimesOverflow(p, q): "Times overflow";
		return p * q / gcd(p, q);
	}
	
	public Rational plus(Rational b) {
		int deno = lcm(this.denominator(), b.denominator());
		assert !isTimesOverflow(deno / this.denominator(), this.numerator()): "Times Overflow";
		int p = deno / this.denominator() * this.numerator();
		assert !isTimesOverflow(deno / b.denominator(), b.numerator()): "Times Overflow";
		int q = deno / b.denominator() * b.numerator();
		assert !isPlusOverflow(p, q): "Plus Overflow";
		int num = p + q;
		int common = gcd(num, deno);
		Rational sum = new Rational(num / common, deno / common);
		return sum;
	}
	
	public Rational minus(Rational b) {
		int deno = lcm(this.denominator(), b.denominator());
		assert !isTimesOverflow(deno / this.denominator(), this.numerator()): "Times Overflow";
		int p = deno / this.denominator() * this.numerator();
		assert !isTimesOverflow(deno / b.denominator(), b.numerator()): "Times Overflow";
		int q = deno / b.denominator() * b.numerator();
		assert !isPlusOverflow(p, q): "Plus Overflow";
		int num = p - q;
		int common = gcd(num, deno);
		Rational sub = new Rational(num / common, deno / common);
		return sub;
	}
	
	public Rational times(Rational b) {
		assert !isTimesOverflow(this.denominator(), b.denominator()): "Times Overflow";
		int deno = this.denominator() * b.denominator();
		assert !isTimesOverflow(this.numerator(), b.numerator()): "Times Overflow";
		int num = this.numerator() * b.numerator();
		int common = gcd(num, deno);
		Rational mul = new Rational(num / common, deno / common);
		return mul;
	}
	
	public Rational divides(Rational b) {
		assert !isTimesOverflow(this.denominator(), b.numerator()): "Times Overflow";
		int deno = this.denominator() * b.numerator();
		assert !isTimesOverflow(this.numerator(), b.denominator()): "Times Overflow";
		int num = this.numerator() * b.denominator();
		int common = gcd(num, deno);
		Rational div = new Rational(num / common, deno / common);
		return div;
	}
	
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (this.getClass() != obj.getClass()) return false;
		
		Rational that = (Rational) obj;
		int deno = lcm(this.denominator(), that.denominator());
		return deno / this.denominator() * this.numerator() == deno / that.denominator() * that.numerator();
	}
	
	public String toString() {
		if (Math.abs(numerator) % Math.abs(denominator) == 0)
			return String.valueOf(numerator / denominator);
		return numerator + " / " + denominator;
	}
	
	private boolean isPlusOverflow(int a, int b) {
		if (a == 0) return false;
		else if (a > 0) return b > Integer.MAX_VALUE - a;
		else return b < Integer.MIN_VALUE - a;
	}
	
	private boolean isTimesOverflow(int a, int b) {
		if (a == 0 || b == 0) return false;
		else if (a > 0 && b > 0) {
			return b > Integer.MAX_VALUE / a;
		}
		else if (a < 0 && b < 0) {
			return b < Integer.MAX_VALUE / a;
		}
		else if (a < 0 && b > 0) {
			return b > Integer.MIN_VALUE / a;
		}
		else { //a > 0 && b < 0
			return b < Integer.MIN_VALUE / a;
		}
	}
	
	public static void main(String[] args) {
		Rational a = new Rational(13, 15);
		Rational b = new Rational(13, 15);
		System.out.println("a + b: " + a.plus(b));
		System.out.println("a - b: " + a.minus(b));
		System.out.println("a * b: " + a.times(b));
		System.out.println("a / b: " + a.divides(b));
		System.out.println("a = b?: " + a.equals(b));
		System.out.println("a = " + a);
	}

}
