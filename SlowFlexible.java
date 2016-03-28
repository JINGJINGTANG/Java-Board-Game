//SlowFlexible class
public class SlowFlexible extends SlowPiece
{
	//constructor that accepts data and writes them into super class
	public SlowFlexible(String n, String c, int x, int y)
	{
		super(n, c, x, y);
	}
	//mehtod moveSF accepts a direction and moves the piece for one space
	public void moveSF(String dir)
	{
		if (dir.equalsIgnoreCase("left"))
		{
			if (getYpos() == 0)
				return;
			else
				setYpos(getYpos() - 1);
		}
		else if (dir.equalsIgnoreCase("right"))
		{
			if (getYpos() == 7)
				return;
			else
				setYpos(getYpos() + 1);
		}
		else if (dir.equalsIgnoreCase("up"))
		{
			if (getXpos() == 0)
				return;
			else
				setXpos(getXpos() - 1);
		}
		else if (dir.equalsIgnoreCase("down"))
		{
			if (getXpos() == 7)
				return;
			else
				setXpos(getXpos() + 1);
		}
	}
}