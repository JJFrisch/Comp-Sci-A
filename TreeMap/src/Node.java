
public class Node {
	private KeyValue val;
	private Node leftChild;
	private Node rightChild;
	public Node(KeyValue val, Node leftChild, Node rightChild) {
		super();
		this.val = val;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}
	@Override
	public String toString() {
		return "Node [val=" + val + ", leftChild=" + leftChild + ", rightChild=" + rightChild + "]";
	}
	public KeyValue getVal() {
		return val;
	}
	public void setVal(KeyValue val) {
		this.val = val;
	}
	public Node getLeft() {
		return leftChild;
	}
	public void setLeft(Node leftChild) {
		this.leftChild = leftChild;
	}
	public Node getRight() {
		return rightChild;
	}
	public void setRight(Node rightChild) {
		this.rightChild = rightChild;
	}
}
