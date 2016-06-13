package GUI;
import javax.swing.*;
public class Base extends JFrame
{
	private static final long serialVersionUID = -8662282145790721710L;
	public boolean ready = false;
	public Base() 
	{
		super();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public Base(String a)
	{
		super(a);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void toggleVisiblity()
	{
		if(this.isVisible())
			setVisible(false);
		else
			setVisible(true);
	}

}
