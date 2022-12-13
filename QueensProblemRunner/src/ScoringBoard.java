
public class ScoringBoard {
	private int[][] board;
	public final int QUEEN = -2;
	public final int ELIMINATED = -1;
	private int itt = 0; // itteration
	
	/**
	 * constructor
	 * initializes board to be of size n-by-n and containing all zeroes
	 */
	public ScoringBoard(int n){
		board = new int[n][n];
	}

	/**
         * returns a reference to the board
         */
	public int[][] getBoard(){
		return board;
	}
	
	/**
	 * sets value of all cells in board to 0
	 */
	public void refreshBoard(){
		for(int i=0;i<board.length;i++){
			for(int k=0;k<board[i].length;k++){
				board[i][k] = 0;
			}
		}
	}

	/**
	 * prints the contents of each square in board in tabular format
	 * if square contains QUEEN, print QUEEN
	 * if square contains ELIMINATED, print ELIMINATED
	 * otherwise, print '-'
	 */
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
	
	/**
	 * calls getScore method for each square on board
	 * places result from each call to getScore in that square
	 */
	public void scoreSpaces(){
		for(int i=0;i<board.length;i++){
			for(int k=0;k<board[i].length;k++){
				board[i][k] = getScore(i,k);
			}
		}
	}

	/**
	 * returns true if there is an available square on board
	 * returns false if there are no available squares
	 */
	public boolean cellIsAvailable(){
		for(int i=0;i<board.length;i++){
			for(int k=0;k<board[i].length;k++){
				if(board[i][k] != ELIMINATED && board[i][k] != QUEEN){
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * changes the value of board[row][col] to QUEEN
	 * changes the value of all squares that are eliminated by this QUEEN to 	 
	 * ELIMINATED 
	 */
	public void placeQueen(int row, int col){
		board[row][col] = QUEEN;
		for(int i=0;i<board.length;i++){
			for(int k=0;k<board[i].length;k++){
				if(i==row||k==col||Math.abs(row-i)==Math.abs(col-k)){
					if(board[i][k] != ELIMINATED && board[i][k] != QUEEN){
						board[i][k] = ELIMINATED;
					}
				}
			}
		}
	}
	
	/**
	 * returns ELIMINATED if square at row, col contains ELIMINATED 
	 * returns QUEEN if square at row, col contains QUEEN
	 * otherwise, counts the number of squares that would become unavailable 
	 * if the square at row, col were to receive a QUEEN (including the 	  
         * square at row,col); this count is returned
	 */
	public int getScore(int row, int col){
		if(board[row][col] ==ELIMINATED){
			return ELIMINATED;
		}
		if(board[row][col] == QUEEN){
			return QUEEN;
		}
		int score = 1;
		for(int i=0;i<board.length;i++){
			for(int k=0;k<board[i].length;k++){
				if(i==row&&k==col){
					
				}
				else if(i==row||k==col||Math.abs(row-i)==Math.abs(col-k)){
					if(board[i][k] != ELIMINATED && board[i][k] != QUEEN){
						score++;
					}
				}
			}
		}
		return score;
	}

	/**
	 * calculates the smallest non-negative score on the board
	 * determines the number of squares that contain this score
	 * randomly selects one of these squares 
	 * calls placeQueen method to place a QUEEN in this square
	 */
	public void findAndPlace(){
		int min = board.length*3;
		int mins = 0;
		int QUEENs = 0;
		for(int i=0;i<board.length;i++){
			for(int k=0;k<board[i].length;k++){
				int tempScore = getScore(i,k);
				if(board[i][k] == QUEEN){
					QUEENs++;
				}
				else if(board[i][k] != ELIMINATED){
					if(tempScore < min){
						min = tempScore;
						mins = 1;
					}
					else if (tempScore == min){
						mins++;
					}
				}
			}
		}
//		System.out.println(mins + " " + QUEENs);
		if(mins == 0 && QUEENs < board.length){
			refreshBoard();
//			System.out.println("wow");
			itt = 0;
			return;
		}
		int[][] minis = new int[mins][2];
		int index = 0;
		for(int i=0;i<board.length;i++){
			for(int k=0;k<board[i].length;k++){
				int tempScore = getScore(i,k);
				if(tempScore == min){
					minis[index][0] = i;
					minis[index][1] = k;
					index++;
				}
			}
		}
		int[] choosen = minis[(int) (Math.random()*mins)];
		placeQueen(choosen[0],choosen[1]);
	}
	
	
	
	public void solve(){
		while(itt<board.length){
			itt++;
			findAndPlace();
		}
		printGrid();
	}
}
