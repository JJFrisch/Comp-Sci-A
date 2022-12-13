import java.awt.Color;
import java.util.*;

public class Maze extends Turtle{

	Turtle turtle = new Turtle();
//	List<Space> grid = new ArrayList<>();  
	String[] colors = {"black", "blue", "cyan", "darkGrey", "green", "lightGray", "magenta", "orange", "pink", "red", "white", "yellow", "gray"};
	
	public void main(String[] args) {

	}

	void generateMaze(int width, int height){
		turtle.setX(10);
		turtle.setY(10);
		turtle.turnLeft(180);
//		square(width, height);
		
		Space grid[][] = new Space [width][height];
		boolean walls[][] = new boolean [width+1][height*2+1];
		
		for (int i=0; i<width; i++){
			for (int j=0; j<height; j++){
				grid[i][j] = new Space();
				grid[i][j].posX = j;
				grid[i][j].posY = i;
				grid[i][j].width = 580/width; // doesn't use decimals so is slightly off
				grid[i][j].height = 580/height; // doesn't use decimals so is slightly off
				
			}
		}
//		System.out.println(grid[0].length);
//		System.out.println(grid.length);
//		System.out.println(grid[0][0].width);
//		System.out.println(grid[0][1].height);
		
		grid[7][5].walls[2] = false;
		grid[6][5].walls[0] = false;
		
		primitiveGeneration(grid, walls, width, height);
		
		drawWalls(grid, walls); // Draws the grid
		
		turtle.setX(10);
		turtle.setY(10);
		turtle.setAngle(0);
		turtle.setPenColor(Color.red);
		turtle.goForward(20);
	}
	
	void drawWalls(Space grid[][], boolean walls[][]){
		turtle.setX(10);
		turtle.setY(10);
		turtle.setAngle(0);
		
		for (int i=0; i<walls.length; i++){
			for (int j=0; j<walls[i].length; j++){
				//For each wall do this:
				turtle.setX(10+(i*grid[0][0].width));
				turtle.setY(10+((j/2)*grid[0][0].height));
				turtle.setAngle(0);
				if (!walls[i][j]){
					turtle.setPenColor(Color.black);
				}
				else{
					turtle.setPenColor(Color.white);
				}
				if(j%2 == 0){
					turtle.turnLeft(90);
					if (walls[i].length-1 == j){ //checks if it is last in line and corrects it
						if (i != walls.length-1){
							turtle.setAngle(0);
							turtle.goForward(grid[0][0].width);
						}
					}
					else{
						turtle.goForward(grid[0][0].height);
					}
				}
				if(j%2 == 1){
					if(i != walls.length-1) {
						turtle.goForward(grid[0][0].width);
					}
				}
			}   
		} 
	}
//	Start with a grid full of walls.
//	Pick a cell, mark it as part of the maze. Add the walls of the cell to the wall list.
//	While there are walls in the list:
//		Pick a random wall from the list. If only one of the cells that the wall divides is visited, then:
//			Make the wall a passage and mark the unvisited cell as part of the maze.
//			Add the neighboring walls of the cell to the wall list.
//		Remove the wall from the list.
	void primitiveGeneration(Space grid[][], boolean walls[][], int width, int height){		
//		boolean[][] visitedCells = new boolean[grid.length][grid[0].length];
		List<int[]> visitedCells = new ArrayList<>(width*height);
		List<int[]> wallList = new ArrayList<>(width*height);
		
		Random rand = new Random();
		int startX = rand.nextInt(width-1);
		int startY = rand.nextInt(height-1);
		int[] start = {startX,startY};
		visitedCells.add(start);
				
		int[][] nextWall = getWalls(startX, startY);
		for(int j=0;j<nextWall.length;j++){
			wallList.add(nextWall[j]);
		}
//		while (wallList.isEmpty() == false){
		for(int q=0;q<30;q++){
			drawWalls(grid,walls);
			int[] randWall = wallList.get(rand.nextInt(wallList.size()));
			int[] spot1 = wallDivides(randWall[0], randWall[1])[0];
			int[] spot2 = wallDivides(randWall[0], randWall[1])[1];
			if(contains(spot1, visitedCells) == true && contains(spot2, visitedCells) == false){
				System.out.println("yay  " + randWall[0] + " " + randWall[1]);
				walls[randWall[0]][randWall[1]] = true;
				visitedCells.add(spot2);
				int[][] newNextWall = getWalls(spot2[0], spot2[1]);
				for(int j=0;j<newNextWall.length;j++){
					wallList.add(newNextWall[j]);
					System.out.println(newNextWall[j][0] + " " + newNextWall[j][1]);
				}
				
			}
			else if(contains(spot1, visitedCells) == false && contains(spot2, visitedCells) == true){
				System.out.println("yay");
				walls[randWall[0]][randWall[1]] = true;
				visitedCells.add(spot1);
				int[][] newNextWall = getWalls(spot1[0], spot1[1]);
				for(int j=0;j<newNextWall.length;j++){
					wallList.add(newNextWall[j]);
				}
			}
			
			wallList.remove(randWall);
		}
		
	}
	
	
	private int[][] getWalls(int xpos, int ypos){
		int pos[][] = new int[4][2];
		pos[0][0] = xpos;
		pos[0][1] = ypos*2+3; 
		
		pos[1][0] = xpos+1; 
		pos[1][1] = ypos*2; 
		
		pos[2][0] = xpos;
		pos[2][1] = ypos*2+1; 
		
		pos[3][0] = xpos;
		pos[3][1] = ypos*2; 
		return pos;
		
	}
	
	
	private int[][] wallDivides(int xpos, int ypos){ //untested - possible source of error
		int pos[][] = new int[2][2];
		if(ypos%2==1){
			pos[0][0] = xpos;
			if(ypos<3){
				pos[0][1] = 0;
			}
			else{
				pos[0][1] = (ypos-3)/2; 
			}
			
			pos[1][0] = xpos;
			if(ypos<1){
				pos[1][1] = 0;
			}
			else{
				pos[1][1] = (ypos-1)/2; 
			}
		}
		else if(ypos%2==0){
			if(xpos<1){
				pos[1][0] = 0;
			}
			else{
				pos[1][0] = xpos-1; 
			}
			pos[1][1] = ypos/2; 
			
			pos[0][0] = xpos;
			pos[0][1] = ypos/2; 
		}
		return pos;
		
	}
	
	private boolean contains(int[] x, List<int[]> visitedCells){
		boolean isTrue = false;
		for(int i=0;i<visitedCells.size();i++){
			for(int j=0;j<visitedCells.get(i).length;j++){
				if(visitedCells.get(i)[j] != x[j]){
					j = visitedCells.get(i).length+2;
				}
				if(j == visitedCells.get(i).length -1){
					isTrue = true;
				}
			}
			
		}
		return isTrue;
	}
}   

