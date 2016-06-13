
public class InsertionSort
{
	
	public static void main(String [] args)
	{
		
		int [] array = {6,7,8,4,2,3,4,6,7,8};
		
		System.out.println("unsorted.....");
		output(array);
		
		insertionSort(array);
		
		System.out.println("sorted.....");
		output(array);
		
		
	}
	public static void output(int [] array)
	{
		for (int element : array)
			System.out.print(element +"  ");
		
		System.out.println();
	}
	public static void insertionSort(int [] array)
	{
		

		 for(int i =1; i < array.length; i++)
		 {
		 
			 int key = array[i];
			int j = i-1;
			 while ((j>=0) &&(array[j]>key))
			 {
			 
				 array[j+1] = array[j];
				 j--;

			 }
			 array[j+1]=key;

		 }


		
		
	}
}
