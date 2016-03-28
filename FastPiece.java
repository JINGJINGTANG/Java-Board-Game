//FastPiece class
public class FastPiece extends Piece
{
	//constructor accepts input and writes them into super class
	public FastPiece(String n, String c, int x, int y)
	{
		super(n, c, x, y);
	}
	//method moveLeft accepts a number and moves the piece left for certain spaces
	public void moveLeft(int num)
	{
		if (getYpos() + num > 7)
			return;
		else
			setXpos(getYpos() - num);
	}
	//method moveRight accepts a number and moves the piece right for a certain spaces
	public void moveRight(int num)
	{
		if (getYpos() + num > 7)
			return;
		else
			setYpos(getYpos() + num);
	}
	//method move accepts a diretion and a number and moves the piece toward that direction for a certain spaces
	public void move(String dir, int num)
	{
		if (dir.equalsIgnoreCase("left"))
		{
			if (getYpos() + num > 7)
				return;
			else 
				setYpos(getYpos() - num);
		}
		else if (dir.equalsIgnoreCase("right"))
		{
			if (getYpos() + num > 7)
				return;
			else
				setYpos(getYpos() + num);
		}
	}
	//toString method returns the info from super class
	public String toString()
	{
		return super.toString();
	}
}