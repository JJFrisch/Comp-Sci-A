
public class BTRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(7,null,null);
		TreeNode kat = new TreeNode(1,null,null);
		TreeNode katL = new TreeNode(5,null,null);
		TreeNode aaron = new TreeNode(1,null,null);
		TreeNode becky = new TreeNode(7,null,null);
		root.setLeft(kat);
		root.setRight(katL);
		kat.setLeft(aaron);
		kat.setRight(becky);
		
		int sumOfTree = calcSum(root);
		System.out.println(sumOfTree);
		
		
	}
	
	public static int calcSum(TreeNode t){
		if (t == null){
			return 0;
		}
		int sum = t.getVal() + calcSum(t.getRight()) + calcSum(t.getLeft());
		return sum;
	}

}
