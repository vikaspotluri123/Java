import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;

public class MoveRightActor extends Actor
{

	public void act()
	{
		Location loc = getLocation();
		int col1 = loc.getCol() + 1;
		     if(col1 == getGrid().getNumCols())
		        moveTo(new Location(loc.getRow(),0));
		     else moveTo(new Location(loc.getRow(),col1));
	}
}