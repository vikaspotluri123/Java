import java.util.*;
import static java.lang.System.*;

public class BinarySearch 
{
	private List <Integer> list;
	
	public BinarySearch()
	{
		list = new ArrayList<Integer>();
		for (int i = 4; i<100; i = i + 3)
			list.add(new Integer(i));
	}
	
	public String toString()
	{
		return list.toString();
	}
	/*
	 * PreCondition : There is an array list that is ORDERED (ie alphabetical numerical,etc)  
	 * Postcondition:  Returns the location of the number; if the number doesn't exist in the ArrayList, returns -1 
	 */
	public int binarySearch (Integer value)
	{
	 int front = 0;
	 int back = list.size()-1;
	 int middle = (front + back) /2;
	 while (front <= back)
	 	{
		 //If you find it, return the middle
	     if (list.get(middle) .equals(value))
	          return middle;
	     else
	          {
	    	    // If the middle was less than the value, make the middle bigger by increasing the size of front.
	           if (list.get(middle) < value)
	               front = middle + 1 ;
	           // If the middle was greater than the value, make the middle smaller by decreasing the size of back.
	           else
	               back = middle - 1;
	            }
	     		//find the average of the middle again.
	           middle = (front + back)/2 ;
	 	}
	 // if the number doesn't exist, the pointers will cross (back will come before front) and so that means the number is not in that array list, so we can retun -1. 
	return -1;
	}

	public static void main(String[] args) 
	{
		BinarySearch tester = new BinarySearch();
		out.println("Testing the binary search");
		out.println(tester);
		out.println(tester.binarySearch(4));
		out.println(tester.binarySearch(97));
		out.println(tester.binarySearch(40));
		out.println(tester.binarySearch(42));
		
	}

}
