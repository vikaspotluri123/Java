import java.util.Scanner;


public class mean {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int count = 0;
		double sum = 0;
		int num ;
		 
		while (true)
		{

				if (count == 0)
					System.out.println("Please enter the first number of the data set. ");
				else
					{
						System.out.print("Please enter another number to add to the data set. ");
						System.out.println("If you have inputted your last number into the data set, please enter the characters done to calculate the mean. Otherwise, please enter any character");
						String completion = scan.next();
							if (completion == "done")
								break;
					}
			num = scan.nextInt();			
			count ++;
 sum = sum + num;
		};
		
		double mean = sum / count ;
		System.out.println("The mean of the data you have given me is: " + mean);
		
		scan.close();
	}

}