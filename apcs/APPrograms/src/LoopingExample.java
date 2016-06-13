import java.util.Scanner;

public class LoopingExample {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); //Keyboard input
		int firstNumber = 0 ;
		int secondNumber = 0 ;
		int sum = 0 ;
		double average = 0 ;
		String answer = "yes" ;
		while (answer.equalsIgnoreCase("yes"))
		{
			System.out.print ("Enter the first number: ");
			
			firstNumber = scan.nextInt();
			
			System.out.print("Enter the second number: ");
			secondNumber = scan.nextInt();
			
			sum = firstNumber + secondNumber ;
			average = sum / 2.0 ;
						
			System.out.println ("First number:          " + firstNumber);
			System.out.println ("Second number:         " + secondNumber);
			System.out.println ("Sum:                   " + sum);
			System.out.println ("Average:               " + average);
			System.out.println ("Would you like to repeat?  ");
			answer = scan.next();
			
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
		
	}
		scan.close();// Stops all keyboard input
		


	}

}
