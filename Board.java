//Board clas
public class Board
{
	//create a Piece object
	private Piece[][] board;
	//constructor that sets a 8x8 board
	public Board()
	{
		board = new Piece[8][8];
	}
	//get method that gets the postion of a piece
	public Piece getBoard(int x, int y)
	{
		return board[x][y];
	}
	//addPiece accepts name, colour, location, and type, then adds it to Piece
	public void addPiece(String n, String c, int x, int y, String t)
	{
		if (board[x][y] != null)
			System.out.println("Piece already existed at this location");
		else if (t.equalsIgnoreCase("slow"))
		{
			SlowPiece slow = new SlowPiece(n, c, x, y);
			board[x][y] = slow;	
		}
		else if (t.equalsIgnoreCase("fast"))
		{
			FastPiece fast = new FastPiece(n, c, x, y);
			board[x][y] = fast;	
		}
		else if (t.equalsIgnoreCase("slowflexible"))
		{
			SlowFlexible sf = new SlowFlexible(n, c, x, y);
			board[x][y] = sf;	
		}
		else if (t.equalsIgnoreCase("fastflexible"))
		{
			FastFlexible ff = new FastFlexible(n, c, x, y);
			board[x][y] = ff;	
		}
	}
	//movePiece method accepts location, direction, number, and type of a piece, then moves the piece.
	public void movePiece(int x, int y, String dir, int num, String type)
	{
		//moves it if it is slowflexible
		if (type.equalsIgnoreCase("slowflexible"))
		{
			if (board[x][y] == null)
				System.out.print("No piece at current location.");
			else if (dir.equalsIgnoreCase("left"))
			{
				board[x][y - 1] = board[x][y];
				board[x][y] = null;
			}
			else if (dir.equalsIgnoreCase("right"))
			{
				board[x][y + 1] = board[x][y];
				board[x][y] = null;
			}
			else if (dir.equalsIgnoreCase("up"))
			{
				board[x - 1][y] = board[x][y];
				board[x][y] = null;
			}
			else if (dir.equalsIgnoreCase("down"))
			{
				board[x + 1][y] = board[x][y];
				board[x][y] = null;
			}
		}
		//moves it if it is fastflexible
		else if (type.equalsIgnoreCase("fastflexible"))
		{	
			if (board[x][y] instanceof FastFlexible)
			{
				if (board[x][y] == null)
					System.out.print("No piece at current location.");
				else if (dir.equalsIgnoreCase("left"))
				{
					board[x][y - num] = board[x][y];
					board[x][y] = null;
				}
				else if (dir.equalsIgnoreCase("right"))
				{
					board[x][y + num] = board[x][y];
					board[x][y] = null;
				}
				else if (dir.equalsIgnoreCase("up"))
				{
					board[x - num][y] = board[x][y];
					board[x][y] = null;
				}
				else if (dir.equalsIgnoreCase("down"))
				{
					board[x + num][y] = board[x][y];
					board[x][y] = null;
				}
			}
		}
		//moves it if ti is slow piece
		else if (type.equalsIgnoreCase("slow"))
		{
			if (board[x][y] == null)
				System.out.println("No piece at current location.");
			else if (dir.equalsIgnoreCase("left"))
			{
				board[x][y - 1] = board[x][y];
				board[x][y] = null;
			}
			else if (dir.equalsIgnoreCase("right"))
			{
				board[x][y + 1] = board[x][y];
				board[x][y] = null;
			}
			else if (dir.equalsIgnoreCase("up") || dir.equalsIgnoreCase("down"))
				System.out.println("slow piece can't move " + dir);
		}
		//moves it if it is fast piece
		else if (type.equalsIgnoreCase("fast"))
		{
			if (board[x][y] == null)
				System.out.print("No piece at current location.");
			else if (!dir.equalsIgnoreCase("left") && !dir.equalsIgnoreCase("right") && !dir.equalsIgnoreCase("up") && !dir.equalsIgnoreCase("down") && num < 1)
				System.out.print("Invalid direction.");
			else if (dir.equalsIgnoreCase("left"))
			{
				board[x][y - num] = board[x][y];
				board[x][y] = null;
			}
			else if (dir.equalsIgnoreCase("right"))
			{
				board[x][y + num] = board[x][y];
				board[x][y] = null;
			}
			else if (dir.equalsIgnoreCase("up") || dir.equalsIgnoreCase("down"))
				System.out.println("fast piece can't move " + dir);
		}
	}
	//toString method prints the board and piece information
	public String toString()
	{
		int row = 0;
		String s = "  0 1 2 3 4 5 6 7 \n";
		for (int i = 0; i < 8; i++)
		{
			s += row++;
			for (int j = 0; j < 8; j++)
			{
				if (board[i][j] != null)
					s += " O";
				else 
					s += " -";
			}
			s += "\n";
		}
		s += "\n";
		for (int k = 0; k < 8; k++)
		{
			for (int l = 0; l < 8; l++)
			{
				if (board[k][l] != null)
				{
					s += "Piece: " + board[k][l].getName() + "\tColour: " + board[k][l].getColour();
					
					if (board[k][l] instanceof SlowFlexible)
						s += "\tType: SlowFlexible\t" + "at [" + k + ", " + l + "] \n"; 
					else if (board[k][l] instanceof FastFlexible)
						s += "\tType: FastFlexible\t" + "at [" + k + ", " + l + "] \n";
					else if (board[k][l] instanceof SlowPiece)
						s += "\tType: SlowPiece\t\t" + "at [" + k + ", " + l + "] \n"; 
					else if (board[k][l] instanceof FastPiece)
						s += "\tType: FastPiece\t\t" + "at [" + k + ", " + l + "] \n";
				}
			}
		}
		return s;
	}
}