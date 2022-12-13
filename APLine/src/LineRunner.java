
public class LineRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		APLine line1 = new APLine(5.0,4.0,-17.0);
		double slope1=line1.getSlope();
		System.out.println(slope1);
		System.out.println(line1.isOnLine(5, -2.2));
	}

}
