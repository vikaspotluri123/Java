package background;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

public class Log 
{

	public static void addError(String m)
	{
		PrintWriter e;
		try {
			e = new PrintWriter(new BufferedWriter(new FileWriter(".\\log\\error.log", true)));
			e.println(new GregorianCalendar().getTime().toString() + "\t" + m);
			e.close();
		} catch (IOException e1) 
		{
			JOptionPane.showMessageDialog(null,"Error writing log:"+ e1.getStackTrace());
		}
	}
}
