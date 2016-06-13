import java.util.Scanner;

public class GuessingGame {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); //Keyboard input
		String playAgain = "yes";
		
		while (playAgain.equalsIgnoreCase("yes"))
		{
			int numberOfGuesses = 0 ;
			int userGuess = 0;
			double deciNumber = Math.random();
			int number = (int)(deciNumber *200 + 1);
			String guessIsRight = "false" ;
			int count = 0;
			
			//The guessing game
			while (guessIsRight == "false" && numberOfGuesses <15)
				
				{	if (count == 0) { System.out.println("Please take a guess on what the number is."); count ++;}
					else System.out.println("Please guess the number again because your guess was wrong.");
					userGuess = scan.nextInt();
						numberOfGuesses ++;
					if (userGuess != number)
						guessIsRight = "false";
					else guessIsRight = "true" ;
					if (userGuess < number)
						System.out.print("Your guess is too low. ");
					if (userGuess > number)
						System.out.print("Your guess is too high. ");
				}
		
			if (numberOfGuesses == 15)
				System.out.println ("Sorry you're such an idiot to not be able to guess a number between 1 and 200 but the number you would've guessed if you were smart is  " + number + ".");
			else 
				if (guessIsRight == "true")
			System.out.println("Congratulations! You guessed the right number. It took you " + numberOfGuesses + " trys to guess the number.");
			System.out.print("Would you like to play again?");
			playAgain = scan.next();
		}
			
		System.out.print ("Goodbye.");
		scan.close();// Stops all keyboard input
	}
	

}
