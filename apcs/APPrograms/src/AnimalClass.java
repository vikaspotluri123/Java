import java.util.*;
import static java.lang.System.*;

public class AnimalClass 
{
	private String name;
	private String type;
	private double weight;
	
public AnimalClass()
{
	name ="name goes here";
	type ="animal";
	weight = 10000;
	
}

public AnimalClass(String n, String t, double w)
{
	name = n;
	type = t;
	weight = w;
}

public String toString()
{
	String s ="";
	
	s += "Name........." + name +"\n";
	s += "Type........." + type + "\n";
	s += "Weight......." + weight + "\n";
	return s;
}

public String getName()
{
	return name;
}

public String getType()
{
	return type;
}
public double getWeight()
{
	return weight;
}

public void setName(String n)
{
	name = n;
}
public void setWeight(double w)
{
	weight = w;
}
public void setType(String t)
{
	type = t;
}
}
