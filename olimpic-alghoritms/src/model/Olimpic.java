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
			generateLinkedListRecursive(n,firstLEAthlete);
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
		Random random = new Random();
		if(recursive) {
			generateTreeRecursive(n,rootAbbAthlete,random.nextLong());
		}else {
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
		Random random = new Random();
		if(recursive) {
			searchArrayListRecursive( 0,random.nextLong(),n);
		}else {
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
	
	public void setAlAthlete(ArrayList<Info> alAthlete) {
		this.alAthlete = alAthlete;
	}

	public void setFirstLEAthlete(LinkedListInfo firstLEAthlete) {
		this.firstLEAthlete = firstLEAthlete;
	}

	public void setRootAbbAthlete(TreeInfo rootAbbAthlete) {
		this.rootAbbAthlete = rootAbbAthlete;
	}

	public void searchLinkedList(int n, boolean recursive) throws InterruptedException {
		Random random = new Random();
		if(recursive) {
			searchLinkedListRecursive(n, firstLEAthlete,random.nextLong());
		}else {
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
		Random random = new Random();
		if(recursive) {
			searchTreeRecursive(n,rootAbbAthlete,random.nextLong());
		}else {
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
		Random random = new Random();
		if(recursive) {
			deleteArrayListRecursive(n, 0,random.nextLong());
		}else {
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
		Random random = new Random();
		if(recursive) {
			deleteLinkedListRecursive(n,firstLEAthlete,random.nextLong());
		}else {
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
		Random random = new Random();
		if(recursive) {
			deleteTreeRecursive(n,rootAbbAthlete,random.nextLong());
		}else {
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
	
	public void generateArrayListRecursive(int n) {
		Random random = new Random();
		if(n != 0) {
			alAthlete.add(new Info(random.nextLong()));
			n--;
			generateArrayListRecursive(n);
		}
	}
	
	public void generateLinkedListRecursive(int n,LinkedListInfo actual) {
		Random random = new Random();
		if(n!=0) {
			long number = random.nextLong();
			if(firstLEAthlete == null) {
				firstLEAthlete = new LinkedListInfo(number);
			}else {
				if(actual.getNext() == null) {
					actual.setNext(new LinkedListInfo(number));
					actual.getNext().setPrev(actual);
					n--;
					generateLinkedListRecursive(n,actual.getNext());
				}else {
					generateLinkedListRecursive(n, actual.getNext());
				}
			}
		}
	}
	
	public void generateTreeRecursive(int n,TreeInfo actual,long number) {
		Random random = new Random();
		if(n != 0) {
			
			if(rootAbbAthlete == null) {
				rootAbbAthlete = new TreeInfo(number);
			}else {
				if(actual.isMyNumber(number)<0) {
					if(actual.getRight()!=null) {
						actual.getRight();
					}else {
						actual.setRight(new TreeInfo(number));
						actual.getRight().setFather(actual);
						n--;
						actual = rootAbbAthlete;
						number = random.nextLong();
					}
				}else {
					if(actual.getLeft()!=null) {
						actual.getLeft();
					}else {
						actual.setLeft(new TreeInfo(number));
						actual.getLeft().setFather(actual);
						n--;
						actual = rootAbbAthlete;
						number = random.nextLong();
					}
					
				}
			}
			generateTreeRecursive(n,actual,number);
		}
	}
	
	public void searchArrayListRecursive(int pos, long number, int n) {
		if(n != 0) {
			Random random = new Random();
			if(alAthlete.get(pos).isMyNumber(number)) {
				n--;
				searchArrayListRecursive(0,random.nextLong(),n);
			}else {
				pos++;
				searchArrayListRecursive(pos,number,n);
			}
		}
	}
	
	
	public void searchLinkedListRecursive(int n, LinkedListInfo list,long number) {
		if(n != 0) {
			Random random = new Random();
			if(list.isMyNumber(number)) {
				n--;
				searchLinkedListRecursive(n,firstLEAthlete,random.nextLong());
			}else {
				if(list.getNext()!=null) {
					searchLinkedListRecursive(n,list.getNext(),number);
				}else {
					n--;
					searchLinkedListRecursive(n,firstLEAthlete,random.nextLong());
				}
			}
		}
	}
	
	public void searchTreeRecursive(int n, TreeInfo tree,long number) {
		if(n != 0) {
			Random random = new Random();
			if(tree.isMyNumber(number)<0) {
				if(tree.getRight()!=null) {
					searchTreeRecursive(n,tree.getRight(),number);
				}else {
					n--;
					searchTreeRecursive(n,rootAbbAthlete,random.nextLong());
				}
			}else if(tree.isMyNumber(number)==0) {
				n--;
				searchTreeRecursive(n,rootAbbAthlete,random.nextLong());
			}else {
				if(tree.getLeft()!=null) {
					searchTreeRecursive(n,tree.getLeft(),number);
				}else {
					n--;
					searchTreeRecursive(n,rootAbbAthlete,random.nextLong());
				}
			}
		}
	}
	
	public void deleteArrayListRecursive(int n,int pos, long number) {
		if(n != 0) {
			Random random = new Random();
			
			if(alAthlete.get(pos).isMyNumber(number)) {
				alAthlete.remove(pos);
				n--;
				searchArrayListRecursive(0,random.nextLong(),n);
			}else if(pos<alAthlete.size()){
				pos++;
				searchArrayListRecursive(pos,number,n);
			}else {
				n--;
				searchArrayListRecursive(0,random.nextLong(),n);
			}
		}
	}
	
	public void deleteLinkedListRecursive(int n,LinkedListInfo compare,long number) {
		if(n != 0) {
			Random random = new Random();
			if(compare.isMyNumber(number)) {
				if(compare.equals(firstLEAthlete)) {
					compare = firstLEAthlete.getNext();
					compare.setPrev(null);
					firstLEAthlete = compare;
				}else {
					compare.getPrev().setNext(compare.getNext());
					compare.getNext().setPrev(compare.getPrev());
				}
				n--;
				deleteLinkedListRecursive(n,firstLEAthlete,random.nextLong());
			}else {
				if(compare.getNext()!=null) {
					deleteLinkedListRecursive(n,compare.getNext(),number);
				}else {
					n--;
					deleteLinkedListRecursive(n,firstLEAthlete,random.nextLong());
				}
			}
		}
	}
	
	public void deleteTreeRecursive(int n,TreeInfo compare,long number) {
		if(n != 0) {
			Random random = new Random();
			if(compare.isMyNumber(number)<0) {
				if(compare.getRight()!=null) {
					searchTreeRecursive(n,compare.getRight(),number);
				}else {
					n--;
					searchTreeRecursive(n,rootAbbAthlete,random.nextLong());
				}
			}else if(compare.isMyNumber(number)==0) {
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
			
				n--;
				searchTreeRecursive(n,rootAbbAthlete,random.nextLong());
			}else {
				if(compare.getLeft()!=null) {
					searchTreeRecursive(n,compare.getLeft(),number);
				}else {
					n--;
					searchTreeRecursive(n,rootAbbAthlete,random.nextLong());
				}
			}
		}
	}
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
