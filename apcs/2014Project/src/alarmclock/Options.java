package alarmclock;
import java.util.ArrayList;
import javax.swing.*;
public class Options extends JFrame 
{
	private ArrayList<Alarm> alarmList;
	public Options(ArrayList<Alarm> alarms)
	{
		super("Options");
		alarmList = alarms;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,500);
		init();
		setVisible(true);
	}
	private void init()
	{
		
	}
}
