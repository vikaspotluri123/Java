import info.gridworld.actor.Bug;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import info.gridworld.actor.Actor;

public class JumperBug extends Bug {
	public void move()
	{
	    Grid<Actor> gr = getGrid();
	    if (gr == null)
	        return;
	    Location loc = getLocation();
	    Location one = loc.getAdjacentLocation(getDirection());
	    Location two = loc.getAdjacentLocation(getDirection()).getAdjacentLocation(getDirection());
	    if (gr.isValid(one))
	    {
	        if(gr.isValid(two))
	        	moveTo(two);
	        else moveTo(one);
	    }
	    	 else
	 	        removeSelfFromGrid();
	}
	public boolean canMove()
	{
	    Grid<Actor> gr = getGrid();
	    if (gr == null)
	        return false;	
	    Location loc = getLocation();
	    Location two = loc.getAdjacentLocation(getDirection()).getAdjacentLocation(getDirection());
	    Location one = loc.getAdjacentLocation(getDirection());
	    if (gr.isValid(one))
	    {
	        if(gr.isValid(two))
	        {
	        	return true;
	        }
	    }
	    else return false;
	    Actor neighbor = gr.get(one);
	    return (neighbor == null);
	}
}