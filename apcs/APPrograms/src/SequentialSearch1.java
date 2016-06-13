public class SequentialSearch1 
{
	private int [] listing = {1,3,5,7,9,2,4,5,6,8};
	public int findFirstInstance(int numToFind)
	{
		for(int i=0 ; i<listing.length; i++)
		     if (listing[i]== numToFind)  // Do not use .equals() it's used for objects, not primitaves
		          return i;
		     return -1; // No need for an else EVER.
	}
	
	public int findLastInstance(int numToFind)
	{
	for (int i =listing.length-1 ; i>=0 ; i--)
	     if (listing[i]== numToFind)  // Do not use .equals() it's used for objects, not primitaves
	          return i;
	     return -1; // No need for an else EVER.
	}
	
	public int findLastInstanceAnotherWay(int num2find)
	{
		int temp = -1;
		for (int i =0; i < listing.length ; i++)
			if (listing[i] == num2find)
				temp=i;
		return temp;
	}
	
	public int countInstances(int num2find)
	{
		int counter = 0;
		for (int i =0; i < listing.length ; i++)
			if (listing[i] == num2find)
				counter++;
		return counter;
	}
	public static void main(String [] args)
	{
		SequentialSearch1 tester = new SequentialSearch1();
		System.out.println("Testing sequential search 1");
//		System.out.println(tester.findFirstInstance(7)); //tests findFirstInstance w/valid number
//		System.out.println(tester.findFirstInstance(90001)); // tests FindFirstInstance w/invalid number (output shud be -1
//		System.out.println(tester.findLastInstance(5)); // tests findLastInstance with a valid number
//		System.out.println(tester.findLastInstance(51515)); //
//		System.out.println(tester.findLastInstanceAnotherWay(15));
//		System.out.println(tester.findLastInstanceAnotherWay(5));
//		System.out.println(tester.countInstances(5));
//		System.out.println(tester.countInstances(1));
//		System.out.println(tester.countInstances(124));
	}
	
}
