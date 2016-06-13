import java.util.*;

import static java.lang.System.*;

public class Circle extends Shape // if you did not define getArea or getPerimeter, you would get an error because they're abstract and not defined. 
{
	private double radius;
	
	public Circle()
	{
		super(); // not required. IF YOU DO CALL IT IT HAS TO BE THE FIRST THING THAT HAPEENS. < PERIOD ;)
		radius = 0;
	}
	
	public Circle(String name, double radius)
	{
		super(name);
		this.radius = radius;
	}
	
	public Circle(String name)
	{
		super(name);
		radius = 0;
	}
	
	public double getArea()
	{
		return Math.PI * Math.pow(radius,2);
	}
	
	public double getPerimeter()
	{
		return 2 * Math.PI * radius;
	}
}
