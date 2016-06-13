import java.util.ArrayList;

import info.gridworld.actor.*;
import info.gridworld.grid.Location;

public class RelocatingCritter extends Critter
{
	public ArrayList<Actor> getActors()
	{
		ArrayList<Actor> actors = new ArrayList<Actor>();
		ArrayList<Location> locs = getGrid().getOccupiedLocations();
		for(Location loc : locs)
		{
			if(!loc.equals(getLocation()))
			{actors.add(getGrid().get(loc));}
		}
		return actors;
	}
	public void ProcessActors(ArrayList<Actor> actors)
	{
		for(Actor a : actors)
		{
			int direction = a.getLocation().getDirectionToward(getLocation());
			Location newLoc = a.getLocation().getAdjacentLocation(direction);
			if(getGrid().get(newLoc) == null)
			{
				a.moveTo(newLoc);
		}
		}
	}
}