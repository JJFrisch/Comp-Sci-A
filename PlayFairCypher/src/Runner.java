
public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String val = "ioenxxxqropr..o02f,34lf.l";
		PlayFairCypherRunner x = new PlayFairCypherRunner(val);
		String Em = x.encrypt("xanthinars guide is worder");
		String message = x.decrypt(Em);
		
		System.out.println(Em);
		System.out.println(message);
		
//		int z = 17;
//		int y = 20;
//		System.out.println(Integer.toBinaryString(z));
//		System.out.println(Integer.toBinaryString(z >> 30));
	}

}
