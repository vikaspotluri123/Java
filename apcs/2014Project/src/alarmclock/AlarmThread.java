package alarmclock;
import base.*;
import java.util.ArrayList;
import java.util.Date;
public class AlarmThread extends Thread
{
	Alarm alarm;
	Thread threader; 
	public AlarmThread(Date whenToRun)
	{
		alarm = new Alarm(whenToRun);
		threader =new Thread(alarm,"Thread");
	}
	public void run()
	{
		threader.start();
	}
}
