import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Controller implements ActionListener
{
	private int myIndex;
	
	public Controller()
	{
		myIndex = 0;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		String label = DemoApp.getModel().items[myIndex++];
		myIndex = myIndex % DemoApp.getModel().items.length;
		DemoApp.getView().getButton().setText(label);
	}
}
