import java.awt.Color;

public class TurtleRunner {

	public static void main(String[] args) {
		SuperTurtle draw = new SuperTurtle(); // Added methods to the Turtle class
		
		draw.moveToo(400.0, 300.0);
		draw.setPenRadius(20);
		draw.setPenColor(Color.lightGray);
		draw.normalShape(200, 4);
		draw.setPenColor(Color.green);
		draw.setPenRadius(6);
		draw.moveOver(-40, 10);
		draw.normalShape(200, 1);
		draw.moveOver(-100, 00);
		draw.normalShape(200, 1);
		draw.moveOver(50, -100);
		draw.setPenColor(Color.red);
		draw.semiCircle(3);
		draw.moveOver(50, 210);
		draw.setPenColor(Color.darkGray);
		draw.normalShape(3, 40);
		draw.moveOver(40, 0);
		draw.normalShape(3, 40);
		draw.moveOver(30, -20);
		draw.normalShape(3, 40);
		draw.moveOver(-20, -20);
		draw.normalShape(3, 50);
		draw.moveOver(-30, 10);
		draw.normalShape(3, 20);
		draw.moveOver(-100, -10);
		draw.normalShape(3, 40);
		draw.moveOver(40, 10);
		draw.normalShape(3, 40);
		draw.moveOver(-10, 30);
		draw.normalShape(3, 40);

		draw.randomColor();
		
		draw.show();
	}

}