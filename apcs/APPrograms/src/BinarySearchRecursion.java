import java.util.*;
import static java.lang.System.*;

public class BinarySearchRecursion 
{
	
	private List <Integer> list;
	
	public int size()
	{
		return list.size();
	}

	public BinarySearchRecursion()
	{
		list = new ArrayList<Integer>();
		for (int i = 4; i <100; i=i + 3)
			list.add(new Integer(i));
	}
	
	public String toString()
	{
		return list.toString();
	}
	
	public int binarySearch(Integer valueToFind, int front, int back)
	{
		if (front > back)
			return -1;
		int middle = (front + back)/2;
		
		if (list.get(middle).equals(valueToFind))
			return middle;
		if(list.get(middle) < valueToFind)
			return binarySearch(valueToFind, middle + 1, back);
		else 
			return binarySearch(valueToFind, front, middle-1);
		
	}
	public static void main(String[] args) 
	{
		BinarySearchRecursion tester = new BinarySearchRecursion();
		out.println(tester);
		out.println(tester.binarySearch(97,0,tester.size()-1));
		out.println(tester.binarySearch(4,0,tester.size()-1));
		out.println(tester.binarySearch(42,0,tester.size()-1));
	}

}
