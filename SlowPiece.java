//SlowPiece class
public class SlowPiece extends Piece
{
	//constructor accepts input and writes them into super class
	public SlowPiece(String n, String c, int x, int y)
	{
		super(n, c, x, y);
	}
	//method MoveOneSpace accpts a direction string and moves the piece
	public void moveOneSpace(String dir)
	{
		if (dir.equalsIgnoreCase("left"))
		{
			if (getYpos() == 0)
				return;
			else
				setYpos(getYpos() - 1);
		}
		if (dir.equalsIgnoreCase("right"))
		{
			if (getYpos() == 7)
				return;
			else
				setYpos(getYpos() + 1);
		}
	}
	//toString method returns the information from super class
	public String toString()
	{
		return super.toString();
	}
}