//import java.util.Scanner;

public class MyList 
{
		private String [] list = null;
		
		public MyList()
		{
			list = new String[0];
		}
	
		public void add(String valueToAdd)
		{
			String [] temp = new String [list.length +1];
			for (int i = 0 ; i<list.length ; i++)
				temp[i] = list[i];
				temp[temp.length - 1] = valueToAdd ;
				list = temp ;
				
		}
		
		public String set(int index, String valueToChange)
		{
			String temp = list[index];
			list[index] = valueToChange;
			
			return temp;
			
			
		}
		
		public void add (String [] names)
		{
			for (int i = 0 ; i< names.length ; i++)
				add(names[i]);
		}
		
		public String toString()
		{
			String output = "This is my list ...  ";
			for (int i = 0 ; i < list.length ; i++)
				output = output + list [i] + "      ";					
			return output;
		}

		public void add (int index, String valueToAdd)
		{
			String [] temp = new String [list.length+1];
			int i = 0;
			for (i = 0 ; i <index ; i++)
				temp[i] = list[i];
				temp[index] = valueToAdd;
			for (i = index + 1; i < temp.length ; i++)
				temp[i] = list[i-1];
			list = temp ;
		}

		public String remove(int index)
		{
			String itemRemoved = list[index];
			
			String [] temp = new String [list.length - 1];
			int i = 0;
			for (i = 0 ; i < index ; i++)
				temp[i] = list [i];
			for (i = index ; i < temp.length ; i++)
				temp [i] = list [i+1];
			list = temp ;			
			return itemRemoved;
			
		}

} // end of class

