package driver;

import java.io.File;

import javax.swing.SwingUtilities;

public class Runner
{
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				File t = new File("userMessages");
				if(!t.exists())
					t.mkdir();
				new frontend.Main();
			}
		});
	}
}
