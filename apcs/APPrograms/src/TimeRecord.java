import java.util.*;
import static java.lang.System.*;

public class TimeRecord
{
	private String name;
	private int hours;
	private int minutes;
	
	public TimeRecord()
	{
		name = "Name goes here";
		hours = 0;
		minutes = 1;
	}
	
	public TimeRecord(String n, int h, int m)
	{
		name = n;
		hours = h;
		minutes = m;
	}
	public TimeRecord (String name)
	{
		this();
		this.name = name;
	}
	public String toString()
	{
		return name + "\n" + hours + "\n" + minutes + "\n";
	}
	
	public void advance(int hours, int minutes)
	{
		this.hours += hours;
		this.minutes += minutes;
	}
}