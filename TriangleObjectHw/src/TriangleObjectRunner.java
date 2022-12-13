import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;


public class TriangleObjectRunner {

	public static void main(String[] args) {
		
		//four AP test problems
		int[] arr3 = {0,0,0,-10,1,7,2,0};
		Sound z = new Sound(arr3);
		System.out.println(z.limitAmplitude(5));
		z.printSound();
		z.trimSilenceFromBeginning();
		z.printSound();
		
		
		int[] arr = {1,2,2,2};
		Robot x = new Robot(arr,1);
		System.out.println(x.clearHall());
		
		int[] arr2 = {115,105,109,170,111,100,199};
		Trail y = new Trail(arr2);
		System.out.println(y.isLevelTrailSegment(0,4));
		System.out.println(y.isDifficult());
		
		double[] arr4 = {0,9,0,-10,1,7,2,-2};
		ArrayProject x4 = new ArrayProject(arr4);
		x4.moveOneRight();
		x4.printArray();
		
		
		
		
	}
	
	public static int findMax(int[] arr){
		int maxVal = arr[0];
		for(int i=1;i<arr.length;i++){
			if(arr[i] > maxVal){
				maxVal = arr[i];
			}
		}
		return maxVal;
	}
	
	public static int[] findIndexesOfMax(int[] arr){
		int maxVal = findMax(arr);
		int countToAdd = 0;
		for(int i=0;i<arr.length;i++){
			if(arr[i] == maxVal){
				countToAdd++;
			}
		}
		int[] indexes = new int[countToAdd];
		for(int i=0;i<arr.length;i++){
			if(arr[i] == maxVal){
				indexes[indexes.length-countToAdd] = i;
				countToAdd--;
			}
		}
		return indexes;
	}

}
