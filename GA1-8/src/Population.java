import java.util.ArrayList;
import java.util.Collections;

public class Population {
	private ArrayList<Indevidual> pop = new ArrayList<Indevidual>();
	private final double MP = 0.95; //mutation percentage
	
	
	@SuppressWarnings("unchecked")
	public Population(int num) {
		for(int i=0;i<num;i++) {
			pop.add(new Indevidual());
		}
		Collections.sort(pop);
		
	}
	
	public void step() {
		int sSize = pop.size();
		for (int i=0;i<sSize;i++) {
			if(Math.random() <= MP) {
				pop.get(i).mutate();
			}
			double RP = i/sSize;
			if(Math.random() <= RP) {
				pop.add(pop.get(i).breed(pop.get((int)(Math.random()*pop.size()))));
				pop.add(pop.get(i).breed(pop.get(sSize-i)));
				pop.remove(i);

			}
		}
		Collections.sort(pop);
	}
	
	public ArrayList<Indevidual> getPop() {
		return pop;
	}
}
