import info.gridworld.actor.Bug;


public class BoxBug extends Bug
{
	private int steps;
	private int sideLength;
	
	public BoxBug()
	{
		super();
		steps = 0;
		sideLength = 5;
	}
	
	public void act()
	{
		if(steps < sideLength && canMove())
		{
			move();
			steps ++;
		}
		else
		{
			turn();
			turn();
			steps = 0;
		}
	}
}