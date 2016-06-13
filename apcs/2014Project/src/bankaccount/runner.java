package bankaccount;
import alarmclock.*;
import bankaccountpeople.*;
import todo.*;
import _files.*;
public class runner extends Thread
{
	public runner()
	{
		super();
		alarmclock.GUI thred = new alarmclock.GUI();
		Thread main = new Thread(thred,"MAIN");
		main.start();
	}
}
