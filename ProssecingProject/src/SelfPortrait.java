import processing.core.PApplet;
//import processing.sound.*;

public class SelfPortrait extends PApplet{
//	Sound s;
	
	public static void main(String[] args) {
		PApplet.main("ProssecingRunner");
		
		
		
	}
	
	public void setup() {
		  size(200, 200);

		  // Play two sine oscillators with slightly different frequencies for a nice "beat".
//		  SinOsc sin = new SinOsc(this);
//		  sin.play(200, 0.2);
//		  sin = new SinOsc(this);
//		  sin.play(205, 0.2);

		  // Create a Sound object for globally controlling the output volume.
//		  s = new Sound(this);
		}

	public void draw() {
		  // Map vertical mouse position to volume.
//		  float amplitude = map(mouseY, 0, height, 0.4, 0.0);

		  // Instead of setting the volume for every oscillator individually, we can just
		  // control the overall output volume of the whole Sound library.
//		  s.volume(amplitude);
		}
	
	public void settings(){
		this.size(700, 700);
	}

}
