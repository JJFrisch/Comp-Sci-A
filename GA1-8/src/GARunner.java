
public class GARunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double sampleSize = 100;
		double tot = 0;
		for(int i=0;i<sampleSize;i++) {
			Population p = new Population(10000);
			int itt = 0;
			while(p.getPop().get(p.getPop().size()-1).getFitness() < 8) {
				itt++;
				p.step();
			}
			tot += itt;
		}
		
		System.out.println(tot/sampleSize);

		
		
//		double high = 0;
//		for(int i=0;i<100000;i++) {
//			Indevidual x1 = new Indevidual();
//			if(x1.getFitness() > high) {
//				System.out.println(x1);
//				System.out.println(x1.getFitness() + " " + i);
//				high = x1.getFitness();
//			}
//		}
//		System.out.println(high);
	}

}
