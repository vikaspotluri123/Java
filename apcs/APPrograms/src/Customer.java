import java.util.*;
import static java.lang.System.*;

public class Customer 
{
	private String firstName;
	private String lastName;
	private int age;
	
	
	public Customer()
	{
		firstName="";
		lastName ="";
		age = 0;
	}
	
	public Customer(String f, String l, int a)
	{
		age = a;
		firstName = f;
		lastName =  l;
	}
	
	public String toString()
	{
		return "First name................"+firstName+"\n Last name..................."+lastName+"\n Age.................."+age+"\n";
	}
	
	public String getFirstName()
	{
		return firstName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public int getAge()
	{
		return age;
	}
	
	public void setFirstName(String f)
	{
		firstName = f;
	}
	
	public void setLastName(String l)
	{
		lastName = l;
	}
	
	public void setAge(int a)
	{
		age = a;
	}
}
