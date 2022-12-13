
public class Circle {

	private float x;
	private float y;
	private float radius;
	private float angle;
	private float speed;
	
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
		return radius;
	}

	public void setRadius(float radius) {
		this.radius = radius;
	}

	public float getAngle() {
		return angle;
	}

	public void setAngle(float angle) {
		this.angle = angle;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public Circle(float x, float y, float radius, float angle, float speed) {
		super();
		this.x = x;
		this.y = y;
		this.radius = radius;
		this.angle = angle;
		this.speed = speed;
	}
	
	public boolean isIntersecting(Circle other) {
		float rSum = this.radius + other.radius;
		float d = (float) Math.sqrt(Math.pow(this.x-other.x,2) + Math.pow(this.y-other.y,2));
		return rSum>=d;
	}
}
