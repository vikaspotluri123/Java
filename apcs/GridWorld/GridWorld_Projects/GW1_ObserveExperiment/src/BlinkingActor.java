import info.gridworld.actor.Actor;
import java.awt.Color;


public class BlinkingActor extends Actor
{
	public void act()
	{
		setColor(new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255)));
	}
}