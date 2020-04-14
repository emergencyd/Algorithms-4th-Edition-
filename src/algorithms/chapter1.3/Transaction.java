import edu.princeton.cs.algs4.Date;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;

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
	
	public String who() {return who;}
	public Date when( ) {return when;}
	public double amount() {return amount;}
	
	public static Transaction[] readTran(String name) {
		In in = new In(name);
		Queue<Transaction> q = new Queue<Transaction>();
		while (!in.isEmpty())
			q.enqueue(new Transaction(in.readString(), new Date(in.readString()), Double.parseDouble(in.readString())));
		int N = q.size();
		Transaction[] a = new Transaction[N];
		for (int i = 0; i < N; i++) {
			a[i] = q.dequeue();
		}
		return a;
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
		Transaction[] trans = Transaction.readTran("Trans.txt");
		for (int i = 0; i < trans.length; i++) {
			System.out.println(trans[i]);
		}	
	}

}
