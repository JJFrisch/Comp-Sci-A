import processing.core.PApplet;
import processing.core.PImage;

public class ProssecingRunner extends PApplet{
	float time;
	float explosionTime;
	float xPos;
	float yPos;
	float angle;
	float speed;
	float rotSpeed;
	boolean shouldRun;
	
	float elipseSize;
	boolean increaseElipseSize;
	
	float angle2;
	float jitter;
	
	PImage img;
	
	public static void main(String[] args) {
		PApplet.main("ProssecingRunner");
		
		
		
	}
	
	public void setup(){
		smooth();
		rectMode(CENTER);
		
		time = 0;
		explosionTime = 500;
		xPos = 0;
		yPos = 0;
		angle = PI/4;
		speed = 2;
		rotSpeed = 1;
		shouldRun = true;
		
		elipseSize = 100;
		increaseElipseSize = true;
		
//		img = loadImage("OneDrive/9th Grade/Comp. Sci/Unit 0/Prossecing/HairPic.JPG");
	}
	
	public void draw(){
		
		if(shouldRun){
			background(205);
			this.fill(255, 30, 30);
			this.stroke(0,0,200);
			this.strokeWeight(5);
			project1(xPos, yPos);
			xPos += speed*cos(angle);
			yPos += speed*sin(angle);
			if (xPos>width+20){
				xPos=-50;
				yPos=-50;
			}
			time++;
			
		}
		
//		translate(1, 1);
//		rotate(3);
//		this.stroke(0,0,0);
//		this.strokeWeight(5);
//		this.fill(255, 0, 0, 160);
//		this.ellipse(60, -60, 20, 200);
//		rotate(-3);
		
		this.fill(217,179,128);
		this.stroke(0,0,0);
		this.strokeWeight(2);
		this.ellipse(this.width/2-230, this.height/2-40, 70, 120);
		this.ellipse(this.width/2+230, this.height/2-40, 70, 120);
		this.fill(250,231,218);
		this.stroke(0,0,0);
		this.strokeWeight(5);
		this.ellipse(this.width/2, this.height/2-60, 450, 500);
		this.strokeWeight(1);
		this.fill(217,179,128,250);
		this.rect(this.width/2-110, this.height/2-130, 100, 20);
		this.rect(this.width/2+100, this.height/2-130, 100, 20);
		this.fill(217,179,128,250);
		this.stroke(0,0,0);
		this.strokeWeight(2);
		this.ellipse(this.width/2, this.height/2-230, 430, 170);
		this.fill(251,231,161);
		this.stroke(0,0,0);
		this.strokeWeight(2);
		for(int i=0;i<5;i++){
			this.fill(251+(i*5),231+(i*5),161+(i*5));
			this.triangle(300+(i*90),230 ,100+(i*90),60-(i*10) ,55+(i*90),200);
		}
		
		this.fill(150, 120, 80,250);
		this.stroke(0,0,0);
		this.strokeWeight(5);
		this.ellipse(this.width/2-100, this.height/2-80, 80, 50);
		this.ellipse(this.width/2+100, this.height/2-80, 80, 50);
		this.fill(106,255,77,40);
		this.strokeWeight(1);
		this.ellipse(this.width/2-100, this.height/2-80, 30, 30);
		this.ellipse(this.width/2+100, this.height/2-80, 30, 30);
		
		this.fill(235, 181, 184);
		this.stroke(0,0,0);
		this.strokeWeight(5);
		this.ellipse(this.width/2, this.height/2+70, 120, 70);
		
		if (second() % 2 == 0) {  
		   jitter = random(-0.2f, 0.2f);
		}
		
		angle2 = angle2 + jitter;
		float c = cos(angle2);
		translate(width/2, height/2);
		
		rotate(c);
		rotSpeed += 0.001;
		this.stroke(0,0,0);
		this.strokeWeight(5);
		
		if (time<explosionTime+200){
			this.fill(255, 0, 0, 160);
			this.ellipse(0, 0, 20+elipseSize, 200-elipseSize);
			this.fill(200, 45*(1+jitter), 0, 160);
			this.ellipse(0, 0, 200-elipseSize, elipseSize);
			this.fill(200, 0, 45*(1+jitter), 160);
			this.ellipse(0, 0, elipseSize/2, 20+elipseSize);
			if (elipseSize >= 180){
				increaseElipseSize = false;
			}
			if (elipseSize <= 20){
				increaseElipseSize = true;
			}
			if (increaseElipseSize){
				elipseSize += 2;
			}
			else{
				elipseSize -= 2;
			}
		}
		if (time >= explosionTime && time<explosionTime+10000){
			translate(0, 0);
			rotate(0);
			this.stroke(255,255,255);
			this.strokeWeight(1);
			System.out.println(time);
			this.fill(200, 0, 0, 240);
			this.ellipse(0, 0, time, time);
			time+=50;
		}
		if (time>explosionTime+10000){
			time = 0;
		}

//		image(img, 0, 0);
//		image(img, 0, 0, width/2, height/2);
		
	}
	
	public void settings(){
		this.size(700, 700);
	}
	
	public void mousePressed(){
		shouldRun = !shouldRun;
	}
	
	void project1(float xg, float yg){
		float x = xg;
		float y = yg;
		
		this.fill(255, 30, 30);
		this.stroke(0,0,200);
		this.strokeWeight(5);
		
		for (int i=0; i<12; i++){
			this.fill(255, 0, 0);
			this.ellipse(x, y, 45, 45);
			
			y+=55;

		}
	}
	
	void project2(){
		float x = 40;
		float y = 40;
		float grey = 150;
		
		this.stroke(0,0,200);
		this.strokeWeight(2);
		
		for (int i=0; i<20; i++){
			this.fill(grey, grey+105, grey);
			this.ellipse(x, y, 25, 25);
			
			y+=30;
			x+=30;
			grey-=10;

		}
	}
	
	void project3(){
		float x = this.width/2;
		float y = this.height/2;
		float grey = 150;
		float diam = 500;
		
		this.stroke(0,0,200);
		this.strokeWeight(1);
		this.fill(255, 255, 255);
		
		for (int i=0; i<50; i++){
			this.ellipse(x, y, diam, diam);
			diam-=10;

		}
	}
	
	void project4(){
		float x = 0;
		float y = this.height/2+200;
		float diam = 50;
		
		this.stroke(0,0,200);
		this.strokeWeight(1);
		this.fill(255, 255, 255);
		
		translate(120, 80);
		rect(0, 0, 220, 220);
		
		for (int i=0; i<13; i++){
			this.ellipse(x+200, y, diam, diam);

		}
	}

}
