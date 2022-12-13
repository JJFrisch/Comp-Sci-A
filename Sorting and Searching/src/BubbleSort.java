import java.util.Random;

public class BubbleSort {
	private int vals[];
	
	public BubbleSort(int n){
		vals = new int[n];
	}
	
	public BubbleSort(int[] n){
		vals = n;
	}
	
	public void fillRandom(){
		Random r = new Random();
		int len = vals.length;
		for(int i=0;i<len;i++){
			vals[i] = r.nextInt(2*(len*len) - (len*len));
		}
	}
	
	public String toString(){
		String s = "[";
		for(int x:vals){
			s+=x+" ";
		}
		s+="]";
		return s;
		
	}
	
	private void swap(int a,int b){
		int temp = vals[a];
		vals[a] = vals[b];
		vals[b] = temp;
	}

	public void sort() {
		boolean swapMade = false;
		int lastIndex = vals.length - 2;
		do{
			swapMade = false;
			for(int g =0;g<= lastIndex;g++){
				if(vals[g]>vals[g+1]){
					swap(g,g+1);
					swapMade = true;
				}
			}
			lastIndex--;			
		}while (swapMade);
		
	}
	
	
}

