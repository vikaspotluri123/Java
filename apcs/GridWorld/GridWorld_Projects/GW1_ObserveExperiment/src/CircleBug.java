import java.awt.Color;

import info.gridworld.actor.Bug;
public class CircleBug extends Bug 
{
	private int steps;
	private int sideLength;
	
	public CircleBug(int Length)
	{
		steps = 0;
		sideLength = Length;
		setColor(Color.ORANGE);
	}
	public void act() 
	{ 
		if (steps < sideLength && canMove()) 
		{ 
			move(); 
			steps++; 
		} 
		else 
		{ 
			turn(); 
			steps = 0; 
		}
	 }
}
