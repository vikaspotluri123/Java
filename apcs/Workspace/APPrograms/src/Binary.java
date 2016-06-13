import java.util.Scanner;
public class Binary {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in); // Scanner is the type of command, scan is the variable and new makes a new variable. Scanner(System.in) says this is from the keyboard input
		
		
		System.out.print("Please tell me the base you would like to convert to:  "); //Asks the user for the base (We don't want the user to be confused, do we?)
		int base = scan.nextInt(); // defines an int (base) and assigns the int input from the user to it. 
		int number = 0; // defines an int
		int rem = 0; // defines an int
		String answer = "" ; // defines a String
		int startingNumber ; // defines the starting number
		
		System.out.println("Please tell me the number to would like to convert:  ");  // Asks the user for the number to convert
		number = scan.nextInt(); // assigns the keyboard input to the int number
		
		startingNumber = number; // startingNumber is now equal to the number variable
	
		while (number > 0) // division
		{
			rem = number % base; // takes the int rem and assigns it to the remainder of the starting number divided by the base
			number = number / base; // divides the number by the base 
			if (rem == 10)
				answer = "A" + answer;
			else
				if (rem == 11)
					answer = "B" + answer;
				else
					if (rem == 12)
						answer = "C" + answer;
					else
						if (rem == 13)
							answer = "D" + answer;
						else
							if (rem == 14)
								answer = "E" + answer;
							else
								if (rem == 15)
									answer = "F" + answer;
								else answer = rem + answer;
			
		};
		System.out.println(startingNumber + " base 10 == " + answer + " base " + base);
		scan.close();
	}
	

}
