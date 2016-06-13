import java.util.*;
import java.lang.System.*;

public class ArrayArrayListReview
{
	private List <Integer> myData;
	private int [] arrayData;

	public ArrayArrayListReview()
	{
		myData = new ArrayList<Integer>();
		myData.add(43);
		myData.add(11);
		myData.add(79);
		myData.add(3);
		myData.add(-50);
		myData.add(62);
		myData.add(45);
		myData.add(38);
		myData.add(9);
		myData.add(8);
		myData.add(-175);
		myData.add(3);
		myData.add(11);
		myData.add(79);
		myData.add(11);
		myData.add(-100);

		arrayData = new int [myData.size()];
		for (int i =0; i < arrayData.length; i++)
			arrayData[i] = myData.get(i);
	}

	public String toString()
	{
		String s ="";

		s = s + "myData =    ";
		for (Integer element : myData)
			s = s + element +" ";

		s = s +"\n\narrayData = ";
		for (int element : arrayData)
			s = s + element +" ";

		return s;
	}


	//returns the location of valueToFind in the ArrayList
	//returns -1 if the element is not in the ArrayList
	//IMPORTANT -- to see if two OBJECT (Integer is an Object) values are the same you MUST use .equals
	public int sequentialSearchList(Integer valueToFind)
	{
		for(int i = 0 ; i < myData.size() ; i ++)
			if (myData.get(i).equals(valueToFind))
				return i;

		return -1;
	}

	//returns the location of valueToFind in the array
	//returns -1 if the element is not in the array
	// use == to see if two int values are the same.
	public int sequentialSearchArray(int valueToFind)
	{
		for (int i = 0 ; i < arrayData.length ; i++)
			if (arrayData[i] == valueToFind)
				return i;

		return -1;
	}

	//return the number of times valueToCount is in the ArrayList - if it is not in the List, return 0
	// define a variable named count
	// look at every element in the list -- with either a for loop or a for each loop
	// if what you are looking at is what you are looking for
	// add one to your count variable
	// after looking at all locations return the value in count.
	//IMPORTANT -- to see if two OBJECT (Integer is an Object) values are the same you MUST use .equals
	public int countInstancesList(Integer valueToCount)
	{
		int counter = 0 ;
		
		for (int i = 0 ; i < myData.size(); i++)
			if (myData.get(i).equals(valueToCount))
				counter++;
		return counter;
	}

	//return the number of times valueToCount is in the array - if it is not in the List, return 0
		// use == to see if two int values are the same.
	public int countInstancesArray(int valueToCount)
	{
		int counter = 0 ;
		for (int i = 0 ; i <arrayData.length ; i++)
			if (arrayData[i] == valueToCount)
				counter++;
		return counter;
	}

	//return the smallest Integer in the list -- not the location.
	//you will need to define an variable that will store what is the smallest number
	// and do not initialize it to 0 - if you are looking at a list that contains only negative numbers would you find the smallestNumber
	// if you start off with 0.  There are two ways to approach this problem.
	//     (1) set your smallNumber variable to Integer.MAX or (2) set your smallNumber variable to the value stored in the first location of your list
	// then look at every value in the listing -- either with a for or a for each
	// if what you are looking at is smaller than what you currently think is the smallest number
	// change the value of smallestNumber to what you are looking at
	// in the end, return the smallestNumber.
	public Integer findSmallestList()
	{
		Integer smallest = Integer.MAX_VALUE;
		for (int i = 0 ; i < myData.size(); i ++)
			if (myData.get(i)< smallest)
				smallest = myData.get(i);
		return smallest;
	}


	public int findSmallestArray()
	{
		Integer smallest = Integer.MAX_VALUE;
		for (int i = 0 ; i < arrayData.length; i ++)
			if (arrayData[i]< smallest)
				smallest = arrayData[i];
		return smallest;
	}

	//return the sum of all the numbers in the ArrayList
	// define a sum variable
	// for every value in the list - either a for loop or a for each loop
	// add the value to the sum (for a hint, look at the toString method above)
	//return the sum
	public int sumArrayList()
	{
		int sum = 0;
		for (int i = 0 ; i<myData.size(); i++)
			sum = myData.get(i) + sum;
		return sum;
	}

