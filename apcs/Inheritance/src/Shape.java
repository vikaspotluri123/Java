import java.util.*;

import static java.lang.System.*;

public abstract class Shape //see the getArea and getPerimeter methods 
{
	private String name;
	
	public Shape()
	{
		name = "";
	}
	
	public Shape(String n)
	{
		name = n;
	}
	
	public void setName(String n)
	{
		name = n;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String toString()
	{
		return "Name:" + name +"\n Perimeter:" + getPerimeter() + "\n Area:" + getArea();
	}
	
	public abstract double getArea(); // abstract is there because there's no universal formula for area
	public abstract double getPerimeter(); // this is also abstract because the formula for perimeter is not the same for everything. See circle class for more details/
}
