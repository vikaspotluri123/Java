import java.util.*;

import static java.lang.System.*;

public abstract class Ticket 
{
	private int serialNumber;
	private static int ticketNumberTracker = 1;
	
	public Ticket()
	{
		serialNumber = getNextSerialNumber();
	}
	
	public abstract double getPrice();
	
	public String toString()
	{
		return "Number: " + serialNumber + "\n Price: " + getPrice();
	}
	
	private static int getNextSerialNumber()
	{
		return ticketNumberTracker ++;		
	}
}
