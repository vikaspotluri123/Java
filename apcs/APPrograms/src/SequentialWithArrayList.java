import java.util.*;

public class SequentialWithArrayList 
{
	private List <String> list;
	
	public SequentialWithArrayList()
	{
		list = new ArrayList <String>();
		list.add("name1");
		list.add("name2");
		list.add("name3");
		list.add("name1");
		list.add("name4");
		list.add("name5");
	}
	public int findFirstInstance(String nameToFind)
	{
		for (int i = 0 ; i < list.size(); i++)
			
			{if(list.get(i).equals(nameToFind))
				return i;
			}
			return -1;
	}
	
	public int findLastInstance(String nameToFind)
	{
		for (int i = list.size()-1; i>=0 ; i--)
			if (list.get(i).equals(nameToFind))
				return i;
			return -1;
	}
	
	public int countInstances(String nameToFind)
	{
		int count = 0;
		
		for (int i = 0 ; i<list.size(); i++)
			if (list.get(i).equals(nameToFind))
				count++;
		return count;
	}
	public static void main(String[] args) 
	{
		System.out.println("Testing sequential with arrayList");
		SequentialWithArrayList tester = new SequentialWithArrayList();
		System.out.println(tester.findFirstInstance("name1")); //Tests findFirstInstance w/ a valid variable
		System.out.println(tester.findFirstInstance("nameas")); //Tests findFirstInstance w/ an invalid variable
		System.out.println(tester.findLastInstance("name1")); //Tests findLastInstance w/ a valid variable
		System.out.println(tester.findLastInstance("nameas")); //Tests findLastInstance w/ a valid variable
		System.out.println(tester.countInstances("name1")); //Tests countInstances w/ a valid variable
		System.out.println(tester.countInstances("nameas")); //Test countInstances w/ a valid variable
	}

}
