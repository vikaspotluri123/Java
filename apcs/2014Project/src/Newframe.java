/*
 * Created by Vikas Potluri
 */
import javax.swing.*;
public class Newframe extends JFrame 
{
	JLabel welcome = new JLabel("Welcome to a New Frame");
	JPanel panel = new JPanel();	
	Newframe()	
	{
		super("Welcome");
		setSize(300,200);
		setLocation(500,280);
		panel.setLayout (null); 		
		welcome.setBounds(70,50,150,60);		
		panel.add(welcome);
		getContentPane().add(panel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	Newframe(String a)	
	{
		super("Welcome");
		setSize(300,200);
		setLocation(500,280);
		panel.setLayout (null); 
		welcome.setText(a);
		welcome.setBounds(70,50,150,60);		
		panel.add(welcome);
		getContentPane().add(panel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void setVisible(boolean input)
	{
		super.setVisible(input);
	}

}
