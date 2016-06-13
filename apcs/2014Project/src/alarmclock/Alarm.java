package alarmclock;
import base.*;

import java.util.Date;
public class Alarm extends Wakeup implements Runnable
{
	private Date time;
	private Date current;
	private String audio;
	private int snooze;
	private String display;
	private boolean enabled;
	public Alarm(Date toSet)
	{
		time = toSet;
		current = new Date();
		audio = "defualt.mp3";
		snooze = 5;
		display = "Time to wake up!";
	}
	public Alarm(Date toSet, String audioFile, int snoozeTime, String toPrint,boolean enabled)
	{
		time = toSet;
		current = new Date();
		audio = audioFile;
		snooze = snoozeTime;
		display = toPrint;
		this.enabled = enabled;
	}
	public String getDisplay()
	{
		return display;
	}
	public Date getAlarmTime()
	{
		return time;
	}
	public boolean getEnabled()
	{
		return enabled;
	}
	public String getName()
	{
		return display;
	}
	public String getAudioFile()
	{
		return audio;
	}
	public int getSnoozeTime()
	{
		return snooze;
	}
	public void setEnabled(boolean isEnabled)
	{
		enabled = isEnabled;
	}
	public void setName(String n)
	{
		display = n;
	}
	public void setSnooze(int n)
	{
		snooze = n;
	}
	public void setAudio(String a)
	{
		audio = a;
	}
	public void run()
	{
		System.out.println(time + "  " +  enabled);
		if(enabled)
		{
			while (time.compareTo(current) > 0)
			{
				current = new Date();
			}
			WakeupGUI waker = new WakeupGUI(snooze,display,audio);
		}
	}
}
