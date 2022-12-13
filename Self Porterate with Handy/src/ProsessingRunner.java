import java.awt.Color;
import java.util.ArrayList;

import org.gicentre.handy.HandyRenderer;

import processing.core.PApplet;

public class ProsessingRunner extends PApplet {	
	
	HandyRenderer hr;
	ArrayList<Circle> circles;
	
	public void setup() {
		hr = new HandyRenderer(this);
		circles = new ArrayList<Circle>();
		
		this.background(255);
		
		for (int k = 0; k < 100; k++) {
			Circle att = new Circle(random(width), 
					random(height), random(5,20), new Color(0,0,0));
			
		}
		
	}
	
	public void draw() {		
		for (int k = 0; k < circles.size(); k++) {
			Circle c = circles.get(k);
			for (int j=0;j<circles.size();j++){
				Circle oc = circles.get(j);
				if(j!=k && c.isIntersecting(oc)==true){
					c.setColor(new Color(255,0,0));
				}
				else if(j!=k && c.isIntersecting(oc)==false){
					c.setColor(new Color(0,255,0));
				}
			}
			fill(c.getColor().getRGB());
			ellipse(c.getX(), c.getY(), 2*c.getRadius(), 2*c.getRadius());
		}
	}
	
	public void settings() {
		this.size(720, 720);
	}

	public static void main(String[] args) {
		PApplet.main("ProcessingRunner");

	}
}
