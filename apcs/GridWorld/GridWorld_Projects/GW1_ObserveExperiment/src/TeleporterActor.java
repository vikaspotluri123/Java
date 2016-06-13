import java.util.ArrayList;

import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;

public class TeleporterActor extends Actor
{
	public void act()
	{
		boolean value=true;
		Location moveHere = new Location((int)(Math.random()*getGrid().getNumRows()-1),(int)(Math.random()*getGrid().getNumCols()-1));
		while(value)
		{
			
			ArrayList<Location> occupied = getGrid().getOccupiedLocations();
			for(int i=0;i<occupied.size();i++)
			{
				if(moveHere == occupied.get(i))
				{
					boolean finalfinal = true;
				}
				else value= false;
			}
		}		 
		moveTo(moveHere);
	}
}