import java.util.ArrayList;
import java.util.Collections;

public class Indevidual implements Comparable{
	private int[] vals = new int[8];
	
	
	public Indevidual() {
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for(int i=1;i<=8;i++) {
			nums.add(i);
		}
		Collections.shuffle(nums);
		for(int k=0;k<nums.size();k++) {
			vals[k] = nums.get(k);
		}
	}
	
	public Indevidual(int[] nums) {
		for(int k=0;k<nums.length;k++) {
			vals[k] = nums[k];
		}
	}
	
	public String toString() {
		String toReturn = "";
		for(int i: vals) {
			toReturn += i + " ";
		}
		return toReturn;
	}
	public int getVals(int num) {
		return vals[num];
	}
	
	public int getFitness() {
		int fit = 0;
		for(int i=0;i<vals.length;i++) {
			if(vals[i] == i+1) {
				fit++;
			}
		}
		return fit;
	}
	
	public int compareTo(Object x) {
		Indevidual other = (Indevidual) x;
		return this.getFitness()-other.getFitness();
	}
	
	public void mutate() {
		int i1 = (int) (Math.random()*8);
		int i2 = (int) (Math.random()*8);
		int v1 = vals[i1];
		int v2 = vals[i2];
		vals[i1] = v2;
		vals[i2] = v1;
		
	}
	
	public Indevidual breed(Indevidual other) {
		int[] ret = new int[vals.length];
		for(int i=0;i<ret.length;i++) {
			if(Math.random()>=0.5) {
				ret[i] = vals[i];
			}
			else {
				ret[i] = other.getVals(i);
			}
		}
		return new Indevidual(ret);
	}
}
