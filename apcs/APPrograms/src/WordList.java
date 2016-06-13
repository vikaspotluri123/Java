import java.util.*;
import static java.lang.System.*;

public class WordList 
{
	private ArrayList <String> myList;
	
	public int numWordsOfLength(int len)
	{
		int count =0 ;
		for(int i=0; i<myList.size();i++)
			if(myList.get(i).length()==len)
				count ++;
		return count;
	}
	
	public void removeWordsOfLength(int len)
	{
		for(int i=0; i<myList.size();i++)
			if(myList.get(i).length()==len)
				{
					myList.remove(i); 
					i--;
				}
	}
	public WordList(ArrayList <String>words)
	{
		myList=words;
	}
	
	public String toString()
	{
		return myList.toString();
	}

	public static void main(String[] args) 
	{
		
	}

}
