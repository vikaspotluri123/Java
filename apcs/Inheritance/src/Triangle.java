import java.util.*;

import static java.lang.System.*;

public class Triangle extends Shape // if you did not define getArea or getPerimeter, you would get an error because they're abstract and not defined. 
{
	private double height;
	private double base;
	private double side1;
	private double side2;
	
	public Triangle()
	{
		super(); // not required. IF YOU DO CALL IT IT HAS TO BE THE FIRST THING THAT HAPEENS. < PERIOD ;)
		height = 0;
		base = 0;
		side1=0;
		side2=0;
	}
	
	public Triangle(String name, double side, double base, double side2, double side1)
	{
		super(name);
		this.height = height;
		this.base = base;
		this.side1 = side1;
		this.side2 = side2;
	}
	
	public Triangle(String name)
	{
		super(name);
		height = 0;
		base = 0;
		this.side1=0;
		this.side2=0;
	}
	
	public double getArea()
	{
		return .5 * base * height; 
	}
	
	public double getPerimeter()
	{
		return side1 + side2 + base;
	}
}
