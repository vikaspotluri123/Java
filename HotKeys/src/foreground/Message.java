package foreground;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Message 
{
	
	public static void showMessage(JFrame frame, String message)
	{
		JOptionPane.showMessageDialog(frame,message);
		background.Log.addError(message);
	}
}
