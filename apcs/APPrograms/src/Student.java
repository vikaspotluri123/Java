//import java.util.Scanner;

public class Student 
{		

	//fields (attributes)
	private String name;
	private int idNumber;
	private double average;
	private int test1;
	private int test2;
	private int test3;
	
	//Default consturctor
	public Student()
	{
		name = "default student";
		idNumber = 999999;
		average = 0.0 ;	
	}
	
	public Student(String name, int id, double average)
	{
		this.name = name;
		this.idNumber = id;
		this.average = average;
		
	}
	public Student(String name, int id)
	{
		this.name = name;
		this.idNumber = id;
		average=0;
	}
	
	
	
	// accessors (get methods)
	public String getName()
	{
		return name;
	}
	
	public int getIdNumber()
	{
		return idNumber;
	}
	public double getAverage()
	{
		average = (test1 + test2 + test3)/3.0;
		return average;
	}
	

	//Mutatator methods - set
	public void setName(String name)
	{
		this.name = name;
	}
	public void setId(int Id)
	{
		this.idNumber = Id;
	}
	public void setTest1(int score)
	{
		test1 = score;
	}
	public void setTest2(int score)
	{
		test2 = score;
	}
	public void setTest3(int score)
	{
		test3 = score;
	}
	// overights default memory string
	public String toString()
	{
		return name + "               " + idNumber + "                      " + getAverage();
	}
	
}//end of class
