import java.awt.Color;
import java.awt.Graphics;

public class piece {
	private int x, y, width, height;
	private String displayValue; //x, o, or blank

	
	
	
	/**
	 * constructor = set values for instance variables of piece
	 * @param startX = the constructor would set the x to startX
	 * @param startY = the constructor would set the y to startY
	 * @param startWidth = the constructor would set the width to startWidth
	 * @param startHeight= the constructor would set the height to startHeight
	 */
	public piece(int startX, int startY, int startWidth, int startHeight)//default constructor for each piece
	{
		x = startX;
		y = startY;
		width = startWidth;
		height = startHeight;
		displayValue = "blank";
		
	}
	/**
	 * method used to set value of this piece's display
	 * @param newValue is used to change the value of the piece's display 
	 * @return true if the enter value of newValue is valid for the piece
	 */
	public boolean setValue(String newValue) 
	{
		if(displayValue.equals("blank")){
			if(newValue.equals("o") || newValue.equals("x")){
			displayValue = newValue;
			return true;
			}
		}
		return false;
	}
	/**
	 * 
	 * @param g used to display the object
	 */
	public void display(Graphics g) //used to actually print out the X or Y
	{
		g.setColor(Color.BLACK);
		g.fillRect(x, y, width, height);
		g.setColor(Color.CYAN.darker());
		g.drawRect(x, y, width, height);
		g.drawRect(x+1, y+1, width-2, height-2);
		
		if(displayValue.equals("x")){ //draw X
			g.setColor(Color.CYAN.darker());
			g.drawLine(x + width/10, y + height/10, x + 9*width/10, y + 9*height/10);
			g.drawLine(x + 9*width/10, y + height/10, x + width/10, y+ 9*height/10);
		}
		if(displayValue.equalsIgnoreCase("o")){ //draw O
			g.drawOval(x + 8 , y + 7 , width - 16, height - 16); 
			g.drawOval(x + 9 , y + 8 , width - 18, height - 18);
		}
	}
	/**
	 * @returns display value
	 */
	public String getDisplayValue(){
		return displayValue;
	}
	/**
	 * checks if the point clicked is within the box
	 * @param checkX  the x coord of the point to check
	 * @param checkY y coord of the point being checked
	 * @return
	 */
	public boolean contains(int checkX, int checkY){
		return checkX > x && checkY > y && checkX < x + width && checkY < y + height;
	}
	
}

