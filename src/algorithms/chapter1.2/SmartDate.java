
public class SmartDate {
	private final int month;
	private final int day;
	private final int year;
	
	public SmartDate(int m, int d, int y) {
		if (d < 0 || y < 0) throw new IllegalArgumentException("Illegal negative date!");
		switch(m) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			System.out.println("This is a BIG month!");
			if (d > 31) throw new IllegalArgumentException("Illegal day!");
			break;
		
		case 4:
		case 6:
		case 9:
		case 11:
			System.out.println("This is a SMALL month!");
			if (d > 30) throw new IllegalArgumentException("Illegal day!");
			break;
		
		case 2:  
			System.out.println("This is Feb!");
			if ((y % 4 == 0 && y % 100 !=0) || y % 400 == 0) {
				if (d > 29) throw new IllegalArgumentException("Illegal day!");
			}
			else {
				if (d > 28) throw new IllegalArgumentException("Illegal day!");
			}
			break;
			
		default:
			throw new IllegalArgumentException("Illegal month!");
		}
		
		month = m;
		day = d;
		year = y;
	}
	
	public int month() {
		return month;
	}
	
	public int day() {
		return day;
	}
	
	public int year() {
		return year;
	}
	
	public String toString() {
		return month() + "/" + day() + "/" + year();
	}
	
	public String dayOfTheWeek() {
		int month = this.month;
		int year = this.year;
		if (month <= 2) {
			month += 12;
			year--;
		}
		int week = (day + 1 + 2 * month + 3 * (month + 1) / 5 + year + year / 4 - year / 100 + year / 400) % 7;
		switch (week) {
		case 1:
			return "Monday";
		case 2:
			return "Tuesday";
		case 3:
			return "Wednesday";
		case 4:
			return "Thursday";
		case 5:
			return "Friday";
		case 6:
			return "Saturday";
		case 7:
			return "Sunday";
		default:
			return null;
		}
	}
	
	public static void main(String[] args) {
		SmartDate date = new SmartDate(3, 24, 2020);
		System.out.println(date);
		System.out.println(date.dayOfTheWeek());
	}

}
