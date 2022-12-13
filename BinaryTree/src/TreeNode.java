
public class TreeNode {
	private int val;
	private TreeNode right;
	private TreeNode left;

	
	public TreeNode(int val, TreeNode right, TreeNode left) {
		super();
		this.val = val;
		this.right = right;
		this.left = left;
	}
	
	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}

	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	@Override
	public String toString() {
		return "TreeNode [val=" + val + ", right=" + right + ", left=" + left + "]";
	}
	
	

}
