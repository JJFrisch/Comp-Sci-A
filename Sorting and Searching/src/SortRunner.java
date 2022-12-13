
public class SortRunner {

	public static void main(String[] args) {
		
		
		BinarySearch s = new BinarySearch(fillInOrder());
		System.out.println(s.toString());
		System.out.println(s.binarySearch(11));

		
		
		
		
		
		
		
		
		
//		final int start = 10;
//		final int end = 200;
//		final int numberOfTrials = 1000;
//		final int jump = 10;
//		
//		for(int i= start; i <= end; i += jump){
//			long time1 = System.currentTimeMillis();
//			BubbleSort x = new BubbleSort(i);
//			for(int j=0; j < numberOfTrials; j++){
//				x.fillRandom();
//				x.sort();
//			}
//			long time2 = System.currentTimeMillis();
//			System.out.println(i + "\t" + (double)(time2-time1)/numberOfTrials);
//			
//		}
		
		
		
		
		
		
		
		
//		BubbleSort x = new BubbleSort(10);
//		x.fillRandom();
//		System.out.println(x.toString());
//		x.sort();
//		System.out.println(x.toString());
		
		
		
		
	}
	
	public static int[] fillInOrder(){
		int[] v = new int[20];
		for(int k=0;k<20;k++){
			v[k] = k*2;
		}
		return v;
	}

}
