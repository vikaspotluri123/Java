import java.util.*;

import static java.lang.System.*;

public class Advance extends Ticket 
{
	private int daysBefore;
	
	public Advance(int daysAdvance)
	{
		this.daysBefore = daysAdvance;
	}
	public double getPrice()
	{
		if(daysBefore >= 10)
			return 30.00;
		return 40.00;
	}
}
