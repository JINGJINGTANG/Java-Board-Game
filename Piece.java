//Piece class
public abstract class Piece
{
	//create variables
	private String name;
	private String colour;
	private int xpos = 0, ypos = 0; 
	//construstor that accept input and writes each data
	public Piece(String n, String c, int x, int y)
	{
		name = n;
		colour = c;
		xpos = x;
		ypos = y;
	}
	//get and set methods
	public String getName()
	{
		return name;
	}
	public String getColour()
	{
		return colour;
	}
	public void setXpos(int x)
	{
		xpos = x;
	}
	public void setYpos(int y)
	{
		ypos = y;
	}
	public int getXpos()
	{
		return xpos;
	}
	public int getYpos()
	{
		return ypos;
	}
	//toString method that returns basic information of the piece
	public String toString()
	{
		return name + "\t" + colour + "\t" + xpos + "\t" + ypos;
	}

}