import java.util.Random;

public class Soduku {
//	int[][] grid = new int[9][9];
//	private static int[][] grid = {
//	        {0,5,0,8,7,3,0,9,0},
//	        {0,0,3,2,5,0,0,0,8},
//	        {9,8,0,1,0,4,3,5,7},
//	        {1,0,5,0,0,0,0,0,0},
//	        {4,0,0,0,0,0,0,0,2},
//	        {0,0,0,0,0,0,5,0,3},
//	        {5,7,8,3,0,1,0,2,6},
//	        {2,0,0,0,4,8,9,0,0},
//	        {0,9,0,6,2,5,0,8,1}
//	    };
	private static int[][] grid = {
	        {0,0,1,0,6,0,0,5,9},
	        {0,0,0,0,0,3,0,2,0},
	        {0,6,0,0,8,0,0,0,0},
	        {4,0,0,0,0,0,5,0,0},
	        {0,2,0,0,0,0,0,0,0},
	        {0,7,0,3,0,0,4,8,0},
	        {8,0,0,0,0,0,9,0,5},
	        {7,0,0,6,0,9,0,3,0},
	        {0,0,5,0,0,0,0,4,0}
	    };
	
	public Soduku(){
		
	}
	
	public void print(){
		for(int i=0;i<grid.length;i++){
			System.out.print("|");
			for(int k=0;k<grid.length;k++){
				System.out.print(grid[i][k] + "|");
			}
			System.out.println("");
		}
	}
	
	public int[] findOpen(){
		int open = 0;
//		int row;
//		int col;
		
		for(int i=0;i<grid.length;i++){
			for(int k=0;k<grid.length;k++){
				if(grid[i][k] == 0){
					int[] a = {1, i, k};
					return a;
				}
			}
		}
		int[] s = {open, -1, -1};
		return s;

	}
	
	public boolean isSafe(int n, int r, int c){
		boolean safe = true;
		for(int f:grid[r]){
			if(f == n){
				safe = false;
			}
		}
		for(int row=0;row<grid.length;row++){
			if(grid[row][c] == n){
				safe = false;
			}
		}
		int row_start = (r/3)*3;
        int col_start = (c/3)*3;
        for(int i=row_start;i<row_start+3;i++){
            for(int j=col_start;j<col_start+3;j++){
                if(grid[i][j]==n){
                    safe = false;
                }
            }
        }
        return safe;
	}
	
	public boolean solve(){
		int x[] = findOpen();

		int col = x[1];
		int row = x[2];
		if(x[0] == 0){
			return true;
		}
		for(int i=0;i<=9;i++){
			if(isSafe(i,col,row)){
				grid[col][row] = i;
				if(solve()){
                    return true;
				}
                grid[col][row]=0;
			}
		}
		return false;
	}
	
	public void show(){
        if (solve()){
        	System.out.println("Solved: ");
            print();
        }
        else{
            System.out.println("No solution");
        }
    }	
}