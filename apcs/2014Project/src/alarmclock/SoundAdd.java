package alarmclock;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class SoundAdd extends JFrame 
{
	JLabel name = new JLabel("Name");
	JButton add = new JButton("add");
	JButton returner = new JButton("cancel");
	JFileChooser soundLocation = new JFileChooser("Choose sound file");
	JTextField soundName = new JTextField(20);
	JPanel stuff = new JPanel();
	public SoundAdd()
	{
		super("Add sound");
		setSize(515,445);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		init();
		setVisible(true);
	}
	private void init()
	{
		add.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				addSound();
			}
		});
		returner.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				setVisible(false);
				SoundEditor a = new SoundEditor();
				dispose();
			}
		});
		soundName.setRequestFocusEnabled(true);
		soundLocation.setRequestFocusEnabled(false);
		stuff.add(name);
		stuff.add(soundName);
		stuff.add(soundLocation);
		stuff.add(add);
		stuff.add(returner);
		add(stuff);		
	}
	private void debug()
	{
			
	}
	private void addSound()
	{
		JTextField name = (JTextField)(stuff.getComponent(1));
		JFileChooser a = (JFileChooser)(stuff.getComponent(2));
		String d = name.getText();
		String b = a.getSelectedFile().toString();
		Sounds c = new Sounds();
		c.addSound(d,b);
		JOptionPane.showMessageDialog(null,"Success");
		setVisible(false);
		SoundEditor editor = new SoundEditor();
		dispose();
	}
}
