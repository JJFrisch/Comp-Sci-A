
public class WarnsdorfRule { // completely wrong code - knight problem code rn
	
	private int[][] Board;
	private final int KNIGHT = -2;
	private int[][] knights;
	private boolean closed;
	
	public WarnsdorfRule(int x,int y,boolean c){
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
	
	public void solve(){
		
	
	}
	
}
