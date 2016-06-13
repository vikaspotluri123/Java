package alarmclock;
import java.io.*;
import java.util.ArrayList;
import javax.swing.*;
public class FileSaver 
{
	public FileSaver()
	{
		
	}
	public boolean saveFile(ArrayList<Alarm> a)
	{
		String goInFile = "";
		for(int i = 0 ; i <a.size();i++)
		{
			char enter = 10;
			goInFile += a.get(i).getAlarmTime().getYear() + ":" + a.get(i).getAlarmTime().getMonth() + ":" + a.get(i).getAlarmTime().getDate() + ":" + a.get(i).getAlarmTime().getHours() + ":" + a.get(i).getAlarmTime().getMinutes() + ":" +	a.get(i).getDisplay() + ":"+ a.get(i).getSnoozeTime() +":"+a.get(i).getName()+":"+a.get(i).getEnabled()+":"+enter;
		}
		try
		{
			File alarms = new File("bin\\_files\\alarms.vv");
			if(alarms.delete())
			{
				FileWriter Vikas = new FileWriter(alarms.getAbsoluteFile());
				Vikas.write(goInFile);
				Vikas.close();
			}
			else
			{
				return false;
			}
		}
		catch(Exception e)
		{e.printStackTrace();}
		return false;
	}
}
