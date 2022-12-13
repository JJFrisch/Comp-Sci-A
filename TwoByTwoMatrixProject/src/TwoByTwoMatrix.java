public class TwoByTwoMatrix {
	public double getTopLeft() {
		return topLeft;
	}


	public double getTopRight() {
		return topRight;
	}


	public double getBottomLeft() {
		return bottomLeft;
	}


	public double getBottomRight() {
		return bottomRight;
	}

	private double topLeft;
	private double topRight;
	private double bottomLeft;
	private double bottomRight;
	
	
	public TwoByTwoMatrix(double tl, double tr, double bl, double br){
		topLeft = tl;
		topRight = tr;
		bottomLeft = bl;
		bottomRight = br;
	}
	
	
	public String toString(){
		return "[" + topLeft + " " + topRight + " " + bottomLeft + " " + bottomRight + "]";
	}
	
	public double getDeterminant() {
		return topLeft*bottomRight - topRight*bottomLeft;
	}
	
	public boolean hasInverse() {
		if(getDeterminant() <= 0.0000000001 && getDeterminant() >= -0.0000000001){
			return false;
		}
		else{
			return true;
		} 
	}
	
	public TwoByTwoMatrix getInverse() {
		if(this.hasInverse() == false){
			return null;
		}
		else{
			double tl = this.bottomRight/this.getDeterminant();
			double tr = this.topRight*-1/this.getDeterminant();
			double bl = this.bottomLeft*-1/this.getDeterminant();
			double br = this.topLeft/this.getDeterminant();
			
			return new TwoByTwoMatrix(tl, tr, bl, br);
		} 
	}
	
	public TwoByTwoMatrix plus(TwoByTwoMatrix other) {
		double tl = this.topLeft + other.topLeft;
		double tr = this.topRight + other.topRight;
		double bl = this.bottomLeft + other.bottomLeft;
		double br = this.bottomRight + other.bottomRight;
		
		return new TwoByTwoMatrix(tl, tr, bl, br);
	}
	
	public TwoByTwoMatrix times(TwoByTwoMatrix other) {
		double tl = this.topLeft * other.topLeft + this.bottomLeft*other.topRight;
		double tr = this.topLeft * other.topRight + this.topRight*other.bottomRight;
		double bl = this.bottomLeft * other.topLeft + this.bottomRight*other.topLeft;
		double br = this.bottomLeft * other.topRight + this.bottomRight*other.bottomRight;
		
		return new TwoByTwoMatrix(tl, tr, bl, br);
	}
	
	public TwoByTwoMatrix pow(int x) {
		if(x<=0){
			throw new IllegalArgumentException("x must be positive");
		}
		TwoByTwoMatrix a = new TwoByTwoMatrix(topLeft, topRight, bottomLeft, bottomRight);
		for(int i=0;i<x-1;i++){
			a = a.times(this);
		}
		return a;
	}
}
