
public class Triangle { //good job 1/1
	private double sideA; //good job 2/2
	private double sideB;//  ^
	private double sideC; // ^
	
	private double sumType;
	private double biggestSide;
	
	
	public Triangle(double a, double b, double c){
		if(a>0 && b>0 && c>0){
			sideA = a;
			sideB = b;
			sideC = c;
			
			if(sideA<=sideC && sideB<=sideC){
				sumType = sideA*sideA+sideB*sideB;
				biggestSide = sideC;
			}
			else if(sideA<sideB && sideC<sideB){
				sumType = sideA*sideA+sideC*sideC;
				biggestSide = sideB;
			}
			else if(sideB<sideA && sideC<sideA){
				sumType = sideB*sideB+sideC*sideC;
				biggestSide = sideA;
			}
		}
		else{
//			System.out.println("Error: Side lengths must be positive values.");
			throw new IllegalArgumentException();
		}
	}
	
	
	public void setSideB(int a){
		sideB = a;
	}
	
	public double getSideB(){
		return sideB;
	}
	
	public double getSideC(){
		return sideC;
	}
	
	public boolean isAnIsoscelesTriangle() {
		if(sumType>biggestSide*biggestSide){
			return true;
		}
		else{
			return false;
		} 
	}
	
	public boolean isARightTriangle() {
		if(sumType==biggestSide*biggestSide){
			return true;
		}
		else{
			return false;
		} 
	}

	
	public double getArea() {
		double s = (sideA+sideB+sideC)/2;
		double area = Math.sqrt(s*(s-sideA)*(s-sideB)*(s-sideC));
		return area;
	}

}
