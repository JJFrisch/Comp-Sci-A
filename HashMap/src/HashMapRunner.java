
public class HashMapRunner {

	public static void main(String[] args) {
		
		String letters = "qwertyuiopasdfghjklzxcvbnmmQWERYUIOPPTASDFGHJKLZXCVBNM1";
		int dataPoints  = 100;
		int numPuts = 0;
		int increment = 2000;
		OurHM x = new OurHM();

		for(int k=0;k<dataPoints;k++) {
			String[] keys = new String [numPuts];
			for(int l=0;l<numPuts;l++) {
				int size = (int) (Math.random()*80+1);
				String s = "";
				for (int q=0;q<size;q++) {
					int ind = (int) (Math.random()*letters.length());
					s += letters.substring(ind,ind+1);
				}
				int num = (int)(Math.random()*200000);
				keys[l] = s + " " + num;
				x.put(s + " " + num, "yo");
			}
			long start = System.currentTimeMillis();
			for(int l=0;l<numPuts;l++) {
				x.get(keys[l]);
				
			}
			long finish = System.currentTimeMillis();
			long timeElapsed = finish - start;
			System.out.println(k + " \t " + timeElapsed);
			numPuts += increment;
		}
		
		
		
		
		
		
		
		
		
		
		
		
//		String letters = "qwertyuiopasdfghjklzxcvbnmmQWERYUIOPPTASDFGHJKLZXCVBNM1";
		
//		OurHM x = new OurHM();
//		x.put("Jake", "Cars");
//		x.put("Richard", "Cars");
//		x.put("Alan", "Deadpool");
//		x.put("Jake3", "hello3");
//		x.put("Jake4", "hello4");
//		x.put("Jake", "hello5");
//		for(int i=0;i<2000;i++) {
//			int size = (int) (Math.random()*8+1);
//			String s = "";
//			for (int k=0;k<size;k++) {
//				int ind = (int) (Math.random()*letters.length());
//				s += letters.substring(ind,ind+1);
//			}
//			x.put(s + " " + (Math.random()*2000), "yo");
//			
//		}
//		System.out.println(x);
//		System.out.println(x.get("Jake"));
	}
	
}
