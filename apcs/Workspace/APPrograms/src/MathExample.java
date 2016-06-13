import java.util.Scanner;

public class MathExample {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		double randomNumber = Math.random();
		int randomSeat = (int)(randomNumber *100);
		
		System.out.println(randomNumber);
		System.out.println(randomSeat);
		
		System.out.println(Math.pow(5, 2));
		System.out.println(Math.sqrt(64));
		scan.close();

	}

}
