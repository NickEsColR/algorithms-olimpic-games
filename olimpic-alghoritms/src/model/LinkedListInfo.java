package model;

public class LinkedListInfo {
	
	//attributes
	
	private long number;
	
	//relations
	
	private LinkedListInfo next;
	private LinkedListInfo prev;
	
	//methods
	
	public LinkedListInfo(long n) {
		number = n;
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public LinkedListInfo getNext() {
		return next;
	}

	public void setNext(LinkedListInfo next) {
		this.next = next;
	}

	public LinkedListInfo getPrev() {
		return prev;
	}

	public void setPrev(LinkedListInfo prev) {
		this.prev = prev;
	}
	
	public boolean isMyNumber(long n) {
		return number == n;
	}
}
