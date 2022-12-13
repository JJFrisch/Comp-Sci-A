
public class OurRectangle extends java.awt.Rectangle {
	private float speed;
	private float angle;
	
	
	public OurRectangle(int x, int y, int w, int h, float a, float s){
		super(x,y,w,h);
		angle=a;
		speed=s;
	}
	
	public float getAngle(){
		return angle;
	}
	public float getSpeed(){
		return speed;
	}
	public void setAngle(float a){
		angle = a;
	}
	public void setSpeed(float s){
		speed=s;
	}
	
	
	
}
