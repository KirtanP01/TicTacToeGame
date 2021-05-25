package ticTacToeProblem;

/**
 * 
 * @author - Kirtan Prabhu
 *
 */

public class TicTacToe {
	
	    private String[][] board;
	    private int turn;
	    
	    
	    /**
	     * Creates a new Tic Tac Toe board.  Instantiates the 3x3 board
	     * with all dashes or other place holders.
	     * 
	     * initializes number of turns taken to equal 0
	     */
	    
	    public TicTacToe() {
	    	board = new String[3][3];
			for (int row = 0; row < board.length; row++) {
				for (int col = 0; col < board.length; col++) {
					board[row][col] = "-";
				}
			}
	    	
	    	turn = 0;
	    }
	   
	    /**
	     * Getter method for current turn number
	     * @return number of turns taken
	     */
	    
	    public int getTurn() {
	    	return turn;
	    }

	    /**
	    * This method prints out the board array on to the console
	    */
	    
	   public void printBoard()
	   {
			for (int row = 0; row < board.length; row++) {
				for (int col = 0; col < board[row].length; col++) {
					System.out.print(board[row][col] + " ");
				}
			System.out.println();
			}
	   }
	   
	   /**
	    * 
	    * This method determines if space row, col is an available space to choose
	    * @return: true if the board[row][col] is available, false otherwise
	    * 
	    */
	   
	   public boolean pickLocation(int row, int col)
	   {
		   if (row >=0 && row <=2 && col >=0 && col <=2) {
			   if (board[row][col].equals("-")) {
				   return true;
			   }
		   }
		   return false;
	   }
	   
	   /**
	    * 
	    * This method places an X or O at board[row][col] based on the int turn
	    */
	   
	   public void takeTurn(int row, int col)
	   {
		   if (turn % 2 == 0) {
			   board[row][col] = "X";
			   
		   }
		   else {
			   board[row][col] = "O";
		   }
		   turn++;
	   }
	   
	   /**
	    * 
	    * This method checks if any row has all X's or all Os
	    * @return: true if there is a row with all the same value, false otherwise. 
	    */
	   
	   public boolean checkRow()
	   {
		   String OorX= "";
		   boolean rowFound = true;
			for (int row = 0; row < board.length; row++) {
				rowFound = true;
				OorX = board[row][0];
				if (OorX.equals("-")) {
					rowFound = false;
					continue;
				}
				for (int col = 1; col < board[row].length; col++) {
					if (!board[row][col].equals(OorX)) {
						rowFound = false;
					}
				}
				
				if (rowFound) {
					//System.out.println("Row check 1 " + rowFound);
					return true;
				}
			}
			//System.out.println("Row check 2 " + rowFound);
			return rowFound;
	   }
	   
	   /**
	    * 
	    * This method checks if any col has all X's or all Os
	    * @return: true if there is a col with all the same value, false otherwise. 
	    */
	   
	   public boolean checkCol()
	   {
		   String OorX= "";
		   boolean colFound = true;
			for (int row = 0; row < board.length; row++) {
				colFound = true;
				OorX = board[0][row];
				if (OorX.equals("-")) {
					colFound = false;
					continue;
				}
				for (int col = 0; col < board[row].length; col++) {
					//System.out.print("Col check  " + "[" + col  + "," + row + "] " + board[col][row] + " ");
					
					if (!board[col][row].equals(OorX)) {
						colFound = false;
					}
				}
				System.out.println();
				if (colFound) {
					//System.out.println("Col check 1 " + colFound);
					return true;
				}
			}
			//System.out.println("Col check 2 " + colFound);
			return colFound;
	   }
	   
	   
	   /**
	    * 
	    * This method checks if either diagonal has all X's or all Os
	    * @return: true if either diagonal with all the same value, false otherwise. 
	    */
	   
	   public boolean checkDiag()
	   {
		   String OorX= "";
		   boolean firstDiagonal = true;
		   boolean secondDiagonal = true;
		   int col = 0;
		   int row;
		   
		   //First Diagonal
		   OorX = board[0][0];
			if (OorX.equals("-")) {
				firstDiagonal = false;
			}
			
			for (row = 1; row < board.length; row++) {
				if (!board[row][row].equals(OorX)) {
					firstDiagonal = false;
					break;
				}
			}
			
			if (firstDiagonal) {
				return true;
			}
			
			//System.out.print("2nd diagonal check  ");

			//second Diagonal
			secondDiagonal = true;
			row = 0;
			col = 2;
			OorX = board[row][col];
			if (OorX.equals("-")) {
				secondDiagonal = false;
			}
			//System.out.print("2nd diagonal check  " + "[" + row  + "," + col + "] " + board[row][col] + " ");
			row = 1;
			col = 1;
			//System.out.print("2nd diagonal check  " + "[" + row  + "," + col + "] " + board[row][col] + " ");
			if (!board[row][col].equals(OorX)) {
				secondDiagonal = false;
			}
			
			row = 2;
			col = 0;
			//System.out.print("2nd diagonal check  " + "[" + row  + "," + col + "] " + board[row][col] + " ");
			if (!board[row][col].equals(OorX)) {
				secondDiagonal = false;
			}
			
			if (secondDiagonal) {
				return true;
			}
			
			return false;
	   }
	   
	   /**
	    * 
	    * This method checks if a player has won the game via a row, col, or diagonal
	    * @return: true if the game is won, false otherwise
	    */
	   public boolean checkWin()
	   {
		   if (checkRow() || checkCol() || checkDiag()) {
			   return true;   
		   }
		   return false;
		   
	   }

}
