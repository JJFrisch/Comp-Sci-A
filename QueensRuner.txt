import java.awt.Color;

import processing.core.PApplet;



public class Runner extends PApplet{
	private static int[][] pBoard;
	private static int tileW;
	private static int tileH;
	private static int col;
	private static String mode;
	
	public static void main(String[] args) {
		PApplet.main("Runner");
				
	}
	

	public void setup(){
		
		mode = "queens";
		
		int sizeX = 6;
		int sizeY = 6;
		
		if(mode == "knights"){
			KnightsTour x = new KnightsTour(sizeX, sizeY, true);
			x.solve(0,0,0,x.getBoard());
			x.printGrid();
			pBoard = x.getBoard();
		}
		
		else if(mode == "queens"){
			Recursion x = new Recursion(sizeX);
			x.solve(sizeX,0);
			x.printGrid();
			pBoard = x.getBoard();
		}

		
		tileW = 680/pBoard.length;
		col = 255/(pBoard.length*pBoard.length);
		
		smooth();
		rectMode(CENTER);

//		ALL QUEENS RUNNERS
//		ScoringBoard x = new ScoringBoard(size);
//		x.solve();
//		Recursion x = new Recursion(sizeX);
//		x.solve(sizeX,0);
//		x.printGrid();
	}
	
	public void draw(){
		int xpos;
		int ypos;
		this.stroke(0,0,0);
		this.strokeWeight(2);
		this.fill(255, 255, 255);
		textSize(40);

		xpos = 0;
		ypos = 0;
		
		for (int i=0; i<pBoard.length; i++){
			for (int j=0; j<pBoard[i].length; j++){
//				For each wall do this:
				tileH = 680/pBoard[i].length;
				xpos = 10+tileH/2+(i*tileH);
				ypos = 10+tileW/2+(j*tileW);
				this.fill(col*pBoard[i][j], col*pBoard[i][j], col*pBoard[i][j], 100);
				if(mode == "queens"){
					if(pBoard[i][j] == -2){
						this.fill(125, 0, 125, 100);
					}
					else{
						this.fill(255, 255, 255);
					}
				}
				this.rect(xpos, ypos, tileW, tileW);
				this.fill(255-(col*pBoard[i][j]), 255-(col*pBoard[i][j]), 255-(col*pBoard[i][j]));
				text(pBoard[i][j], xpos-20,ypos+20); 
			}
		}

	}
	
	public void settings(){
		this.size(700, 700);
	}


}
