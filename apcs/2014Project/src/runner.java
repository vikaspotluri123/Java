/*
 * Created by Vikas Potluri
 */
public class runner extends Thread
{
	public runner()
	{
		super();
		ac_GI thred = new ac_GI();
		Thread main = new Thread(thred,"MAIN");
		main.start();
	}
}
