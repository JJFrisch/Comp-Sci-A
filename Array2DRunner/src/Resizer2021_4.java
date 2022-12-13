
public class Resizer2021_4 {
	
	
	
	public static boolean isNonZeroRow(int[][] arr2, int r){
		for(int val:arr2[r]){
			if(val == 0){
				return false;
			}
		}
		return true;
	}
	
	public static int numNonZeroRow(int[][] arr2){
		int num = 0;
		for(int i=0;i<arr2.length;i++){
			if(isNonZeroRow(arr2,i)){
				num++;
			}
		}
		return num;
	}
	
	
	public static int[][] resize(int[][] arr2){
		int[][] newArr = new int[numNonZeroRow(arr2)][arr2[0].length];
		int pos = 0;
		for(int i=0;i<arr2.length;i++){
			if(isNonZeroRow(arr2,i)){
				for(int k=0;k<arr2[i].length;k++){
					newArr[pos][k] = arr2[i][k];
				}
				pos++;
			}
		}
		return newArr;
	}
}
