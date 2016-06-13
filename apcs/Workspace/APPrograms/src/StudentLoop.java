import java.util.Scanner;

public class StudentLoop {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); //Keyboard input
		String answer = "yes";
		Student s = new Student();
		
		while (answer.equalsIgnoreCase("yes"))
		{
			//prompt for name
			System.out.print("Enter the student's name: ");
			s.setName(scan.next());
			//prompt for Id
			System.out.print("Enter the student's ID number: ");
			s.setId(scan.nextInt());
			//promt for the three test scores
			System.out.print("Enter the student's first test score:   ");
			s.setTest1(scan.nextInt());
			System.out.print("Enter the student's second test score:  ");
			s.setTest2(scan.nextInt());
			System.out.print("Enter the student's final test score:   ");
			s.setTest3(scan.nextInt());
			//output
			System.out.println(s);
			//Repeat?
			System.out.print("Would you like to repeat?");
			answer = scan.next();
		}
		
		scan.close();// Stops all keyboard input

	}

}
