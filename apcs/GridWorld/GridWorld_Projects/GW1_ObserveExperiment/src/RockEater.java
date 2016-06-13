import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import java.util.ArrayList;

public class RockEater extends Critter
{
	public void processActors(ArrayList<Actor> actors)
	{
		for(Actor a: actors)
		{
			if(!(a instanceof Critter))
				a.removeSelfFromGrid();
		}
	}
}
