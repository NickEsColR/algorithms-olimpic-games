package model;

import java.util.ArrayList;

public class Olimpic {
	
	//relations
	
	private ArrayList<Info> alAthlete;
	private LinkedListInfo firstLEAthlete;
	private TreeInfo rootAbbAthlete;
	
	//methods
	
	public Olimpic() {
		alAthlete = new ArrayList<Info>();
	}

	public ArrayList<Info> getAlAthlete() {
		return alAthlete;
	}

	public void setAlAthlete(ArrayList<Info> alAthlete) {
		this.alAthlete = alAthlete;
	}

	public LinkedListInfo getFirstLEAthlete() {
		return firstLEAthlete;
	}

	public void setFirstLEAthlete(LinkedListInfo firstLEAthlete) {
		this.firstLEAthlete = firstLEAthlete;
	}

	public TreeInfo getRootAbbAthlete() {
		return rootAbbAthlete;
	}

	public void setRootAbbAthlete(TreeInfo rootAbbAthlete) {
		this.rootAbbAthlete = rootAbbAthlete;
	}
	
	public void generateArrayList(long n, boolean recursive) {}
	
	public void generateLinkedList(long n, boolean recursive) {}
	
	public void generateTree(long n, boolean recursive) {}
	
	public void searchArrayList(long n, boolean recursive) {}
	
	public void searchLinkedList(long n, boolean recursive) {}
	
	public void searchTree(long n, boolean recursive) {}
	
	public void deleteArrayList(long n, boolean recursive) {}
	
	public void deleteLinkedList(long n, boolean recursive) {}
	
	public void deleteTree(long n, boolean recursive) {}
	
	public void generateArrayListRecursive(long n) {}
	
	public void generateLinkedListRecursive(long n) {}
	
	public void generateTreeRecursive(long n) {}
	
	public void searchArrayListRecursive(long n, long mid) {}
	
	public void searchLinkedListRecursive(long n, LinkedListInfo list) {}
	
	public void searchTreeRecursive(long n, TreeInfo tree) {}
	
	public void deleteArrayListRecursive(long n) {}
	
	public void deleteLinkedListRecursive(long n) {}
	
	public void deleteTreeRecursive(long n) {}
	
	public long getArrayListPositionOfInfo(long number) {
		return number;}
	
	public LinkedListInfo LinkedListInfoOfInfo(long number) {
		return firstLEAthlete;
	}
	
	public TreeInfo getTreeInfoOfInfo(long number) {
		return rootAbbAthlete;
	}
}
