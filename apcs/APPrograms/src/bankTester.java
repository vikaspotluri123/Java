import java.util.*;
import java.util.jar.Attributes.Name;

import static java.lang.System.*;

public class bankTester {

	public static void main(String[] args) 
	{
	
		BankAccount account1 = new BankAccount();
		BankAccount account2 = new BankAccount("name", 10, 215892);
		out.println("Account 1 profile :  " + account1);
		out.println("Account 2 profile :  " + account2);
		out.println("Account 2 balance :  " + account2.getBalance());
		out.println("Account 2 account number " + account2.getAccountNumber());
		out.println("Account 2 owner :  " + account2.getName());
		account1.setName("name2");
		account1.setAccountNumber(124121);
		account1.deposit(999999999);
		account2.withdraw(20.12);
		out.println("Account 2 has a new profile : "+ account2);
		out.println("Account 1 has a new profile : "+ account1);
	}

}
