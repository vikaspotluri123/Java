import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int choice = 0;
		
		while (choice != 6)
		{
		System.out.println("");
		System.out.println("Here are your options for this calculator. Please enter the choice number so I can give you the answer to your question.");
		System.out.println("1. add");
		System.out.println("2. subtract");
		System.out.println("3. display a random number 0-99");
		System.out.println("4. raise to a power");
		System.out.println("5. determine square root");
		System.out.println("6. exit the program");
		System.out.print("My choice is :  ");
		choice = scan.nextInt();
	

			if (choice == 1)
				{
					System.out.println("Enter a number    ");
					double add1 = scan.nextDouble();
			
					System.out.println("Enter a number    ");
					double add2 = scan.nextDouble();
			
					double addanswer = add1 + add2;
			
					System.out.println(add1 + " + " + add2 + " = " + addanswer);
				}
			else
				if (choice ==2)
				{
					System.out.println("Enter a number    ");
					double sub1 = scan.nextDouble();
					
					System.out.println("Enter a number    ");
					double sub2 = scan.nextDouble();
					
					double subanswer = sub1 - sub2;
				
					System.out.println(sub1 + " + " + sub2 + " = " + subanswer);
				}
				else
					if (choice ==3)
					{
						double randomNumber = Math.random();
						int randomSeat = (int)(randomNumber *100);
						System.out.println("I picked the number " + randomSeat);
				}
					else 
						if (choice ==4)
					{
							System.out.println("Enter the base:  ");
							int base = scan.nextInt();
							
							System.out.println("Enter the power:  ");
							int power = scan.nextInt();
						
							int powanswer = (int) Math.pow(base, power);
							System.out.println(base + " to the power of " + power + " is " + powanswer);
							
						}
						else
						if (choice ==5)
							{
								System.out.println("Enter the number to square root:  ");
								int sqrtnum = scan.nextInt();
							
								int sqrtans = (int) Math.sqrt(sqrtnum);
							
								System.out.println ("The square root of " + sqrtnum + " is " + sqrtans);
									
							}
							else 
								System.out.println ("Sorry, the input you entered is invalid. Please pick the choice as listed above (1-6)");
		
		}	
		scan.close();

	}

}
