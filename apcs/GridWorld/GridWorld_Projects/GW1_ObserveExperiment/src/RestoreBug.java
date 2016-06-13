import java.util.ArrayList;

import info.gridworld.actor.*;
import info.gridworld.grid.Location;

public class RestoreBug extends Bug
{
	private Location loc;
	private int direction;
	private String lastMove;
	public void act()
	{	
		loc = getLocation();
		direction = getDirection();
		if(canMove())
		{
			move();
			lastMove = "move";
		}
		else
		{
			turn();
			lastMove = "turn";
		}
	}
	public void Restore()
	{
		if(lastMove == "move")
		{
			Actor neighbor = getGrid().get(loc);
			if(! (neighbor instanceof Rock) || (neighbor instanceof Critter))
			moveTo(loc);
		}
		else
		{
			setDirection(direction);
		}
		
	}
}