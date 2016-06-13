import java.util.Scanner;

public class Averaging {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		double average = 0;		
		int score1 = 0, score2 = 0, score3 = 0, score4=0, score5 = 0;
		
		score1 = 100;
		score2 = 98;
		score3 = 75;
		score4 = 98;
		score5 = 93;
				
		average = (score1 + score2 + score3 + score4 +score5)/5.0;
		System.out.println("The average is " + average);
		
		if (( average >= 90) && (average <=100))
				System.out.print("A");
		else 
			if (( average >= 80) && (average <=89))
				System.out.print("B");
			else  
				if (( average >= 70) && (average <=79))
					System.out.print("C");
				else 
					System.out.print("Too bad, you failed. Please hope that your father will not disown you!");
		scan.close();
	}

}
