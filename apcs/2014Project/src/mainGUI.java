/*
 * Created by Vikas Potluri
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class mainGUI extends JFrame
{
	private static final long serialVersionUID = 1L;
	private JButton button1 = new JButton("Do banking");
	private JButton button2 = new JButton("Open task manager");
	private JButton button3 = new JButton("Work your alarm clock");
	private JPanel one = new JPanel();
	public mainGUI()
	{
		super("Multi task manager");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize((int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth()-500),(int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()-500));
		GridLayout layout = new GridLayout();
		one.setLayout(layout);
		button1.setBounds(1,2,3,2);
		button2.setBounds(2,5,65,2);
		one.add(button1);
		one.add(button2);
		one.add(button3);
		add(one);
		addTheActions();
		setVisible(true);
		setAlwaysOnTop(true);
	}
	private void addTheActions()
	{
		button1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				gui bank = new gui();
				bank.setAlwaysOnTop(true);
				dispose();
			}
		});	
		button2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				todo_gui tasker = new todo_gui();
				tasker.setAlwaysOnTop(true);
				dispose();
			}
		});	
		button3.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				setVisible(false);
				runner rune = new runner();
				dispose();
			}
		});	
	}
}
