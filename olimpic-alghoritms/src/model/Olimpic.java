package model;

import java.util.ArrayList;
import java.util.Random;

import ui.OlimpicAlgorithmsGUI;

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

	
	
	public void generateArrayList(int n, boolean recursive) throws InterruptedException {
		if(recursive) {
			generateArrayListRecursive(n);
		}else {
			Random random = new Random();
			for(int i = 0; i < n; i++) {
				alAthlete.add(new Info(random.nextLong()));
				Thread.sleep(OlimpicAlgorithmsGUI.SLEEP);
			}
		}
	}
	
	public void generateLinkedList(int n, boolean recursive) throws InterruptedException {
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
				Thread.sleep(OlimpicAlgorithmsGUI.SLEEP);
			}
		}
	}
	
	public void generateTree(int n, boolean recursive) throws InterruptedException {
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
						if( number > addAfter.getNumber()) {
							if(addAfter.getRight() == null) {
								addAfter.setRight(new TreeInfo(number));
								addAfter.getRight().setFather(addAfter);
								search = false;
							}else {
								addAfter = addAfter.getRight();
							}
						}else if( number <= addAfter.getNumber()) {
							if(addAfter.getLeft() == null) {
								addAfter.setLeft(new TreeInfo(number));
								addAfter.getLeft().setFather(addAfter);
								search = false;
							}else {
								addAfter = addAfter.getLeft();
							}
						}
					}
				}
				Thread.sleep(OlimpicAlgorithmsGUI.SLEEP);
			}
		}
	}
	
	public void searchArrayList(int n, boolean recursive) throws InterruptedException {
		if(recursive) {
			searchArrayListRecursive(n, 0, alAthlete.size());
		}else {
			Random random = new Random();
			for(int i = 0; i < n;i++) {
				long number = random.nextLong();
				int pos = 0;
				Info compare = alAthlete.get(pos);
				while(!compare.isMyNumber(number) && alAthlete.get(pos+1)!= null) {
					pos++;
					compare = alAthlete.get(pos);
				}
				Thread.sleep(OlimpicAlgorithmsGUI.SLEEP);
			}
		}
	}
	
	public void searchLinkedList(int n, boolean recursive) throws InterruptedException {
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
				Thread.sleep(OlimpicAlgorithmsGUI.SLEEP);
			}
		}
	}
	
	public void searchTree(int n, boolean recursive) throws InterruptedException {
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
				Thread.sleep(OlimpicAlgorithmsGUI.SLEEP);
			}
		}
	}
	
	public void deleteArrayList(int n, boolean recursive) throws InterruptedException {
		if(recursive) {
			deleteArrayListRecursive(n, 0);
		}else {
			Random random = new Random();
			for(int i = 0; i < n;i++) {		
				long number = random.nextLong();
				int pos = getArrayListPositionOfInfo(number);
				if(alAthlete.get(pos).isMyNumber(number)) {
					alAthlete.remove(pos);
				}
				Thread.sleep(OlimpicAlgorithmsGUI.SLEEP);
			}
		}
	}
	
	public void deleteLinkedList(int n, boolean recursive) throws InterruptedException {
		if(recursive) {
			deleteLinkedListRecursive(n,firstLEAthlete);
		}else {
			Random random = new Random();
			for(int i = 0; i < n;i++) {		
				long number = random.nextLong();
				LinkedListInfo compare = LinkedListInfoOfInfo(number);
				if(compare.isMyNumber(number)) {
					compare.getPrev().setNext(compare.getNext());
				}
				Thread.sleep(OlimpicAlgorithmsGUI.SLEEP);
			}
		}
	}
	
	public void deleteTree(int n, boolean recursive) throws InterruptedException {
		if(recursive) {
			deleteTreeRecursive(n,rootAbbAthlete);
		}else {
			Random random = new Random();
			for(int i = 0; i < n;i++) {		
				long number = random.nextLong();
				TreeInfo compare = getTreeInfoOfInfo(number);
				if(compare.isMyNumber(number)==0) {
					if(compare.getRight() == null && compare.getLeft()==null) {
						if(compare.getFather().getLeft().equals(compare)) {
							compare.getFather().setLeft(null);
						}else {
							compare.getFather().setRight(null);
						}
					}else if(compare.getLeft() != null && compare.getRight() == null) {
						if(compare.getFather().getLeft().equals(compare)) {
							compare.getFather().setLeft(compare.getLeft());
						}else {
							compare.getFather().setRight(compare.getLeft());
						}
					}else if(compare.getRight() != null && compare.getLeft() == null) {
						if(compare.getFather().getLeft().equals(compare)) {
							compare.getFather().setLeft(compare.getLeft());
						}else {
							compare.getFather().setRight(compare.getLeft());
						}
					}else {
						if(compare.getFather().getLeft().equals(compare)) {
							TreeInfo change = compare.getRight();
							while(change.getLeft() !=null) {
								change = change.getLeft();
							}
							change.getFather().setLeft(change.getRight());
							change.setLeft(compare.getLeft());
							change.setRight(compare.getRight());
							compare.getFather().setLeft(change);
							change.setFather(compare.getFather());
							compare.setFather(null);
						}else {
							TreeInfo change = compare.getLeft();
							while(change.getRight() !=null) {
								change = change.getRight();
							}
							change.getFather().setLeft(change.getRight());
							change.setLeft(compare.getLeft());
							change.setRight(compare.getRight());
							compare.getFather().setLeft(change);
							change.setFather(compare.getFather());
							compare.setFather(null);
						}
					}
				}
				Thread.sleep(OlimpicAlgorithmsGUI.SLEEP);
			}
		}
	}
	
	public void generateArrayListRecursive(int n) {}
	
	public void generateLinkedListRecursive(int n) {}
	
	public void generateTreeRecursive(int n) {}
	
	public void searchArrayListRecursive(int n, int min, int max) {}
	
	public void searchLinkedListRecursive(int n, LinkedListInfo list) {}
	
	public void searchTreeRecursive(int n, TreeInfo tree) {}
	
	public void deleteArrayListRecursive(int n,int pos) {}
	
	public void deleteLinkedListRecursive(int n,LinkedListInfo compare) {}
	
	public void deleteTreeRecursive(int n,TreeInfo compare) {}
	/**
	 * </b>Pos:<b> the position couldn't be the element position if the element doesn't exist<br>
	 * @param number
	 * @return int position of the searching element<br>
	 */
	public int getArrayListPositionOfInfo(long number) {
		
		int pos = 0;
		Info compare = alAthlete.get(pos);
		while(!compare.isMyNumber(number)&& alAthlete.get(pos+1)!=null) {
			pos++;
			compare = alAthlete.get(pos);
		}
		return pos;
	}
	/**
	 * 
	 * @param number
	 * @return LinkedListInfo that could or don't be the searching element<br>
	 */
	public LinkedListInfo LinkedListInfoOfInfo(long number) {			
			LinkedListInfo compare = firstLEAthlete;
			while(!compare.isMyNumber(number) && compare.getNext()!= null) {
				compare = compare.getNext();
			}
			if(!compare.isMyNumber(number)) {
				compare = null;	
			}
		return compare;
	}
	
	/**
	 * @param number
	 * @return TreeInfo element that could be or don't be the searching element<br>
	 */
	public TreeInfo getTreeInfoOfInfo(long number) {
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
		return rootAbbAthlete;
	}
}
