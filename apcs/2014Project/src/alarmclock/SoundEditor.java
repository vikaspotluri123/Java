package alarmclock;
import javax.swing.*;

import java.awt.FlowLayout;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
public class SoundEditor extends JFrame 
{
	private GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	ArrayList<Sound> sounds;
	ArrayList<JPanel> soundPanels = new ArrayList<JPanel>();
	public SoundEditor()
	{
		super("Edit sounds");
		setLayout(new GridLayout(5,0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(ge.getMaximumWindowBounds().width,ge.getMaximumWindowBounds().height);
		Sounds soundClass = new Sounds();
		sounds = soundClass.getListOfSounds();
		init();
		setVisible(true);
		debug();
	}
	private void init()
	{
		for(int i = 0 ; i < sounds.size();i++)
		{
			soundPanels.add(createPanel(sounds.get(i).getName(),sounds.get(i).getFileLocation()));
		}
		for(int i = 0 ; i < soundPanels.size();i++)
		{
			add(soundPanels.get(i));
		}
			JPanel button = new JPanel();
			JButton add = new JButton("Add sound");
			add.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					setVisible(false);
					SoundAdd add = new SoundAdd();
					dispose();
				}
			});
			if(!(soundPanels.size()<=100))
			{
				add.setEnabled(false);
			}
			button.add(add);
			add(button);
		
	}
	private JPanel createPanel(String soundName, String location)
	{
		final String sound = soundName;
		JPanel panel = new JPanel(new FlowLayout());
		JLabel number = new JLabel();
		number.setVisible(false);
		number.setName(String.valueOf(soundPanels.size()+1));
		JLabel name = new JLabel(soundName);
		JLabel fileLocation = new JLabel(location);
		JButton delete = new JButton("Delete");
		name.setName("NAME");
		fileLocation.setName("LOCATION");
		delete.setName("DELETE");
		delete.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				deleteSound(sound);
				setVisible(false);
				SoundEditor neww = new SoundEditor();
				dispose();
			}
		});
		panel.add(name);
		panel.add(fileLocation);
		panel.add(delete);
		return panel;
	}
	public void deleteSound(String soundName)
	{
		Sounds sound = new Sounds();
		sound.removeSound(soundName);
	}
	private void debug()
	{
		for(int i = 0 ; i < sounds.size(); i++)
		{
			System.out.println(sounds.get(i));
		}
	}
}
