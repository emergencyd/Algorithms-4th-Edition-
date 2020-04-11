import edu.princeton.cs.algs4.Date;

public class Transaction {
	private String who;
	private Date when;
	private double amount;
	
	public Transaction(String who, Date when, double amount) {
		this.who = who;
		this.when = when;
		this.amount = amount;
	}
	
	public Transaction(String args) {
		String[] info = args.split("\\s+");
		this.who = info[0];
		this.when = new Date(info[1]);
		this.amount = Double.parseDouble(info[2]);
	}
	
	public String who() {
		return who;
	}
	
	public Date when( ) {
		return when;
	}
	
	public double amount() {
		return amount;
	}
	
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		Transaction that = (Transaction) obj;
		return who.equals(that.who()) && when.equals(that.when()) && amount == that.amount();
	}
	
	public String toString() {
		return who + " at " + when + " transact " + amount;
	}
	
	public static void main(String[] args) {
		Date when1 = new Date(3, 25, 2020);
		Transaction tran1 = new Transaction("deng", when1, 100);
		Transaction tran2 = new Transaction("deng 3/25/2020 100");
		System.out.println(tran1);
		System.out.println(tran1.equals(tran2));
		
	}

}
