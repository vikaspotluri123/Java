import java.lang.System;
public class SequentialSearching2 
{
	private String [] listing = {"trolling","eating","studying","trolling","entertaining"};
	
	public int findFirstInstance(String nameToFind)
	{
		for(int i=0 ; i<listing.length; i++)
		     if (listing[i].equals(nameToFind))  // Do not use .equals() it's used for objects, not primitaves
		          return i;
		     return -1; // No need for an else EVER.
	}
	public int findLastInstance(String nameToFind)
	{
		for (int i =listing.length-1 ; i>=0 ; i--)
		     if (listing[i].equals(nameToFind))  // Do not use .equals() it's used for objects, not primitaves
		          return i;
		     return -1; // No need for an else EVER.
	}
	public int countInstances(String name2find)
	{
		int counter = 0;
		for (int i =0; i < listing.length ; i++)
			if (listing[i].equals(name2find))
				counter++;
		return counter;
	}
	public static void main(String[] args) 
	{
		//a valid variable is a variable that is in the array (the strings)
		
		SequentialSearching2 tester =  new SequentialSearching2();
		System.out.println("Testing sequential searching 2");
//		System.out.println(tester.findFirstInstance("studying")); //Tests findFirstInstance w/ a valid variable
//		System.out.println(tester.findFirstInstance("stu")); //Tests findFirstInstance w/ an invalid variable
//		System.out.println(tester.findLastInstance("studying")); //Tests findLastInstance w/ a valid variable
//		System.out.println(tester.findLastInstance("stu")); //Tests findLastInstance w/ a valid variable
//		System.out.println(tester.countInstances("studying")); //Tests countInstances w/ a valid variable
//		System.out.println(tester.countInstances("stu")); //Test countInstances w/ a valid variable
	}

}