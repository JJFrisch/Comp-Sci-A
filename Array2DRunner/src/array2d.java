
public class array2d {
	
	
	public static String[] getBottomRow(String[][] words){
		String[] toReturn = new String[words[words.length-1].length];
		for(int i=0;i<words[words.length-1].length;i++){
			toReturn[i] = words[words.length-1][i];
		}
		return toReturn;
	}
	
	public static boolean[][] alternateTrueFalse(int nr, int nc){
		boolean[][] toReturn = new boolean[nr][nc];
		boolean now = true;
		boolean startRow = true;
		for(int i=0;i<nr;i++){
			now = startRow;
			startRow = !startRow;
			for(int k=0;k<nc;k++){
				toReturn[i][k] = now;
				now = !now;
			}
		}
		return toReturn;
	}
}
