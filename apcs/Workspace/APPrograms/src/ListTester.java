import java.util.Scanner;

public class ListTester {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); //Keyboard input

		MyList listing = new MyList();
		
		listing.add("lol");
		listing.add("hi");
		listing.add(2,"derp");
		System.out.println(listing);
	
		String [] x = {"a" , "b" , "c", "d"};
		listing.add(x);
		System.out.println(listing);
		
		System.out.println ("Changing......................        " + listing.set(2, "bye"));
		System.out.println(listing);
		
		listing.remove(1);
		System.out.println(listing);
		
		
		scan.close();// Stops all keyboard input
	} // end of main

} // end of class
	