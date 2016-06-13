import java.util.Scanner;

public class OutputExample {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Vikas Potluri " + 15);
		System.out.println("1 + 2 = " +1+2);
		System.out.println("1 + 2 = " + (1+2));

		System.out.println("W\tH\tS");
		System.out.println("W\nH\nS");
		System.out.println("W\bH\bS");
		System.out.println("W\\H\\S");
		System.out.println(6/9);
		System.out.println(6/9.0);
		
		scan.close(); // stops all keyboard input

	}

}
