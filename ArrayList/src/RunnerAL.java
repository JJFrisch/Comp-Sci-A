import java.util.*;


public class RunnerAL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> x = new ArrayList<String>();  
		x.add("Mildred");
		x.add("Mildred");
		x.add("Mildred");
		removeMildred(x);
		System.out.println(x);
	
		
	}
	
	
	public static double calcSum(ArrayList<Double> list){
		double sum = 0;
		for(int i=0;i<list.size();i++){
			sum += list.get(i);
		}
		return sum;
	}
	
	
	public static void removeMildred(ArrayList<String> names){
//		names.removeIf(=="mildred");
//		for(int i=0;i<names.size();i++){
//			if(names.get(i).equals("Mildred")){
//				names.remove(i);
//				i--;
//			}
//		}
	}

}
