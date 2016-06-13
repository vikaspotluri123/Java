import java.util.*;

import static java.lang.System.*;

public class TicketTester 
{

	public static void main(String [] args)
	{
		Ticket a;
		a = new Walkup();
		out.println(a);
		
		a = new Advance(10);
		out.println(a);
		
		a = new StudentAdvance(5);
		out.println(a);
		
		
	}
}
