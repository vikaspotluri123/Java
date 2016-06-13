import java.util.*;
import static java.lang.System.*;

public class Horse 
{
	private String name;
	private int weight;
	
	public Horse()
	{
		weight = 0;
		name = "";
	}
	
	public Horse(String s, int w)
	{
		name = s;
		weight = w;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getWeight()
	{
		return weight;
	}
	
	public void setName(String n)
	{
		name = n;
	}
	
	public void setWeight(int w)
	{
		weight = w;
	}
	
	public String toString()
	{
		return name+" " + weight;
	}
}
