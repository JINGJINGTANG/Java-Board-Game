//FastFlexible class
public class FastFlexible extends FastPiece
{
	//constructor that accepts data and write them into super class
	public FastFlexible(String n, String c, int x, int y)
	{
		super(n, c, x, y);
	}
	//method moveFF accepts a direction and a space data and moves the piece toward a dirction for a certain spaces
	public void moveFF(String dir, int space)
	{
		if (dir.equalsIgnoreCase("left"))
		{
			if (getYpos() == 0)
				return;
			else
				setYpos(getYpos() - space);
		}
		else if (dir.equalsIgnoreCase("right"))
		{
			if (getYpos() == 7)
				return;
			else
				setYpos(getYpos() + space);
		}
		else if (dir.equalsIgnoreCase("up"))
		{
			if (getXpos() == 0)
				return;
			else
				setXpos(getXpos() - space);
		}
		else if (dir.equalsIgnoreCase("down"))
		{
			if (getXpos() == 7)
				return;
			else
				setXpos(getXpos() + space);
		}
	}
}