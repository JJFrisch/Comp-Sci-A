import java.awt.Color;

public class Circle {
	private float x;
	private float y;
	private float r;
	private Color c;
	
	public Circle(float x, float y, float r, Color c) {
		super();
		this.x = x;
		this.y = y;
		this.r = r;
		this.c = c;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getRadius() {
		return r;
	}

	public void setRadius(float r) {
		this.r = r;
	}

	public Color getColor() {
		return c;
	}

	public void setColor(Color c) {
		this.c = c;
	}

	@Override
	public String toString() {
		return "Circle [x=" + x + ", y=" + y + ", r=" + r + ", c=" + c + "]";
	}
	
	public boolean isIntersecting(Circle other) {
		double d = Math.sqrt(Math.pow(this.x-other.x,2) + Math.pow(this.y-other.y,2));
		if (d <= this.r + other.r) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
}
