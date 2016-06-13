package alarmclock;
import javax.swing.*;

import bankaccount.runner;

import java.awt.FlowLayout;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
public class Alarms extends JFrame 
{
	private JPanel layerOne = new JPanel();
	private ArrayList<Alarm> alarmList;
	private JPanel layerTwoOne = new JPanel();
	private JPanel layerTwoTwo = new JPanel();
	private GridLayout layout = new GridLayout(100,1);
	private ArrayList<JPanel> alarmPanel = new ArrayList<JPanel>();
	private ArrayList<JComponent> components = new ArrayList<JComponent>();
	public Alarms(ArrayList<Alarm> alarms)
	{
		super("Your alarms");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		alarmList = alarms;
		setSize(215,500);
		init();
		add(layerOne);
		setVisible(true);
	}
	private void init()
	{
		JLabel label = new JLabel("<html>ON   Name   Snooze             SoundFile<br/></html>");
		layerOne.add(label);
		JButton save = new JButton("SAVE");
		save.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) 
			{
				//FileSaver save = new FileSaver(layerOne,alarmList);
				int alarmIndex = 0;
				String errorText = "Something didn't work out. Please make sure that the values correctly corospond to the type.";
				for(int i = 0; i<components.size();i++)
				{
					switch(components.get(i).getName())
					{
						case "Enabled":
						{
							JCheckBox a = (JCheckBox)(components.get(i));
							Boolean value = a.isSelected(); 
							alarmList.get(alarmIndex).setEnabled(value);
							break;
						}
						case "BREAK":
						{
							alarmIndex++;
							break;
						}
						case "AlarmName":
						{
							JTextField a = (JTextField)(components.get(i));
							String value = a.getText();
							alarmList.get(alarmIndex).setName(value);
							break;
						}
						case "Location":
						{
							JTextField a = (JTextField)(components.get(i));
							String value = a.getText();
							try 
							{
								File tryer = new File(value);
							}
							catch(Exception e)
							{
								JOptionPane.showMessageDialog(null,errorText);
							}
							alarmList.get(alarmIndex).setAudio(value);
							break;
						}
						case "Snooze":
						{
							JTextField a = (JTextField)(components.get(i));
							String value = a.getText();
							try
							{
								alarmList.get(alarmIndex).setSnooze(Integer.parseInt(value));
							}
							catch(Exception e)
							{
								JOptionPane.showMessageDialog(null,errorText);
							}
							break;
						}
					}
				}
					FileSaver saver = new FileSaver();
					if(saver.saveFile(alarmList))
					{
						JOptionPane.showMessageDialog(null, "Your alarms have been saved.");
					}
				
			}});
		for(int i = 0 ; i < alarmList.size(); i++)
		{
			alarmPanel.add(setupLayer(alarmList.get(i).getEnabled(),alarmList.get(i).getName(),alarmList.get(i).getSnoozeTime(),alarmList.get(i).getAudioFile(),components));
		}
		for(int i = 0 ; i < alarmPanel.size();i++)
		{
			layerOne.add(alarmPanel.get(i));
		}
		JButton exit = new JButton("RETURN");
		JButton add = new JButton("ADD ALARM");
		exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				setVisible(false);
				runner rune = new runner();
				dispose();
			}
			
		});
		add.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				setVisible(false);
				Add adder = new Add(alarmList);
				dispose();
			}
		});
		layerOne.add(add);
		layerOne.add(save);
		layerOne.add(exit);
	}
	private JPanel setupLayer(boolean status, String name, int snoozeTime, String sound,ArrayList<JComponent> toAdd)
	{
		JPanel returner = new JPanel();
		FlowLayout layout = new FlowLayout();
		returner.setLayout(layout);
		JCheckBox enabled = new JCheckBox();
		enabled.setSelected(status);
		JTextField alarmName = new JTextField(name);
		JTextField snooze = new JTextField(2);
		Integer snoozeTimeInteger = snoozeTime;
		snooze.setText(snoozeTimeInteger.toString());
		JTextField location = new JTextField(8);
		location.setText(sound);
		JTextField coa = new JTextField();
		enabled.setName("Enabled");
		toAdd.add(enabled);
		alarmName.setName("AlarmName");
		toAdd.add(alarmName);
		snooze.setName("Snooze");
		toAdd.add(snooze);
		location.setName("Location");
		toAdd.add(location);
		coa.setName("BREAK");
		toAdd.add(coa);
		returner.add(enabled);
		//returner.add(new JLabel("<html>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</html>"));
		returner.add(alarmName);
	//	returner.add(new JLabel("<html>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</html>"));
		returner.add(snooze);
//		returner.add(new JLabel("<html>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</html>"));
		returner.add(location);
		return returner;
	}
}