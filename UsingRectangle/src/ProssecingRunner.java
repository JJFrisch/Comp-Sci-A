import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;

public class ProssecingRunner extends PApplet{
	
	OurRectangle r;
	ArrayList<OurRectangle> rectangles;
	
	
	public static void main(String[] args) {
		PApplet.main("ProssecingRunner");
		
		
		
	}
	
	public void setup(){
		rectangles = new ArrayList<OurRectangle>();
		for(int i=0;i<100;i++){
			rectangles.add(new OurRectangle((int)random(width), (int)random(height), 50, 50, random(2*PI), 2.0f));
		}
	}
	
	public void draw(){
		this.background(205);
		for(int i = 0 ; i < rectangles.size(); i++){
			OurRectangle r=rectangles.get(i);
			this.rect((float)r.getX(), (float)r.getY(), (float)r.getWidth(), (float)r.getHeight());
			r.x = (int)(r.getX() + r.getSpeed()*cos(r.getAngle()));
			r.y = (int)(r.getY() + r.getSpeed()*sin(r.getAngle()));
			if(r.x>=width||r.x==0){
				r.setAngle(-r.getAngle());
			}
			if(r.y>=height||r.y==0){
				r.setAngle(-r.getAngle());
			}
		}
	}
	
	public void settings(){
		this.size(700, 700);
	}
	
	

}
