//PracticeMoves
import java.util.Scanner;
public class PracticeMoves
{
	public  static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		//create a Board object
		Board board = new Board();
		//enter the location of a piece
		System.out.print("Enter a location you want to place the piece: ");
		int x = keyboard.nextInt();
		int y = keyboard.nextInt();
		while (x < 0 || x > 7 || y < 0 || y > 7)
		{
			System.out.println("Invalid input.");
			System.out.print("Enter a location you want to place the piece: ");
			x = keyboard.nextInt();
			y = keyboard.nextInt();
		}
		//enter the type of a piece
		System.out.print("Enter the type(fast, slow, fastflexible, slowflexible): ");
		String type = keyboard.next();
		while (!type.equals("fast") && !type.equals("slow") && !type.equals("fastflexible") && !type.equals("slowflexible"))
		{
			System.out.println("Invalid input.");
			System.out.print("Enter the type(fast, slow, fastflexible, slowflexible): ");
			type = keyboard.next();
		}
		//enter the colour of a piece
		System.out.print("Enter a name and a colour for this piece: ");
		String n = keyboard.next();
		String c = keyboard.next();
		while (!c.equalsIgnoreCase("black") && !c.equalsIgnoreCase("white") && !c.equalsIgnoreCase("red") && !c.equalsIgnoreCase("blue") && !c.equalsIgnoreCase("green"))
		{
			System.out.println("Invalid colour.");
			System.out.print("Re-enter a colour for this piece: ");
			c = keyboard.next();
		}
		//add a piece to board
		board.addPiece(n, c, x, y, type);
		//ask for commands
		System.out.print("Enter a command (enter \"help\" for help):");
		String command = keyboard.next();
		while (!command.equalsIgnoreCase("exit"))
		{
			//move command that moves a piece
			if (command.equalsIgnoreCase("move"))
			{
				System.out.print("Enter the position of the piece you want to move: ");
				x = keyboard.nextInt();
				y = keyboard.nextInt();
				if (board.getBoard(x, y) == null)
					System.out.println("No piede at current location.");
				else 
				{
					System.out.print("Enter a direction you want to move: ");
					String dir = keyboard.next();
					while (!dir.equalsIgnoreCase("left") && !dir.equalsIgnoreCase("right") && !dir.equalsIgnoreCase("up") && !dir.equalsIgnoreCase("down"))
					{
						System.out.println("Invalid direction.");
						System.out.print("Enter a direction you want to move: ");
						dir = keyboard.next();
					}
					System.out.print("Enter the space you want to move: ");
					int space = keyboard.nextInt();
					while (space < 0 || space > 7)
					{
					System.out.println("Invalid input.");
					System.out.print("Enter the space you want to move: ");
					space = keyboard.nextInt();
					}
					board.movePiece(x, y, dir, space, type);
				}
			}
			//prints the board and piece information
			else if (command.equalsIgnoreCase("print"))
				System.out.print(board);
			else if (command.equalsIgnoreCase("help"))
				System.out.println("Enter \"Move\" to move a piece, \"Print\" to print the board, \"add\" to add piece, and enter \"exit\" to quit the game.");
			//add a new piece to the board
			else if (command.equalsIgnoreCase("add"))
			{
				System.out.print("Enter a location you want to place the piece: ");
				x = keyboard.nextInt();
				y = keyboard.nextInt();
				System.out.print("Enter the type(fast, slow, fastflexible, slowflexible): ");
				type = keyboard.next();
				System.out.print("Enter a name and a colour for this piece: ");
				n = keyboard.next();
				c = keyboard.next();
				board.addPiece(n, c, x, y, type);
			}	
			else 
				System.out.print("Invalid command. Enter \"help\" for help.");
			System.out.print("Enter a command (enter \"help\" for help):");
			command = keyboard.next();
		}
		System.out.print("Goodbye!");
	}
}