	//return the sum of all the numbers in the array
	public int sumArray()
	{
		int sum = 0;
		for (int i = 0 ; i<arrayData.length; i++)
			sum = arrayData[i] + sum;
		return sum;
	}

	//return the average of all the numbers in the ArrayList
	//****cast so you get a double answer
	//****use the sum method from above to calculate the sum -- do not use a for loop in this method.
	public double averageList()
	{
		double average = (sumArrayList()/(myData.size()));
		return average;
	}

	//return the average of all the numbers in the array
	//****cast so you get a double answer
	//****use the sum method from above to calculate the sum
	public double averageArray()
	{
		double average = (sumArray()/(arrayData.length));
		return average;
	}

	//return the last index location of the value in the array list
	//return -1 if valueToFind is not in the ArrayList
	public int findLastInstanceList(Integer valueToFind)
	{
		for (int i = myData.size()-1; i >=0 ; i--)
			if (myData.get(i).equals(valueToFind))
				return i;
		return -1;
	}

	//return the last index location of the valueToFind in the array
	//return -1 if the valueToFind is not in the array
	public int findLastInstanceArray(int valueToFind)
	{
		for (int i =arrayData.length-1; i >=0 ; i--)
			if (arrayData[i]==valueToFind)
				return i;
		return -1;
	}

	//use the iterative (not recursive binarySearch to find valueToFind in the ArrayList
	//return -1 if the value is not in the list otherwise, return the index location of valueToFind
	public int binarySearchList(Integer valueToFind)
	{
		int front = 0;
		 int back = myData.size()-1;
		 int middle = (front + back) /2;
		 while (front <= back)
		 {
		     if (myData.get(middle).equals(valueToFind))
		          return middle;
		     else
		          {
		    
		           if (myData.get(middle) < valueToFind)
		               front = middle + 1 ;
		     
		           else
		               back = middle - 1;
		            }
		     
		           middle = (front + back)/2 ;
		 	}
		 return -1;
	}


	//use the RECURSIVE binarySearch to find the valueToFind in the array
	//return -1 if the value if not in the list - otherwise return the index location of valueToFind
	public int binarySeachArray(int valueToFind, int front, int back)
	{
		if (front > back)
			return -1;
		int middle = (front + back)/2;
		
		if (arrayData[middle]==valueToFind)
			return middle;
		if(arrayData[middle] < valueToFind)
			return binarySeachArray(valueToFind, middle + 1, back);
		else 
			return binarySeachArray(valueToFind, front, middle-1);
	}


	//returns the length of the array -- to be used when calling the recursive binary search methods in the main
	public int arraySize ()
	{
		return arrayData.length;
	}

	public void sorting()
	{
		Collections.sort(myData); //will sort the ArrayList
		Arrays.sort(arrayData);  // will sort the array
	}

	//-----------------------------------------------MAIN METHOD--------------------------------------------------
	//Uncomment the sections you are testing.

