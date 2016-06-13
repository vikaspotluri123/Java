package bankaccountpeople;
/*
 * Created by Vikas Potluri
 */
import java.util.ArrayList;
public class Computer extends Person
{
	private String name;
	private String role;
	private Long id;
	private String username;
	private String password;
	public Computer()
	{
		name = "";
		role = "Computer";
		id = 0L;
	}
	
	public Computer(String n, String r, long an, String u, String p)
	{
		name = n;
		role = r;
		id = an;
		password = p;
		username = u;
	}
	public void setPassword(String p)
	{
		password = p;
	}
	public String getPassword()
	{
		return password;
	}
	public void setName(String n)
	{
		name = n;
	}
	
	public void setRole(String r)
	{
		role = r;
	}
	
	public void setId(Long n)
	{
		id = n;
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
	public String getName()
	{
		return name;
	}
	
	public String getRole()
	{
		return role;
	}

	public String toString()
	{
		String s;
		s = "Name \t\t"+getName() + "\n";
		s +="AccountNumber \t"+getId() + "\n";
		s +="Role \t\t"+getRole() + "\n";
		return s;
	}
}
