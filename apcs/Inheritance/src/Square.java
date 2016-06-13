import java.util.*;

import static java.lang.System.*;

public class Square extends Shape // if you did not define getArea or getPerimeter, you would get an error because they're abstract and not defined. 
{
	private double side;
	
	public Square()
	{
		super(); // not required. IF YOU DO CALL IT IT HAS TO BE THE FIRST THING THAT HAPEENS. < PERIOD ;)
		side = 0;
	}
	
	public Square(String name, double side)
	{
		super(name);
		this.side= side;
	}
	
	public Square(String name)
	{
		super(name);
		side = 0;
	}
	
	public double getArea()
	{
		return Math.pow(side,2);
	}
	
	public double getPerimeter()
	{
		return 4 * side;
	}
}
