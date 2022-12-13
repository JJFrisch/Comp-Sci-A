
public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] x = {{1,2,2,2,3},
				{0,0,2,0,0},
				{2,3,4,5,6},
				{3,2,4,9,0}};
		
		A obj1 = new B(); // Line 1

		B obj2 = new B(); // Line 2

		System.out.println(obj1.message(3));   // Line 3

		System.out.println(obj2.message(2));   // Line 4
//		print2D(array2d.alternateTrueFalse(4, 4));
		
		
		
		
//		String[][] s = {{"lwoxw"}, {"oo"}};
//		String[] y = array2d.getBottomRow(s);
//		print1D(y);
		
		//2021 #4 AP PROBLEM
//		int[][] newx = Resizer2021_4.resize(x);
//		print2D(newx);

		
	}
	
	
	public static void print2D(int[][] x){
		for(int i=0;i<x.length;i++){
			for(int k=0;k<x[i].length;k++){
				System.out.print(x[i][k] + " ");
			}
			System.out.println();
		}
	}
	public static void print2D(boolean[][] x){
		for(int i=0;i<x.length;i++){
			for(int k=0;k<x[i].length;k++){
				System.out.print(x[i][k] + " ");
			}
			System.out.println();
		}
	}
	public static void print1D(String[] y){
		for(int i=0;i<y.length;i++){
			System.out.print(y[i] + " ");
		}
		System.out.println();
	}
	
	public class A

	{

		public class A

		{

		public String message(int i)

		{

		return "A" + i;

		}

		}

	public class B extends A

		{

		public String message(int i)

		{

		return "B" + i;

		}

		}}

	

}
