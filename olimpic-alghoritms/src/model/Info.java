package model;

public class Info {
	
	//attributes
	private long number;
	
	//methods
	
	public Info(long n) {
		number = n;
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}
	
	public boolean isMyNumber(long n) {
		return number == n;
	}

}