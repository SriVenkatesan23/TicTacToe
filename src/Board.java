import java.awt.Graphics;

public class Board {
	private piece[][] board;
	public int x, y;
	public int width, height;
	public int xscore,yscore;
	public String displayValue;
	/**
	 * constructor = sets values to instance variables
	 * @param x = x coord 
	 * @param y = y coord
	 * @param width = width of board
	 * @param height = height of board
	 */
	public Board(int x, int y, int width, int height){//sets values of variables for the board
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
		board = new piece[3][3];
		for(int r = 0; r < 3; r++){
			for (int c = 0; c < 3; c++){
				board[r][c] = new piece(x + c*width/3, y + r*height/3, width / 3, height / 3);
			}
		}
		
	}
	public void display(Graphics g) { //prints out the board so the players can see it
		for(int r = 0; r < 3; r++){
			for (int c = 0; c < 3; c++){
				board[r][c].display(g);
			}
		}
	}
	/**
	 * when the player clicks a square, it sets the value of the square to their icon (X or O)
	 * @param checkX - xcoord to check
	 * @param checkY - ycoord to check
	 * @param turn - which player's turn it is
	 * @return the value of turn if the piece contains the point clicked
	 */
	public boolean updateBoard(int checkX, int checkY, String turn){//
		for(int r = 0; r < 3; r++){
			for(int c = 0; c < 3; c++){
				if(board[r][c].contains(checkX, checkY)){	
					return board[r][c].setValue(turn);
				}
			}
		}
		return false;
	}
	
	/**
	 * used to check if a player has won
	 * @returns the winner's icon, or blank if no one has won
	 */
	public String checkWin(){ //checks all the possible ways to win to see if a player has won
		if(!board[0][0].getDisplayValue().equals("blank") &&board[0][0].getDisplayValue().equals(board[1][0].getDisplayValue())&&board[1][0].getDisplayValue().equals(board[2][0].getDisplayValue()) ){
			return board[0][0].getDisplayValue();
		}
		if(!board[0][1].getDisplayValue().equals("blank") &&board[0][1].getDisplayValue().equals(board[1][1].getDisplayValue())&&board[1][1].getDisplayValue().equals(board[2][1].getDisplayValue()) ){
			return board[0][1].getDisplayValue();
		}
		if(!board[0][2].getDisplayValue().equals("blank") &&board[0][2].getDisplayValue().equals(board[1][2].getDisplayValue())&&board[1][2].getDisplayValue().equals(board[2][2].getDisplayValue()) ){
			return board[0][2].getDisplayValue();
		}
		if(!board[0][0].getDisplayValue().equals("blank") &&board[0][0].getDisplayValue().equals(board[0][1].getDisplayValue())&&board[0][1].getDisplayValue().equals(board[0][2].getDisplayValue()) ){
			return board[0][0].getDisplayValue();
		}
		if(!board[1][0].getDisplayValue().equals("blank") &&board[1][0].getDisplayValue().equals(board[1][1].getDisplayValue())&&board[1][1].getDisplayValue().equals(board[1][2].getDisplayValue()) ){
			return board[1][0].getDisplayValue();
		}
		if(!board[2][0].getDisplayValue().equals("blank") &&board[2][0].getDisplayValue().equals(board[2][1].getDisplayValue())&&board[2][1].getDisplayValue().equals(board[2][2].getDisplayValue()) ){
			return board[2][0].getDisplayValue();	
		}
		if(!board[0][0].getDisplayValue().equals("blank") &&board[0][0].getDisplayValue().equals(board[1][1].getDisplayValue())&&board[1][1].getDisplayValue().equals(board[2][2].getDisplayValue()) ){
			return board[0][0].getDisplayValue();
		}
		if(!board[2][0].getDisplayValue().equals("blank") &&board[2][0].getDisplayValue().equals(board[1][1].getDisplayValue())&&board[1][1].getDisplayValue().equals(board[0][2].getDisplayValue()) ){
			return board[2][0].getDisplayValue();
		}
		else{
			return "blank";
		}
	}
}





