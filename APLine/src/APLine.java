
public class APLine {

	private double a;
	private double b;
	private double c;
	
	public APLine(double aVal, double bVal, double cVal) {
		a=aVal;
		b=bVal;
		c=cVal;
	}
	
	public double getSlope(){
		return -a/b;
	}
	
	public boolean isOnLine(double x, double y){
		if((a*x)+(b*y)+c == 0){
			return true;
		}
		else{
			return false;
		}
	}

}
