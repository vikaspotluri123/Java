import info.gridworld.actor.Actor;

import java.util.ArrayList;
import java.awt.Color;

public class DyingCritter extends ChamelonCritter
{
	public void processActors(ArrayList<Actor> actors)
	{
		int n = actors.size();
		if(n == 0)
		{
			int green = getColor().getGreen();
			int red =   getColor().getRed();
			int blue =  getColor().getBlue();
			if(!(red==0))
			{
				red--;
			}
			if(!(blue==0))
			{
				blue--;
			}
			if(!(green==0))
			{
				green--;
			}
			setColor(new Color(red, green,blue));
		}
		else
		{
		int r = (int)(Math.random()*n);
		Actor other = actors.get(r);
		setColor(other.getColor());
		}
	}
}
