package bankaccountpeople;
/*
 * Created by Vikas Potluri
 */
import java.util.ArrayList;
public class BankTeller extends Person
{
	private String firstName;
	private String lastName;
	private String role;
	private boolean canSetUsername;
	private String username;
	private String password;
	private Long employeeId;
	
	public BankTeller()
	{
		firstName = "";
		lastName = "";
		role = "BankTeller";
		employeeId = 0L;
	}
	

	public BankTeller(String fn, String ln, String r, Long an, String u, String p, boolean b)
	{
		firstName = fn;
		lastName = ln;
		role = r;
		employeeId = an;
		username = u;
		canSetUsername = b;
		password = p;
	}
	public boolean canSetUsername()
	{
		return canSetUsername;
	}
	public boolean setUsername(String u)
	{
		if(canSetUsername)
		{
			username = u;
			canSetUsername = false;
			return true;
		}
		else
			return false;
	}
	public String getUsername()
	{
		return username; 
	}
	public String getPassword()
	{
		return password;
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
	
	public void setEmployeeId(Long n)
	{
		employeeId = n;
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
	public long getEmployeeId()
	{
		return employeeId;
	}
	
	public String toString()
	{
		String s;
		s = "Name \t\t"+getFullName() + "\n";
		s +="AccountNumber \t"+getEmployeeId() + "\n";
		s +="Role \t\t"+getRole() + "\n";
		return s;
	}
	public String getName()
	{
		return firstName + lastName;
	}
}
