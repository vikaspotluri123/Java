import java.util.*;

import static java.lang.System.*;

public class HorseBarn 
{
	Horse[] barn; 
	
	public HorseBarn(Horse [] newHorse)
	{
		barn = newHorse;
	}
	
	public int findHorse(String name)
	{
		for(int i =0; i<barn.length;i++)
		{
			if(barn[i]!=null)
			{
				if(barn[i].equals(name))
					return i;
			}
			
		}
		return -1;
	}
	
	public void consildate()
	{
		Horse[] newSpaces = new Horse[this.barn.length]; 
		 int nextSpot = 0; 
		 for (Horse nextHorse : this.barn) 
		 { 
			 if (nextHorse != null) 
			 { 
				 newSpaces[nextSpot] = nextHorse; 
				 nextSpot++; 
			 } 
		 } 
		 this.barn = newSpaces;
	}
}
