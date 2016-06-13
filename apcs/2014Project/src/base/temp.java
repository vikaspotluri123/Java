package base;
import javax.swing.*;
public class temp extends JFrame
{
	JCheckBox test = new JCheckBox();
	public temp()
	{
		super("Tester");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		test.setEnabled(true);
		add(test);
		setSize(500,500);
		setVisible(true);
		init();
	}
	public void init()
	{
		while(true)
		{
			System.out.println(test.isSelected());
		}
	}
	public static void main(String args[])
	{
		temp temp = new temp();
	}

}
