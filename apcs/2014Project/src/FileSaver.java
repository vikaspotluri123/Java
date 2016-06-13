/*
 * Created by Vikas Potluri
 */
import java.util.ArrayList;
import java.io.File;
import java.io.FileInputStream;
public class FileSaver 
{
	private String file ="";
	private ArrayList<Person> people = new ArrayList<Person>();
	public FileSaver(ArrayList<Person> p)
	{
		people = p;
		setup();
	}
//	/tod
	public void setup()
	{
		char breaker = 10;
		char colon = 58;
		for(int i = 0 ; i < people.size(); i++)
			switch(people.get(i).getRole().toLowerCase())
			{
			case "manager":
			{
				//needs to be people.get(i).getFirstName()+people.get(i).getLastName() to replace people.get(i).getName();
				//DON'T DO THIS FOR THE COMPUTER CLASS
				file += "Manager"+colon+people.get(i).getName()+colon+people.get(i).getEmployeeId()+colon+people.get(i).getUsername()+colon+people.get(i).getPassword()+colon+people.get(i).getCanSetUsername()+colon+breaker;
			}
			case "bankteller":
			{
				file += "BankTeller"+colon+people.get(i).getName()+colon+people.get(i).getEmployeeId()+colon+people.get(i).getUsername()+colon+people.get(i).getPassword()+colon+people.get(i).getCanSetUsername()+colon+breaker;
			}
			case "computer":
			{
				file += "Computer"+colon+people.get(i).getName()+colon+people.get(i).getId()+colon+people.get(i).getUsername()+colon+people.get(i).getPassword()+colon+colon+breaker;
			}
			case "client":
			{
				file += "Client"+colon+people.get(i).getName()+colon+people.get(i).getAccountNumber()+colon+people.get(i).getUsername()+colon+people.get(i).getPassword()+colon+people.get(i).getCanSetPassword()+colon+breaker;
			}
			default:
			{
				
			}
			}
	}
	public void save()
	{
		
	}
}
