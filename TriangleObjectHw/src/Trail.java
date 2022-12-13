
public class Trail {
	private int[] markers;
	
	public Trail(int[] m){
		markers = m;
	}
	
	public boolean isLevelTrailSegment(int start, int end){
		int min = markers[start];
		int max = markers[end];
		for(int i=start;i<=end;i++){
			if(markers[i] < min){
				min = markers[i];
			}
			if(markers[i] > max){
				max = markers[i];
			}
		}
		return max-min<=10;
	}
	
	public boolean isDifficult(){
		int largeChanges = 0;
		for(int i = 0;i<markers.length-1;i++){
			if(Math.abs(markers[i] - markers[i+1]) >= 30){
				largeChanges++;
			}
		}
		return largeChanges>=3;
//		if(largeChanges >= 3){
//			return true;
//		}
//		else{
//			return false;
//		}
	}
}
