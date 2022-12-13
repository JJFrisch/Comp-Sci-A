import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ScoringBoardTest {
	
	ScoringBoard cb;
	final int SIZE = 4;
	
	@Before
	public void setup() throws Exception {
		cb = new ScoringBoard(SIZE);
	}

	@Test
	public void testRefreshBoard() {
		cb.refreshBoard();
		for (int r = 0; r < cb.getBoard().length; r++) {
			for (int c = 0; c < cb.getBoard()[r].length; c++) {
				assertTrue(cb.getBoard()[r][c] == 0);
			}
		}
	}

	@Test
	public void testPrintGrid() {
		cb.scoreSpaces();
		cb.printGrid();
		System.out.println();
	}

	@Test
	public void testScoreSquares() {
		cb.scoreSpaces();
		for (int c = 0; c < SIZE; c++) {
			assertEquals(3*SIZE-2,cb.getBoard()[0][c]);
		}
		for (int c = 0; c < SIZE; c++) {
			assertEquals(3*SIZE-2,cb.getBoard()[SIZE-1][c]);
		}
		for (int r = 0; r < SIZE; r++) {
			assertEquals(3*SIZE-2,cb.getBoard()[r][0]);
		}
		for (int r = 0; r < SIZE; r++) {
			assertEquals(3*SIZE-2,cb.getBoard()[r][SIZE-1]);
		}
		if (SIZE % 2 == 0) {
			assertEquals(4 * SIZE - 4, cb.getBoard()[SIZE/2-1][SIZE/2-1]);  	// center values
			assertEquals(4 * SIZE - 4, cb.getBoard()[SIZE/2-1][SIZE/2]);
			assertEquals(4 * SIZE - 4, cb.getBoard()[SIZE/2][SIZE/2-1]);
			assertEquals(4 * SIZE - 4, cb.getBoard()[SIZE/2][SIZE/2]);
		}
		else {
			assertEquals(4 * SIZE - 3,cb.getBoard()[SIZE/2][SIZE/2]);	// center value
		}
	}

	@Test
	public void testCellIsAvailable() {
		assertTrue(cb.cellIsAvailable());
	}

	@Test
	public void testPlaceQueen() {
		cb.scoreSpaces();
		cb.placeQueen(1,0);
		for (int r = 0; r < SIZE; r++) {
			if (r != 1) {
				assertEquals(cb.ELIMINATED, cb.getBoard()[r][0]);
			}
		}
		for (int c = 0; c < SIZE; c++) {
			if (c != 0) {
				assertEquals(cb.ELIMINATED, cb.getBoard()[1][c]);
			}
		}
		assertEquals(cb.ELIMINATED,cb.getBoard()[0][1]);
		for (int r = 2, c = 1; r < SIZE && c < SIZE; r++,c++) {
			assertEquals(cb.ELIMINATED,cb.getBoard()[r][c]);
		}
		
		assertEquals(cb.QUEEN, cb.getBoard()[1][0]);
	}

	@Test
	public void testGetScore() {
		for (int c = 0; c < SIZE; c++) {
			assertEquals(3*SIZE-2,cb.getScore(0, c));
		}
		for (int c = 0; c < SIZE; c++) {
			assertEquals(3*SIZE-2,cb.getScore(SIZE-1, c));
		}
		for (int r = 0; r < SIZE; r++) {
			assertEquals(3*SIZE-2,cb.getScore(r, 0));
		}
		for (int r = 0; r < SIZE; r++) {
			assertEquals(3*SIZE-2,cb.getScore(r, SIZE-1));
		}
		assertEquals(4 * SIZE - 4, cb.getScore(SIZE/2-1,SIZE/2-1));  	// center values
		assertEquals(4 * SIZE - 4, cb.getScore(SIZE/2-1,SIZE/2));
		assertEquals(4 * SIZE - 4, cb.getScore(SIZE/2,SIZE/2-1));
		assertEquals(4 * SIZE - 4, cb.getScore(SIZE/2,SIZE/2));
		cb.getBoard()[0][0] = cb.ELIMINATED;
		assertEquals(cb.ELIMINATED,cb.getScore(0, 0));
		assertEquals((3 * SIZE - 2) - 1,cb.getScore(1, 0));
	}

	@Test
	public void testFindAndPlace() {
		cb.scoreSpaces();
		cb.findAndPlace();
		boolean hasQueen = false;
		int[][] board = cb.getBoard();
		for (int r = 0; r < SIZE; r++) {
			for (int c = 0; c <SIZE; c++) {
				if (board[r][c] == cb.QUEEN) {
					hasQueen = true;
				}
			}
		}
		assertTrue(hasQueen);
	}	

}
