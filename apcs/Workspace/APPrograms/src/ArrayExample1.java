import java.util.Scanner;

public class ArrayExample1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); //Keyboard input
		
		
		int [] list = new int [10];
		int i = 0;
		int sum = 0;
		
		
		// numbers
		for (i = 0 ; i<list.length ; i++)
		{
			System.out.print ("Enter a number: ");
			list [i] = scan.nextInt();
		}
		
		for (i = 0 ; i<list.length ; i++)
		{
			System.out.println("The element at location " + i + " is " + list [i]);
			
		}
		
		for (i = 0 ; i < list.length; i++)
		{
			sum = sum + list [i];
		}
		
		System.out.println ("The sum is " + sum);
		System.out.println ("The average is " + (sum/list.length) );
		// names 
		
		String [] names = new String [5];
		
		for (i = 0 ; i<names.length ; i++)
		{
			System.out.print ("Enter a name: ");
			names [i] = scan.next();
		}
		
		for (i = 0 ; i<names.length ; i++)
		{
			System.out.println("The name at location " + i + " is " + names[i]);
		}
		
		System.out.println(list);
		System.out.println(names);
		scan.close();// Stops all keyboard input

	}

}
