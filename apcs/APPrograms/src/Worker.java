public class Worker
{
	private String name;
	private double hoursWorked;
	private double hourlyRate;
	public String getHourlyRate;
	
	public Worker ()
	{
		name = "<insert name here>";
		hoursWorked = 0;
		hourlyRate = 0;
		
	}
	
	public Worker(String n)
	{
		name = n;
		hoursWorked = 0;
		hourlyRate = 0;
		
	}
	public Worker (String n, double hW, double hR)
	{
		name = n;
		hoursWorked = hW;
		hourlyRate = hR;
	}
	public Worker(String n, double hW)
	{
		name = n;
		hoursWorked = hW;
		hourlyRate = 0;
	}
	
	//accessors
	
	public String getName()
	{
		return name;
	}
	public double getHoursWorked()
	{
		return hoursWorked;
	}
	public double getHourlyRate()
	{
		return hourlyRate;
	}
	public double totalPay()
	{
		return (hoursWorked*hourlyRate);
	}
	public String toString()
	{
		return name + "  " + hoursWorked + "  " + "  " + hourlyRate;
	}	
	
	// mutators
	
	public void setName(String n)
	{
		name = n;
	}
	public void setHourlyRate(double n)
	{
		hourlyRate = n;
	}
	public void setHoursWorked(double n)
	{
		hoursWorked = n;
	}
	public void payRaise()
	{
		hourlyRate +=2 ;
	}
}