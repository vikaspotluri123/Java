import java.util.Scanner;

public class Arrays2D {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); //Keyboard input

		int [] [] grid = new int [4][2];
		int r = 0;
		int c = 0;
		
		for (r = 0 ; r < grid.length ; r++)
			for (c = 0 ; c < grid[r].length ; c++)
			{
				System.out.println ("Enter a number for the location " + r + " , " + c + ":  ");
				grid[r][c] = scan.nextInt();
			}
		
		for (r = 0 ; r < grid.length ; r++)
		{
			System.out.println("  ");
		
			for ( c = 0 ; c < grid[r].length ; c++)
			{
				System.out.print(grid[r][c] + "     ");
				
			}
		}
		scan.close();// Stops all keyboard input

	}

}
