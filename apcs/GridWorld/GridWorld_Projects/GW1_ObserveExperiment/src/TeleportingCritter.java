import java.util.ArrayList;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
public class TeleportingCritter extends Critter
{
	public boolean searchArray(ArrayList<Location> array, Location loc)
	{
		boolean value = false;
		for(int i = 0; i<array.size();i++)
		{
			if(array.get(i) == loc)
				value = true;
		}
		return value;
	}
	public ArrayList<Location> getMoveLocations()
	{
		ArrayList<Location> validLocations= new ArrayList();
		ArrayList<Location> occupied = getGrid().getOccupiedLocations();
		for(int i =0; i<getGrid().getNumCols();i++)
			for(int k = 0 ; i<getGrid().getNumRows(); i++)
			{
				if(!searchArray(occupied, new Location(i,k)))
				{
					validLocations.add(new Location(i,k));
				}
			}
		return validLocations;
	}
	
	public Location selectMoveLocation(ArrayList<Location> locs)
	{
		int n = locs.size();
		if(n == 0)
			removeSelfFromGrid();
			int r = (int)(Math.random()*n);
			return locs.get(r);
	}
}