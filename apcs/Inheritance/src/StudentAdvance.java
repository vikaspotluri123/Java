import java.util.*;

import static java.lang.System.*;

public class StudentAdvance extends Advance 
{

	public StudentAdvance(int daysAdvance) {
		super(daysAdvance);
	}

	public double getPrice()
	{
		return super.getPrice() /2;
	}
	
	public String toString()
	{
		return super.toString() +  "\n(student id required)";
	}
}
