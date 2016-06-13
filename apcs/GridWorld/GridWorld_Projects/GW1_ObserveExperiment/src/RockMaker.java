import info.gridworld.actor.Bug;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;

public class RockMaker extends Bug
{

	public void act()
	{
		super.act();
		Location zero = new Location(0,0);
		if(getLocation().equals(zero))
		{
			Rock rock = new Rock();
			rock.putSelfInGrid(getGrid(),new Location((int)(Math.random()*getGrid().getNumRows()-1),(int)(Math.random()*getGrid().getNumCols()-1)));
		}
		
	}
}