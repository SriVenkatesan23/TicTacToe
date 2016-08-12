import java.awt.Font;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

public class TicTacToe extends JFrame implements MouseListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Board board = new Board(50,150,400,400); //creating board
	String turn = "o";

	public static void main(String[] args){//initializing game
		TicTacToe m = new TicTacToe();
		m.getContentPane().setBackground(Color.darkGray);
		m.setSize(500,600);
		m.setVisible(true);
	}

	public TicTacToe() //randomly set who begins the game
	{
		addMouseListener(this);
		setFocusable(true);
		if(Math.random() < .5) turn = "x";
	}

	public void paint(Graphics g)
	{
		super.paint(g);

		g.setColor(Color.CYAN.darker());
		board.display(g);
		
		if(!board.checkWin().equals("blank")){ //prints winning statements if game has been won
			g.setFont(new Font("Chiller", Font.PLAIN, 70));
			try{
				String winner = board.checkWin().toUpperCase();
				for(int i=0;i<6;i++){
					g.drawString(winner + " Wins!", 125, 130);
					g.setColor(Color.darkGray); 
					Thread.sleep(300);
					g.drawString(winner + " Wins!", 125, 130);
					g.setColor(Color.CYAN.darker());
					Thread.sleep(300);
				}
			}catch (InterruptedException ex){
				Thread.currentThread().interrupt();
			}
			this.board = new Board(50,150,400,400);  //reset board
			repaint();
			
		}else{
			g.setFont(new Font("Chiller", Font.PLAIN, 40)); //print whose turn it is
			g.drawString(turn.toUpperCase() + "'s Turn", 177,110);
		}

		
	}
	/**
	 * 	this method allows the players to interact with the board
	 */
	public void mouseClicked(MouseEvent e) 
	{
		if(board.updateBoard(e.getX(), e.getY(), turn)){ //when player clicks tile, switch turns
			if(turn.equals( "o")) turn = "x";
			else turn = "o";
			repaint();
		}
	}
	public void mouseEntered(MouseEvent e){
	}
	public void mouseExited(MouseEvent e){
	}
	public void mousePressed(MouseEvent e){
	}
	public void mouseReleased(MouseEvent e){
	}

}









