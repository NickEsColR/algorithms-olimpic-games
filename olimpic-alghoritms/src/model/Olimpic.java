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

	
	
	public void generateArrayList(int n, boolean recursive) {
		if(recursive) {
			generateArrayListRecursive(n);
		}else {
			Random random = new Random();
			for(int i = 0; i < n; i++) {
				alAthlete.add(new Info(random.nextLong()));
			}
		}
	}
	
	public void generateLinkedList(int n, boolean recursive) {
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
	
	public void generateTree(int n, boolean recursive) {
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
	
	public void searchArrayList(int n, boolean recursive) {
		if(recursive) {
			searchArrayListRecursive(n, 0, alAthlete.size());
		}else {
			Random random = new Random();
			int min = 0;
			int max = alAthlete.size();
			for(int i = 0; i < n;i++) {
				long number = random.nextLong();
				int mid =(min + max)/2;
				Info compare = alAthlete.get(mid);
				while(compare.isMyNumber(number) != 0 && min != max) {
					if(compare.isMyNumber(number)> 0) {
						max = mid-1;
					}else {
						min = mid +1;
					}
					compare = alAthlete.get(mid);
				}
			}
		}
	}
	
	public void searchLinkedList(int n, boolean recursive) {
		if(recursive) {
			searchLinkedListRecursive(n, firstLEAthlete);
		}else {
			Random random = new Random();
			for(int i = 0; i < n;i++) {			
				long number = random.nextLong();
				LinkedListInfo compare = firstLEAthlete;
				while(!compare.isMyNumber(number) && compare.getNext()!= null) {
					compare = compare.getNext();
				}
			}
		}
	}
	
	public void searchTree(int n, boolean recursive) {
		if(recursive) {
			searchTreeRecursive(n,rootAbbAthlete);
		}else {
			Random random = new Random();
			for(int i = 0; i < n;i++) {			
				long number = random.nextLong();
				TreeInfo compare = rootAbbAthlete;
				boolean find = false;
				while(!find) {
					if(compare.isMyNumber(number)<0) {
						if(compare.getRight()!= null) {
							compare = compare.getRight();
						}else {
							find = true;
						}
					}else if(compare.isMyNumber(number) > 0) {
						if(compare.getLeft() != null) {
							compare = compare.getLeft();
						}else {
							find = true;
						}
					}else {
						find = true;
					}
				}
			}
		}
	}
	
	public void deleteArrayList(int n, boolean recursive) {}
	
	public void deleteLinkedList(int n, boolean recursive) {}
	
	public void deleteTree(int n, boolean recursive) {}
	
	public void generateArrayListRecursive(int n) {}
	
	public void generateLinkedListRecursive(int n) {}
	
	public void generateTreeRecursive(int n) {}
	
	public void searchArrayListRecursive(int n, int min, int max) {}
	
	public void searchLinkedListRecursive(int n, LinkedListInfo list) {}
	
	public void searchTreeRecursive(int n, TreeInfo tree) {}
	
	public void deleteArrayListRecursive(int n) {}
	
	public void deleteLinkedListRecursive(int n) {}
	
	public void deleteTreeRecursive(int n) {}
	
	public int getArrayListPositionOfInfo(long number) {
		return 0;}
	
	public LinkedListInfo LinkedListInfoOfInfo(long number) {
		return firstLEAthlete;
	}
	
	public TreeInfo getTreeInfoOfInfo(long number) {
		return rootAbbAthlete;
	}
}
