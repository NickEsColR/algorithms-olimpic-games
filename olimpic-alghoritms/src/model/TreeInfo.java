package model;

public class TreeInfo {
	
	//attributes
	
	private long number;
	
	//relations
	
	private TreeInfo father;
	private TreeInfo right;
	private TreeInfo left;
	
	//methods
	public TreeInfo(long n) {
		number = n;
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public TreeInfo getFather() {
		return father;
	}

	public void setFather(TreeInfo father) {
		this.father = father;
	}

	public TreeInfo getRight() {
		return right;
	}

	public void setRight(TreeInfo right) {
		this.right = right;
	}

	public TreeInfo getLeft() {
		return left;
	}

	public void setLeft(TreeInfo left) {
		this.left = left;
	}
	
	public long isMyNumber(long n) {
		return number - n;
	}
}
