
public class KnightsTour {
	private int[][] Board;
	private final int KNIGHT = -2;
	private int[][] knights;
	private boolean closed;
	
	public KnightsTour(int x,int y,boolean c){
		Board = new int[x][y];
		knights = new int[x*y+1][2];
		closed = c;
	}
	
	public int[][] getBoard(){
		return Board;
	}
	
	public void refreshBoard(){
		for(int i=0;i<Board.length;i++){
			for(int k=0;k<Board[i].length;k++){
				Board[i][k] = 0;
			}
		}
	}
	
	public boolean solve(int n,int row, int col, int[][] board){
//		System.out.println(n);
		if(!closed && n==board.length*board.length){
			return true;
		}
		else if(closed && n==board.length*board.length+1){
			return true;
		}
		int[][] spots = new int[8][2];
		spots = findSpots(row, col);
		for(int spot=0; spot < 8;spot++){
			if(spots[spot][0] > -1 && spots[spot][1] > -1){
				if(board[spots[spot][0]][spots[spot][1]] == 0){
					board[spots[spot][0]][spots[spot][1]] = n;
					knights[n][0] = spots[spot][0];
					knights[n][1] = spots[spot][1];
					if(solve(++n, spots[spot][0], spots[spot][1], board)){
					
                    	return true;
					}				
					board[knights[n-1][0]][knights[n-1][1]] = 0;
					knights[n][0] = 0;
					knights[n][1] = 0;
					n--;
				}
			}
		}
		return false;
	}
	
	public int[][] findSpots(int row, int col){
		int[][] toReturn = new int[8][2];
		int X[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
	    int Y[] = { 1, 2, 2, 1, -1, -2, -2, -1 };
		 
	    for (int i = 0; i < 8; i++) {
	 
	        int x = row + X[i];
	        int y = col + Y[i];
	 
	        if (x >= 0 && y >= 0 && x < Board.length && y < Board[row].length){
	        	toReturn[i][0] = x;
	        	toReturn[i][1] = y;
	        }
	        else{
	        	toReturn[i][0] = -2;
	        	toReturn[i][1] = -2;
	        }
	    }
	    return toReturn;

	}
	
	
	
	public void printGrid(){
		if(Board.length == 0){
			System.out.println("0 Grid");
		}
		else{
		for(int i=0;i<Board.length;i++){
			for(int k=0;k<Board[i].length;k++){
				if(Board[i][k] == KNIGHT){
					System.out.print("K ");
				}

				else {
					System.out.print(Board[i][k] + " ");
				}
			}
			System.out.println();
		}
		}
	}
}
