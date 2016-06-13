import java.util.*;
import static java.lang.System.*;

public class PotluriInvestments {

	public static void main(String[] args) {
		BankAccount account = new BankAccount();
		int choice = 0;
		Scanner scan = new Scanner(System.in); //Keyboard input
		choice =0;
		
		while(choice != 6)
		{
			out.println("1. Change the name");
			out.println("2. Change the account number");
			out.println("3. Deposit money");
			out.println("4. Withdraw Money");
			out.println("5. Get the account information");
			out.println("6. Exit");
			out.println("What would you like to do?");
			choice = scan.nextInt();
			
			if (choice ==1)
			{
				out.println("What is your new name?  ");
				out.print("My new name is :   ");
				String newName=scan.next();
				account.setName(newName);
				out.println("Thanks! Your name has been changed.");
			}
			else
				if (choice == 2)
				{
					out.println("What is the new account number?");
					out.print("My new account number is: ");
					int newNumber = scan.nextInt();
					account.setAccountNumber(newNumber);
					out.println("Thanks! Your account number has been changed.");
				}
				else
					if(choice == 3)
					{
						out.println("How much money are you depositing today?");
						out.print("I am depositing $");
						double depositAmount = scan.nextDouble();
						account.deposit(depositAmount);
						out.println("Thanks! Your deposit has been added.");
					}
					else
						if(choice == 4)
						{
							out.println("How much money are you withdrawing today?");
							out.print("I am withdrawing $");
							double withdrawAmount = scan.nextDouble();
							account.withdraw(withdrawAmount);
							out.println("Thanks! Your money is below.");
						}
						else
							if(choice == 5)
							{	
								out.println(account.toString());
							}
						else
							if(choice == 6)
							{
								out.println("goodbye");
								exit(-1);
							}
							else
								out.println("Please enter a valid number.");
		}
			scan.close();// Stops all keyboard input

	}

}
