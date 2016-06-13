public class BubbleSort
{
	public static void main(String [] args)
	{		
		int [] list = {6,7,8,4,2,3,4,6,7,8};
		
		System.out.println("unsorted.....");
		output(list);
		
		bubbleSort(list);
		
		System.out.println("sorted.....");
		output(list);		
	}
	public static void output(int [] array)
	{
		for (int element : array)
			System.out.print(element +"  ");
		
		System.out.println();
	}
	public static void bubbleSort(int [] array)
	{
		

		 for (int pass = 0 ; pass<array.length-1;pass++)
		
			 for (int i = 0 ; i<array.length-1;i++)
			 
				 if(array[i] > array[i+1])
				{
			 
				 int temp = array[i];
					array[i]=array[i+1];
					 array[i+1]=temp;

				 }




		
		
	}
}
