
public class BinarySearchMain {

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(10);
		bst.insert(11);
		bst.insert(3);
		bst.insert(12);
		bst.insert(200);
		bst.insert(-232);
		bst.insert(1);
		bst.insert(1002);
		bst.insert(1);
//		System.out.println(bst.getRoot().getLeftChild().getLeftChild());
//		System.out.println(bst.getRoot().getLeftChild().getRightChild());
//		System.out.println(bst.getRoot().getLeftChild().isLeaf());
//		bst.insert(7);
		bst.inOrderTraversal();
		System.out.println(bst.min());
		//TODO: test other methods here by inserting more elements, testing min, max, etc...
	}

}
