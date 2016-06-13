import javax.swing.*;

import com.alee.laf.WebLookAndFeel;


/** Driver code to instantiate the GUI for this application.
 */
public class YellowPad
{

	/** The starting point for the Java Virtual Machine when
	 *  this program is executed.
	 *
	 * @param args		Unused array of input parameters
	 */
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable() {
			public void run()
			{
				WebLookAndFeel.install();
				new EditorFrame();
			}
		});
	}

}
