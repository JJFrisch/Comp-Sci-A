
public class MatrixRunner {

	public static void main(String[] args) {
		TwoByTwoMatrix x = new TwoByTwoMatrix(1,2,3,4);
		TwoByTwoMatrix y = new TwoByTwoMatrix(1,2,3,4);
		System.out.println(x==y);
		System.out.println(x.pow(3));
	}

}
