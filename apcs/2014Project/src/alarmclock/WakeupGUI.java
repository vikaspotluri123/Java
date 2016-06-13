package alarmclock;
import java.awt.Color;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class WakeupGUI extends JFrame implements Runnable
{
	private int snooze;
	private String display;
	private String audio;
	JButton snoozeButton = new JButton("SNOOZE!");
	JButton off = new JButton("I'M AWAKE!");
	JPanel buttons = new JPanel();
	private boolean bole = true;
	public WakeupGUI(int s, String d, String a)
	{
		super(d);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().width, GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height);
		snooze = s;
		display = d;
		audio = a;
		buttons.add(off);
		buttons.add(snoozeButton);
		add(buttons);
		setButtons();
		setVisible(true);
		run();
	}
	public void setButtons()
	{
		off.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) 
			{
				setVisible(false);
				base.GUI gui = new base.GUI();
				dispose();
			}});
		snoozeButton.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){}});
	}
	
	public void run()
	{
		while(bole)
		{
			buttons.setBackground(new Color(random(),random(),random()));
			repaint();
		}
	}
	private int random()
	{
		return (int)(Math.random()*255);
	}
	public static void main(String args[])
	{
		WakeupGUI gui = new WakeupGUI(5,"lol","2");
	}
}
