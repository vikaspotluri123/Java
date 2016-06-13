import java.util.*;
import static java.lang.System.*;

public class Robot {
	private int [] hall;
	private int position;
	private boolean facingRight;
	public Robot()
	{
		hall = new int[4];
		position = 1; 
		facingRight = true;
		hall[0]=1;
		hall[1]=1;
		hall[2]=2;
		hall[3]=2;
	}
	public String toString()
	{
		String s= "";
		for (int element : hall)
				s +=element + "          ";
		return s;
	}
	
	private boolean forwardMoveBlocked()
	{
		if ((position == hall.length-1) && (facingRight))
			return true;
		if ((position == 0) && (!facingRight))
			return true;
		return false;
	}
	
	private void move()
	{
		if (hall[position] > 0 )
			hall[position]--;
		if (hall[position] == 0 )
		{
			if (forwardMoveBlocked())
				facingRight = !facingRight;
			else
				if(facingRight)
					position++;
				else 
					position--;
		}
				
	}
	
	public int clearHall()
	{
		int count = 0 ; 
		while(!hallIsClear())
		{
			move();
			count++;
		}
		
		return count;
	}
	
	private boolean hallIsClear()
	{
		for (int i = 0; i< hall.length; i++)
			if(hall[i] > 0)
				return false;
		return true;
	}
	public static void main(String[] args)
	{

	}

}
