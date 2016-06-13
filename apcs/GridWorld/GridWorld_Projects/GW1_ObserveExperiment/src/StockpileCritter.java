import java.util.ArrayList;
import info.gridworld.actor.*;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
public class StockpileCritter extends Critter //+1
{
	private int totalEnergy =1 ; //+1
	public void processActors(ArrayList<Actor> actors) //+1
	{
		for(Actor a : actors)
		{
			a.removeSelfFromGrid();
			totalEnergy++; //+1
		}
	}
	public void makeMove(Location loc)  //+1
	{
		if(totalEnergy==0)
		{
			removeSelfFromGrid(); //+.5
		}
		else
		{
			totalEnergy--; //+.5
			super.makeMove(loc);
		}
	}
}