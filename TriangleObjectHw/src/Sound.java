
public class Sound {
	private int[] noise;
	
	public Sound(int[] n){
		noise = n;
	}
	
	public int limitAmplitude(int limit){
		int changes = 0;
		for(int i=0;i<noise.length;i++){
			if(noise[i] > limit){
				noise[i] = limit;
				changes++;
			}
			else if(noise[i] < -limit){
				noise[i] = -limit;
				changes++;
			}
		}
		return changes;
	}
	
	public void trimSilenceFromBeginning(){
		boolean trim = true;
		while(trim){
			if(noise[0] == 0){
				int[] newN = new int[noise.length-1];
				for(int i=1;i<noise.length;i++){
					newN[i-1] = noise[i];
				}
				noise = newN;
				
			}
			else{
				trim = false;
			}
		}
	}
	
	public void printSound(){
		for(int val: noise){
			System.out.print(val + " ");
		}
		System.out.println();
	}
}
