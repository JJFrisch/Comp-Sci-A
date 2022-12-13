import java.util.ArrayList;

import processing.core.PApplet;

public class RARunner extends PApplet{
	
	private ArrayList<Integer> colors;
	
	public void setup() {
		colors = new ArrayList<Integer>();
		colors.add(this.color(255,252,252));
		colors.add(this.color(248));
		colors.add(this.color(254,243,253));
		colors.add(this.color(244,255,244));
		colors.add(this.color(249,245,255));
		drawMondrian(4,0,0,this.width,this.height);
	}
	
	private void drawMondrian(int depth, float x, float y, float w, float h) {
		this.stroke(255);
		if(depth == 0){
			this.fill(colors.get((int) (Math.random()*colors.size())));
			this.rect(x, y, w, h);
		}
		else{
			this.rect(x, y, w, h);
			float xPos = (float) (Math.random()*w);
			float yPos = (float) (Math.random()*h);
			drawMondrian(depth-1,0,0,xPos,yPos);
			drawMondrian(depth-1,xPos,0,w-xPos,yPos);
			drawMondrian(depth-1,0,yPos,xPos,h-yPos);
			drawMondrian(depth-1,xPos,yPos,w-xPos,h-yPos);
		}
		
	}

	public void settings() {
		this.size(600, 600);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("RARunner");
		
	}

}
