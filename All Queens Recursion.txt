
public class Recursion {
	private int[][] board;
	public final int QUEEN = -2;
	public final int ELIMINATED = -1;
	
	public Recursion(int n){
		board = new int[n][n];
	}
	
	public int[][] getBoard(){
		return board;
	}
	
	public void refreshBoard(){
		for(int i=0;i<board.length;i++){
			for(int k=0;k<board[i].length;k++){
				board[i][k] = 0;
			}
		}
	}
	
	public boolean solve(int n,int row){
		if(n==2||n==3){
			return false;
		}
		if(n==row){
			return true;
		}
		for(int col=0; col < n;col++){
			if(canPlace(row,col)){
				if(solve(n, row+1)){
					
                    return true;
				}
			}
		}
		for(int col=0; col < n;col++){
			board[row-1][col] = 0;
		}
		return false;
	}
	
	public boolean canPlace(int row, int col){
		if(board[row][col] == ELIMINATED){
			return false;
		}
		if(board[row][col] == QUEEN){
			return false;
		}
		for(int i=0;i<board.length;i++){
			for(int k=0;k<board[i].length;k++){
				if(i==row||k==col||Math.abs(row-i)==Math.abs(col-k)){
					if(board[i][k] == QUEEN){
						return false;
					}
				}
			}
		}
		board[row][col] = QUEEN;
		return true;

	}
	
	
	
	public void printGrid(){
		if(board.length == 0){
			System.out.println("0 Grid");
		}
		else{
		for(int i=0;i<board.length;i++){
			for(int k=0;k<board[i].length;k++){
				if(board[i][k] == QUEEN){
					System.out.print("Q ");
				}
				else if(board[i][k] == ELIMINATED){
					System.out.print("E ");
				}
				else {
					System.out.print(board[i][k] + " ");
				}
			}
			System.out.println();
		}
		}
	}
}
