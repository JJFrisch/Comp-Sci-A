
public class ArrayProject {
	double[] arr;
	double[][] points;
	public ArrayProject(double[] a){
		arr=a;
	}
	
	
	public void moveOneRight(){
		double[] n = new double[arr.length];
		n[0] = arr[arr.length-1];
		for(int i=0;i<arr.length-1;i++){
			n[i+1] = arr[i];
		}
		arr = n;
	}
	
	public void pointsArray(double[] xVal, double[] yVal){
		points = new double[xVal.length][2];
		for(int i=0;i<xVal.length;i++){
			points[i][0] = xVal[i];
			points[i][1] = yVal[i];
		}
	}
	
	public void reflectY(){
		for(int i=0;i<points.length;i++){
			points[i][0] = points[i][0] * -1;			
		}
	}
	
	public double min(){
		double min = arr[0];
		for(int i=0;i<arr.length;i++){
			if(arr[i] < min){
		         min = arr[i];
			}
		}
		return min;
	}
	
	public static double[] returnListOfPositives(double[] arr) {
		int numPos = 0;
		for(int i=0;i<arr.length;i++){
			if(arr[i] > 0){
				numPos++;
			}
		}
		double[] positives = new double[numPos];
		int pos = 0;
		for(int i=0;i<arr.length;i++){
			if(arr[i] > 0){
				positives[pos] = arr[i];
				pos++;
			}
		}
		return positives;
	}
	
	
	
	public void printArray(){
		for(double val: arr){
			System.out.print(val + " ");
		}
		System.out.println();
	}
}
