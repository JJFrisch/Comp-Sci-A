public class Robot {
	private int[] hall;
	private int pos;
	private boolean facingRight; 
	
	public Robot(int[] hallway, int position){
		hall = hallway;
		pos = position;
	}
	
	private boolean forwardMoveBlocked(){ 
		if(pos-1 == hall.length && facingRight){
			return true;
		}
		else if (pos == 0 && !facingRight){
			return true;
		}
		else{
			return false;
		}
	}

	private void move(){
		if (hall[pos] > 0){
			hall[pos] -= 1;
		}
		if (hall[pos] == 0){
			if (forwardMoveBlocked() == false){
				if (facingRight == true){
					pos++;
				}
				else if (facingRight == false){
					pos--;
				}
			}
			else{
				if (facingRight == true){
					facingRight = false;
				}
				else if (facingRight == false){
					facingRight = true;
				}
				
			}
		}
	}
	public int clearHall(){
		int moves = 0;
		while (!hallIsClear()){
			move();
			moves++;
		}
		return moves;
	}
	private boolean hallIsClear(){
		boolean clear = true;
		for (int space: hall){
			if (space > 0){
				clear = false;
			}
		}
		return clear;
	}
}
