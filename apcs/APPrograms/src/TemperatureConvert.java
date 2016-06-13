import java.util.Scanner;

public class TemperatureConvert {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int count = 0;
		
		while (count != 3)
		{
		System.out.println("");
		System.out.println("Here are your options for this calculator. Please enter the choice number so I can give you the answer to your question.");
		System.out.println("1.	Convert from Fahrenheit to Celsius");
		System.out.println("2.	Convert from Celsius to Fahrenheit");
		System.out.println("3.	Exit the program");
		double choice = scan.nextInt();
	

			if (choice == 1)
				{
					System.out.println("Enter a the temperature in Farenheit    ");
					double temp1 = scan.nextDouble();
					double finaltemp =(temp1 - 32.0)*(5.0/9); 
					
			
					System.out.println(temp1 + " degrees Farenheight is " + finaltemp + " degrees Celcius.");
				}
			else
				if (choice ==2)
				{
					System.out.println("Enter a the temperature in Farenheit    ");
					double temp2 = scan.nextDouble();
					double finaltemp2 = (temp2 *(5/9.0)) + 32.0;
					
			
					System.out.println(temp2 + " degrees Celcius is " + finaltemp2+ " degrees Farenheight.");
				}
				else
					System.out.println ("Sorry, the input you entered is invalid. Please pick the choice as listed above (1-3)");
					
		}		
		scan.close();

	}

}
