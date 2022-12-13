import java.util.Arrays;

public class BinarySearch {
	private int[] vals;
	public BinarySearch(int[] v){
		vals = new int[v.length];
		for(int i=0;i<v.length;i++){
			vals[i] = v[i];
		}
	}
	
	public int binarySearch(int key){
		return binarySearch(key,0,vals.length-1);
	}
	
	private int binarySearch(int key,int low, int high){
		if(low>high){
			return -1;
		}
		int mid = (low+high)/2;
		if(vals[mid] == key){
			return mid;
		}
		else if (vals[mid] > key){
			return binarySearch(key, low, mid-1);
		}
		else{
			return binarySearch(key,mid+1,high);
		}
	}

	@Override
	public String toString() {
		return "BinarySearch [vals=" + Arrays.toString(vals) + "]";
	}
}
