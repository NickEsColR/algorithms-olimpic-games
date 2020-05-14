package model;

import java.util.ArrayList;
import java.util.Random;

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



	public LinkedListInfo getFirstLEAthlete() {
		return firstLEAthlete;
	}



	public TreeInfo getRootAbbAthlete() {
		return rootAbbAthlete;
	}

	
	
	public void generateArrayList(long n, boolean recursive) {
		if(recursive) {
			generateArrayListRecursive(n);
		}else {
			Random random = new Random();
			for(int i = 0; i < n; i++) {
				alAthlete.add(new Info(random.nextLong()));
			}
		}
	}
	
	public void generateLinkedList(long n, boolean recursive) {
		if(recursive) {
			generateLinkedListRecursive(n);
		}else {
			Random random = new Random();
			firstLEAthlete = new LinkedListInfo(random.nextLong());
			LinkedListInfo addAfter = firstLEAthlete;
			for(int i = 1; i < n; i++) {
				addAfter.setNext(new LinkedListInfo(random.nextLong()));
				addAfter.getNext().setPrev(addAfter);
				addAfter = addAfter.getNext();
			}
		}
	}
	
	public void generateTree(long n, boolean recursive) {
		if(recursive) {
			generateTreeRecursive(n);
		}else {
			Random random = new Random();
			rootAbbAthlete = new TreeInfo(random.nextLong());
			for(int i = 1; i < n; i++) {
				long number = random.nextLong();
				boolean search = true;
				TreeInfo addAfter = rootAbbAthlete;
				while(search) {
					if(addAfter.getRight() != null && addAfter.getLeft() != null) {
						if(number > addAfter.getNumber()) {
							addAfter.getRight();
						}else {
							addAfter.getLeft();
						}
					}else {
						if(addAfter.getRight() == null && number > addAfter.getNumber()) {
							addAfter.setRight(new TreeInfo(number));
							search = false;
						}else if(addAfter.getRight() == null && number <= addAfter.getNumber()) {
							addAfter.setLeft(new TreeInfo(number));
							search = false;
						}else {
							addAfter = addAfter.getRight() != null ? addAfter.getRight() : addAfter.getLeft();
						}
					}
				}
			}
		}
	}
	
	public void searchArrayList(long n, boolean recursive) {
		
	}
	
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