	public static void main(String [] args)
	{
		ArrayArrayListReview tester = new ArrayArrayListReview();
		System.out.println(tester);

		System.out.println();
		System.out.println("Array and ArrayList Review Assignment");
		System.out.println();
		System.out.println();

		System.out.println("Testing the sequentialSearchList -- ArrayList");
		//add the following test cases:  search for 3,  11,  42, 43 and -100
		System.out.println(3 + " is found at location " + tester.sequentialSearchList(3));
		System.out.println(11 + " is found at location " + tester.sequentialSearchList(11));
		System.out.println(42 + " is found at location " + tester.sequentialSearchList(42));
		System.out.println(43 + " is found at location " + tester.sequentialSearchList(43));
		System.out.println(-100 + " is found at location " + tester.sequentialSearchList(-100) + "\n");
		
		System.out.println("Testing the sequentialSearchArray -- Array");
		//add the following test cases:  search for 3,  11,  42, 43 and -100
		System.out.println(3 + " is found at location " + tester.sequentialSearchArray(3));
		System.out.println(11 + " is found at location " + tester.sequentialSearchArray(11));
		System.out.println(42 + " is found at location " + tester.sequentialSearchArray(42));
		System.out.println(43 + " is found at location " + tester.sequentialSearchArray(43));
		System.out.println(-100 + " is found at location " + tester.sequentialSearchArray(-100) + "\n");

		System.out.println("Testing the countInstancesList -- ArrayList");
		//add the following test cases:  search for 3,  11,  42, 43 and -100
		System.out.println(3 + " is repeated " + tester.countInstancesList(3) + " times.");
		System.out.println(11 + " is repeated " + tester.countInstancesList(11) + " times.");
		System.out.println(42 + " is repeated " + tester.countInstancesList(42) + " times.");
		System.out.println(43 + " is repeated " + tester.countInstancesList(43) + " times.");
		System.out.println(-100 + " is repeated " + tester.countInstancesList(-100) + " times. \n ");

		System.out.println("Testing the countInstancesArray -- Array");
		//add the following test cases:  search for 3,  11,  42, 43 and -100
		System.out.println(3 + " is repeated " + tester.countInstancesArray(3) + " times.");
		System.out.println(11 + " is repeated " + tester.countInstancesArray(11) + " times.");
		System.out.println(42 + " is repeated " + tester.countInstancesArray(42) + " times.");
		System.out.println(43 + " is repeated " + tester.countInstancesArray(43) + " times.");
		System.out.println(-100 + " is repeated " + tester.countInstancesArray(-100) + " times. \n");

		System.out.println("Testing the findSmallestList  -- ArrayList");
		System.out.println(tester.findSmallestList());
		System.out.println();

		System.out.println("Testing the findSmallestArray -- Array");
		System.out.println(tester.findSmallestArray());
		System.out.println();

		System.out.println("Testing the sumArrayList  -- ArrayList");
		System.out.println(tester.sumArrayList());
		System.out.println();

		System.out.println("Testing the sumArray -- Array");
		System.out.println(tester.sumArray());
		System.out.println();

		System.out.println("Testing the averageList  -- ArrayList");
		System.out.println(tester.averageList());
		System.out.println();

		System.out.println("Testing the averageArray -- Array");
		System.out.println(tester.averageArray());
		System.out.println();

		System.out.println("Testing the findLastInstanceList  -- ArrayList");
		//add the following test cases:  search for 3,  11,  42, 43 and 79
		System.out.println(3 + "is found at " + tester.findLastInstanceArray(3) + ".");
		System.out.println(11 + "is found at " + tester.findLastInstanceArray(11) + ".");
		System.out.println(42 + "is found at " + tester.findLastInstanceArray(42) + ".");
		System.out.println(43 + "is found at " + tester.findLastInstanceArray(43) + ".");
		System.out.println(79 + "is found at " + tester.findLastInstanceArray(79) + ". \n");
		
		System.out.println("Testing the findLastInstanceArray -- Array");
		//add the following test cases:  search for 3,  11,  42, 43 and 79
		System.out.println(3 + " is found at " + tester.findLastInstanceList(3) + ".");
		System.out.println(11 + " is found at " + tester.findLastInstanceList(11) + ".");
		System.out.println(42 + " is found at " + tester.findLastInstanceList(42) + ".");
		System.out.println(43 + " is found at " + tester.findLastInstanceList(43) + ".");
		System.out.println(79 + " is found at " + tester.findLastInstanceList(79) + ". \n");
		tester.sorting();
		System.out.println("Sorted\n" + tester.toString());


		System.out.println("Testing the binarySearchList  -- ArrayList");
		//add the following test cases:  search for 3,  11,  42, 43 and 79
		System.out.println(3 + " is at " + tester.binarySearchList(3));
		System.out.println(11 + " is at " + tester.binarySearchList(11));
		System.out.println(42 + " is at " + tester.binarySearchList(42));
		System.out.println(43 + " is at " + tester.binarySearchList(43));
		System.out.println(79 + " is at " + tester.binarySearchList(79) + "\n");

		System.out.println("Testing the binarySeachArray -- Array  -- RECURSIVE");
		//add the following test cases:  search for 3,  11,  42, 43 and 79
		System.out.println(3 + " is at " + tester.binarySeachArray(3,0,19));
		System.out.println(11 + " is at " + tester.binarySeachArray(11,0,19));
		System.out.println(42 + " is at " + tester.binarySeachArray(42,0,19));
		System.out.println(43 + " is at " + tester.binarySeachArray(43,0,19));
		System.out.println(79 + " is at " + tester.binarySeachArray(79,0,19));

	}

	private int binarySearchArray(int i) {
		// TODO Auto-generated method stub
		return 0;
	}
}
