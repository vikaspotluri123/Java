import java.util.*;
import static java.lang.System.*;

public class Classroom 
{
	private int number;
	private char hall;
	private int capacity;
	
public Classroom()
{
	number = 42;
	hall = 'a';
	capacity = 9000;
}
public Classroom(int n, char h, int c)
{
	number = n;
	hall = h;
	capacity = c;
}

public String toString()
{
	String s;
	s = "Number........." + number +"\n";
	s += "Hall..........." + hall + "\n";
	s += "Capacity......." + capacity + "\n";
	return s;
}

public int getNumber()
{
	return number;
}
public char getHall()
{return hall;}
public int getCapacity()
{return capacity;}
public void setNumber(int n)
{number = n;}
public void setHall(char h)
{hall = h;}
public void setCapacity(int c)
{capacity = c;}

}
