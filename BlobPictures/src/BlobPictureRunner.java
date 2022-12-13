
public class BlobPictureRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,2,3,4,5};
		changeArr(a);
		System.out.println(a[0]);
		int st = 45+25+20+25+45+10+60+10 - 80;
		System.out.println(st);
	}
	
	
	public static void changeIntParam(int x) {
		x = 99;
	}
	
	public static void changeStrParam(String s) {
		s += "Mildred";
	}
	
	public static void changeArr(int[] a) {
		a = new int[] {9,4,3,2,1,2,3,4};
	}
//	Vig-45 Mind-25 End- Str-30 Dex-50 Fai-10 Int-60 Arc-10

}
