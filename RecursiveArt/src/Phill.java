import java.util.ArrayList;
import processing.core.PApplet;
import processing.core.PVector;

public class Phill extends PApplet {
	
	boolean[][] grid;
	ArrayList<PVector> cellsToFill;
	int pos = 0;
	final int DIM = 25;
	
	public void settings() {
		this.size(600, 600);
	}
	
	public void phil(int r, int c) {
		
	}
	
	public void mouseClicked() {
		int c = mouseX/(width/DIM);
		int r = mouseY/(height/DIM);
		
		if (mouseButton == RIGHT) {
			fill(0);
			rect(c*width/DIM, r*height/DIM, width/DIM, height/DIM);
			noFill();			
		}
		else if (mouseButton == LEFT) {
			//noLoop();
			phil(r,c);
		}
		grid[r][c] = true;
	}
	
	public void setup() {
		grid = new boolean[DIM][DIM];
		for (int r = 0; r < grid.length; r++) {
			for (int c = 0; c < grid[r].length; c++) {
				grid[r][c] = false;
				rect(c*width/DIM, r*height/DIM, width/DIM, height/DIM);
			}
		}
		cellsToFill = new ArrayList<PVector>();
	}
	
	public void draw() {
		fill(0,255,200);
		if (pos < cellsToFill.size()) {
			PVector curr = cellsToFill.get(pos);
			int c = (int) curr.x;
			int r = (int) curr.y;
			rect(c*width/DIM, r*height/DIM, width/DIM, height/DIM);
			pos++;
		}
		noFill();
	}	
	
	public static void main(String[] args) {
		PApplet.main("GridRunner");
	}	
}






