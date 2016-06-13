package alarmclock;
import java.io.*;
public class temp 
{
	public temp()
	{
		try
		{
			String stuff = "";
			char ten = 10;
			for(int i = 0 ; i < 150;i++)
			{
				stuff+="Test"+i+":"+"Test"+i+".mp3:"+ten;
			}
			File a = new File("bin\\_files\\sounds.vv");
			FileOutputStream toSave = new FileOutputStream(a);
			Writer writer = new BufferedWriter(new OutputStreamWriter(toSave));
			writer.write(stuff);
			writer.close();
			toSave.close();
			System.out.println("SUCCESS");
		}
		catch(Exception e){e.printStackTrace();}
	}
}
