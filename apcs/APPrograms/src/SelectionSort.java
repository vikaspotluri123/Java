
public class SelectionSort
{
	
	public static void main(String [] args)
	{
		
		int [] array = {6,7,8,4,2,3,4,6,7,8};
		
		System.out.println("unsorted.....");
		output(array);
		
		selectionSort(array);
		
		System.out.println("sorted.....");
		output(array);
		
		
	}
	public static void output(int [] array)
	{
		for (int element : array)
			System.out.print(element +"  ");
		
		System.out.println();
	}
	public static void selectionSort(int [] array)
	{

		 for(int i = 0 ; i <array.length-1; i++)
		 
			 {
			
			 int smallNum = i;
				 // find number
				 for (int j=i;j<array.length;j++)
				 
					 if(array[j]<array[smallNum])
					 {
					 
						 smallNum=j;

					}

				int temp = array[i];
				array[i]=array[smallNum];
				array[smallNum]=temp;

			 }



	}
}
