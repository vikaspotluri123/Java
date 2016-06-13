import java.util.Scanner;

public class PythagoreanTheorem {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); //Keyboard input

		{
			System.out.println("Enter side 'a'    ");
			double a = scan.nextDouble();
			System.out.println("Enter side 'b'");
			double b = scan.nextDouble();
			
			double answer = Math.sqrt(Math.pow(a,2)+Math.pow(b,2));
	
			System.out.println("The length of side 'C' when 'A' = " + a + " and 'B' = " + b + " is " + answer);
		}
		
		scan.close();// Stops all keyboard input

	}

}
