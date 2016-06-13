import java.util.ArrayList;
public class Merge
{
	private ArrayList<Integer> toSort = new ArrayList<Integer>();
	public boolean populate(boolean useToSort, int number)
	{
		if(useToSort)
		{
			int i = 0;
			while(i<=number)
			{
				toSort.add((int)(Math.random()*100));
				i++;
			}
			return true;
		}
		return false;
	}
	public ArrayList<Integer> getArray()
	{
		return toSort;
	}
	public ArrayList<Integer> Merge(ArrayList<Integer> array)
	// pre: array is full, all elements are valid integers (not null)
	// post: array is sorted in ascending order (lowest to highest)
	{
		// if the array has more than 1 element, we need to split it and merge the sorted halves
		if(array.size() > 1)
		{
			// number of elements in sub-array 1
			// if odd, sub-array 1 has the smaller half of the elements
			// e.g. if 7 elements total, sub-array 1 will have 3, and sub-array 2 will have 4
			int elementsInA1 = array.size() / 2;
			// we initialize the size() of sub-array 2 to
			// equal the total size() minus the size() of sub-array 1
			int elementsInA2 = array.size() - elementsInA1;
	                // declare and initialize the two arrays once we've determined their sizes
			ArrayList<Integer> arr1 = new ArrayList<Integer>();
			ArrayList<Integer> arr2 = new ArrayList<Integer>();
			// copy the first part of 'array' into 'arr1', causing arr1 to become full
			for(int i = 0; i < elementsInA1; i++)
				arr1.add(array.get(i));
			// copy the remaining elements of 'array' into 'arr2', causing arr2 to become full
			for(int i = elementsInA1; i < elementsInA1 + elementsInA2; i++)
				arr2.add(i - elementsInA1,array.get(i));
			// recursively call Merge on each of the two sub-arrays that we've just created
			// note: when Merge returns, arr1 and arr2 will both be sorted!
			// it's not magic, the merging is done below, that's how Merge works :)
			arr1 = Merge(arr1);
			arr2 = Merge(arr2);
	 
			// the three variables below are indexes that we'll need for merging
			// [i] stores the index of the main array. it will be used to let us
			// know where to place the smallest element from the two sub-arrays.
			// [j] stores the index of which element from arr1 is currently being compared
			// [k] stores the index of which element from arr2 is currently being compared
			int i = 0, j = 0, k = 0;
			// the below loop will run until one of the sub-arrays becomes empty
			// in my implementation, it means until the index equals the size() of the sub-array
			while(arr1.size() != j && arr2.size() != k)
			{
				// if the current element of arr1 is less than current element of arr2
				if(arr1.get(j) < arr2.get(k))
				{
					// copy the current element of arr1 into the final array
					array.set(i, arr1.get(j));
					// increase the index of the final array to avoid replacing the element
					// which we've just added
					i++;
					// increase the index of arr1 to avoid comparing the element
					// which we've just added
					j++;
				}
				// if the current element of arr2 is less than current element of arr1
				else
				{
					// copy the current element of arr1 into the final array
					array.set(i,arr2.get(j));
					// increase the index of the final array to avoid replacing the element
					// which we've just added
					i++;
					// increase the index of arr2 to avoid comparing the element
					// which we've just added
					k++;
				}
			}
			// at this point, one of the sub-arrays has been exhausted and there are no more
			// elements in it to compare. this means that all the elements in the remaining
			// array are the highest (and sorted), so it's safe to copy them all into the
			// final array.
			while(arr1.size() != j)
			{
				array.set(i, arr1.get(j));
				i++;
				j++;
			}
			while(arr2.size() != k)
			{
				array.set(i,arr2.get(k));
				i++;
				k++;
			}
		}
		// return the sorted array to the caller of the function
		return array;
	}
	public static void main(String [] a)
	{
		System.out.println("Creating a new merge");
		Merge t = new Merge();
		System.out.println("Populating array");
		t.populate(true,100);
		System.out.println("Printing current array");
		System.out.println(t.getArray());
		System.out.println("Array contains " + t.getArray().size() + " values");
		System.out.println("Merge sorting array");
		t.Merge(t.getArray());
		System.out.println("Printing new array");
		System.out.println(t.getArray());
		System.out.println("Array contains " + t.getArray().size() + " values");
	}
}