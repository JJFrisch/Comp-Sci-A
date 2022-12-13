import java.util.ArrayList;
import java.util.Random;

@SuppressWarnings("unused")
public class ALrunner {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedList x = new LinkedList<String>();
		x.push("1");
		x.push("2");
		LinkedList y = new LinkedList<String>();
		y.push("3");
		y.push("4");
		x.print();
		y.print();
		x.attachTo(y);
		x.print();
		y.print();
		System.out.println(x.peek());
		
		
		
//		for(Object a:x){
//			System.out.print(a + " * "); // Proves itirableness haha
//		}
		
		
//		Integer[] list = {1,2,4,1,-2,9};
//		ALExtra x = new ALExtra(list);
//		x.add("wow");
//		for(Object a:x){
//			System.out.print(a);
//		}
//		x.print();
		

	}

}
