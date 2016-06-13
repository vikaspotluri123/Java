import javax.swing.JButton;
import javax.swing.JFrame;


public class View
{
	private JFrame myFrame;
	private JButton myButton;
	
	public View()
	{
		myFrame = new JFrame("MVC Demo");
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		myButton = new JButton("Click to begin");
		myButton.addActionListener(DemoApp.getController());
		myFrame.add(myButton);
		myFrame.pack();
		myFrame.setVisible(true);
	}
	
	public JButton getButton() { return myButton; }
}
