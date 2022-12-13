import java.util.Random;
import java.awt.Color;


public class SuperTurtle extends Turtle {
	Turtle john = new Turtle();
	String[] colors = {"black", "blue", "cyan", "darkGrey", "green", "lightGray", "magenta", "orange", "pink", "red", "white", "yellow", "gray"};
	
	public static void main(String[] args) {
		
	}
	
	public void normalShape(double sides, double sideLength) {		
		for (int i = 0; i < sides; i++) {
			john.goForward(sideLength);
			john.turnLeft(360/sides);
		}
		
	}
	
	public void semiCircle(double sideLength) {		
		for (int i = 0; i < 50; i++) {
			john.goForward(sideLength);
			john.turnLeft(3.6);
		}
		
	}
		
	public void moveOver(double x, double y){
		john.setX(john.getX()+x);
		john.setY(john.getY()+y);
	}
	
	public void moveToo(double x, double y){
		john.setX(x);
		john.setY(y);
	}
	
	public void squareSlowly() {		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 50 ; j++) {
				john.goForward(1);
				john.pause(10);
				john.show();
			}
			john.turnLeft(90);
		}
		
	}
	
	public void rectangle(double sides1, double sides2) {		
		for (int i = 0; i < 2; i++) {
			john.goForward(sides1);
			john.turnLeft(90);
			john.goForward(sides2);
			john.turnLeft(90);
		}
		
	}
	
	public void shadedPolygon(double sides, double length) {
		while (length > 0) {
			for (int i = 0; i < sides; i++) {
				for (int j = 0; j < length ; j++) {
					john.goForward(1);
//					john.pause(1);
//					john.show();
				}
				john.turnLeft(360.0/sides);
			
			}		
			length--;
		}
	}
	
	
	public void randomColor() {
		Random rand = new Random();
		Color randomColor = new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));
		john.setPenColor(randomColor);
	}

}


