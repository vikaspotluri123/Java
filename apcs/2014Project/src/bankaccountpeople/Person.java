package bankaccountpeople;
public class Person 
{
	private String firstName;
	private int age;
	private long ssn;
	private String role;
	private String username;
	private String password;
	public Person()
	{
	  firstName = "";	
	}
	public Long getId()
	{
		return ssn;
	}
	public String getUsername()
	{
		return username;
	}
	public String getPassword()
	{
		return password;
	}
	public void setFirstName()
	{
		
	}
	public void setLastName()
	{
		
	}
	public void setName()
	{
		
	}
	public String getName()
	{
		String s = "";
		return s;
	}
	public void setPassword(String pass)
	{
		password = pass;
	}
	public String getRole()
	{
		return role;
	}
	public boolean canSetUsername()
	{
		return true;
	}
	
}