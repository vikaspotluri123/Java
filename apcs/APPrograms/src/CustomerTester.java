import java.util.*;
import static java.lang.System.*;

public class CustomerTester {

	public static void main(String[] args) 
	{
		Customer you = new Customer();
		Customer me = new Customer("Vikas","Potluri",15);
		
		out.println(me);
		out.println(you);
		you.setAge(16);
		you.setFirstName("SuperOkay");
		you.setLastName("Wang");
		out.println("Fixed you..." + you);
		out.println("Fixed me...." + me);
	}

}
