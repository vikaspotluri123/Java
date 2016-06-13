/* import java.util.*;
import static java.lang.System.*;
public class sorting
{
	public static void traverseForLoop(int[] list)
	{
		for (int i = 0; i < list.length ; i++)
			System.out.print(list[i] + " ");
			System.out.println();
	}
	public int[] dumbBubble()
	{
		int [] list = new int[10]; 
		for (int pass =0; pass<list.length-1;pass++)
			for(int i = 0 ; i<list.length-1; i++)
				if (list[i] < list[i+1])
					{
						int temp = list[i+1];
						list[i] = list[i+1];
						list[i+1]=temp;
					}
		traverseForLoop(list);
	}


	public smartBubble()
	{
		int [] list = new int[10]; 
		boolean didSwap = true;
		while (didSwap == true);
		{
			didSwap = false;  // Start of a pass. IF swap happens, changes to true again. else, remains the same and you get out of the while loop.
			for (int i=0; i < list.length-1; i++)
				if (list[i] > list[i+1])
				{
					int temp = list[i+1];
					list[i] = list[i+1];
					list[i+1]=temp;
					didSwap=true;
		         }	
		}
		traverseForLoop(list);

	}

	public static void main(String[] args) 
	{


	}

}
*/