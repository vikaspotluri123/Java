import java.util.Scanner;

public class StudentTester {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); //Keyboard input
		Student s = new Student();
		Student t = new Student("Vikas", 124016);
		
		
		s.setTest1(64);
		s.setTest2(35);
		s.setTest3(57);
		
		t.setTest1(65);
		t.setTest2(98);
		t.setTest3(97);
		
		System.out.println(s);
		System.out.println(t);
		
		System.out.println(t.getName());
		System.out.println(t.getIdNumber());
		System.out.println(t.getAverage());
		
		t.setName("Vikaas");
		System.out.println(t);
		scan.close();// Stops all keyboard input
		
		//t.average = 100; won't work because average is a private double!
	} //end of main method

} // end of class
