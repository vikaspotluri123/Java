/*
 * Created by Vikas Potluri
 */
import java.util.ArrayList;
public class Client extends Person
{
	private String firstName;
	private String lastName;
	private String role;
	private Long accountNumber;
	private int balance;
	private int lowestBalance;
	private long ssn;
	private String emailAddress;
	private String address;
	private String username;
	private String password;
	public Client()
	{
		username ="";
		password ="";
		firstName = "";
		lastName = "";
		role = "client";
		accountNumber = 0L;
		balance = 0;
		lowestBalance = 0;
		emailAddress = "";
		address = "";
		ssn = 0000000000L;
	}
	public Client(String fn, String ln, String r, Long an, int b, int lb, int sn,String u, String p)
	{
		firstName = fn;
		lastName = ln;
		role = r;
		accountNumber = an;
		balance = b;
		lowestBalance = lb;
		ssn = sn;
		username = u;
		password = p;
	}
	public Client(String fn, String ln, String r, Long an, int b, int lb, String ea, String add, int sn)
	{
		firstName = fn;
		lastName = ln;
		role = r;
		accountNumber = an;
		balance = b;
		lowestBalance = lb;
		emailAddress = ea;
		address = add;
		ssn = sn;
	}
	public void setFirstName(String n)
	{
		firstName = n;
	}
	public void setLastName(String n)
	{
		lastName = n;
	}
	public void setRole(String r)
	{
		role = r;
	}
	public void setAccountNumber(Long n)
	{
		accountNumber = n;
	}
	public long generateAccountNumber(ArrayList<Long> data)
	{
		boolean isInList = true;
		long number = -1;
		while(isInList)
		{
			isInList = false;
			number = (long)(Math.random()*10000000000L);
			for(int i =0; i < data.size(); i++)
			{
				if(data.get(i).equals(number))
				isInList = true;
			}
		}
		return number;
	}
	public void setBalance(int b)
	{balance = b;}
	public void setLowestBalance(int lowest)
	{lowestBalance = lowest;}
	public void setLowestBalanceAuto(int percentOfBalance)
	{
		int total = getBalance();
		lowestBalance = total * (percentOfBalance/100);
	}
	public void setSsn(Long sn)
	{
		ssn = sn;
	}
	public void setEmailAddress(String email)
	{
		emailAddress = email;
	}
	public void setAddress(String add)
	{
		address = add;
	}
	public String getFullName()	
	{
		return firstName + lastName;
	}
	public String getFirstName()
	{
		return firstName;
	}
	public String getLastName()
	{
		return lastName;
	}
	public String getRole()
	{
		return role;
	}
	public long getAccountNumber()
	{
		return accountNumber;
	}
	public int getBalance()
	{
		return balance;
	}
	public int getLowestBalance()
	{
		return lowestBalance;
	}
	public Long getSocialSecurityNumber()
	{
		return ssn;
	}
	public String getEmailAddress()
	{
		return emailAddress;
	}
	public String getAddress()
	{
		return address;
	}
	public String toString()
	{
		String s;
		s = "Name \t\t"+getFullName() + "\n";
		s +="AccountNumber \t"+getAccountNumber() + "\n";
		s +="Role \t\t"+getRole() + "\n";
		return s;
	}
	public String getName()
	{
		return firstName + lastName;
	}
}