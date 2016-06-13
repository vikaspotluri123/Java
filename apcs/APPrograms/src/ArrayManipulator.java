import java.util.Scanner;

public class ArrayManipulator {

	public static void main(String[] args) {
		
		Object [] myData =  { "W", "E", "S", "T", "W","O","O","D"};
		System.out.println("Array Testing");
//		traverseForLoop(myData);
//		traverseForBackwords(myData);
//		traverseForEach(myData);
//		swap(myData, 1, 2);
//		reverse(myData);
//		shiftLeft(myData);
//		shiftRight(myData);
//		rotateRight(myData);
//		rotateLeft(myData);
		traverseForLoop(myData);
	}
	
	public static void traverseForLoop(Object [] data)
		{
			for (int i = 0; i < data.length ; i++)
				System.out.print(data[i] + " ");
				System.out.println();
		}
	
	public static void traverseForBackwords(Object [] data)
		{
			for (int i = data.length-1 ; i >= 0 ; i--)
				System.out.print(data[i] + " ");
				System.out.println();
		}
	
	public static void traverseForEach(Object [] data) 
		{
			for(Object reference : data)
				System.out.print(reference + " ");
				System.out.println();
		}
	
	public static void swap(Object [] list, int index1, int index2)
		{
			Object temp = list[index1];
			list[index1] = list[index2];
			list[index2] = temp;			
		}
	
	public static void reverse(Object [] data)
		{
			for (int i = 0 ; i <data.length/2 ; i++)
				swap(data, i , data.length-1-i);
			
		}
	
	public static void shiftLeft (Object [] data)
    
    {
	     for (int i =1; i < data.length; i++)
             data[i-1] = data[i];         
    }
    
    public static void shiftRight (Object [] data)
    {
             for (int i = data.length-2; i>=0 ; i--)
                             data [i+1] = data[i];         
            
    }
    
    public static void rotateLeft (Object [] data)
    {
            Object temp = data[0];
            shiftLeft(data);
            data[data.length-1] = temp; 
            traverseForLoop(data);
    
    }
    
    public static void rotateRight (Object [] data)
    {
            
            Object temp = data[data.length-1];
            shiftRight(data);
            data[0] = temp; 
            traverseForLoop(data);
    }
}
