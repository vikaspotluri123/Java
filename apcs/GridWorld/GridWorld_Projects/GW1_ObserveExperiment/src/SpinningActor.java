import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;

public class SpinningActor extends Actor
{
	public void act()
	{
		setDirection(getDirection()+Location.HALF_RIGHT);
	}
}