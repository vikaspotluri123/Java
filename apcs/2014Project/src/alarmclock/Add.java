package alarmclock;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import java.util.Date;
public class Add extends JFrame
{
	private static final long serialVersionUID = -15611692843123489L;
	private JLabel            nameLabel;
	private JLabel            soundLabel;
	private JLabel            enabledLabel;
	private JLabel            snoozeLabel;
	private JLabel            displayLabel;
	private JCheckBox         enabled;
	
	private JTextField        name;
	private JTextField        snoozeTime;
	private JTextField        year;
	private JTextField        month;
	private JTextField        hour;
	private JTextField        minute;
	private JTextField        day;
	private JTextField        display;
	private JComboBox         sounds;
	
	private JButton           Return;
	private JButton           save;
	private JButton           soundEditor;
	
	private JPanel            namePanel;
	private JPanel            displayPanel;
	private JPanel            soundPanel;
	private JPanel            enabledPanel;
	private JPanel            snoozePanel;
	private JPanel            date;
	private JPanel            buttons;
	private ArrayList<Alarm>  alarms;
	private ArrayList<String> soundList;
	public Add(ArrayList<Alarm> list)	
	{	super("Add alarm");
		setLayout(new GridLayout(7,0));	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,315);
		alarms = list;
		init();
		setVisible(true);
		//debug();
	}
	public void init()
	{
		nameLabel     = new JLabel("Name");
		displayLabel  = new JLabel("Text to display");
		soundLabel    = new JLabel("Sound file");
		enabledLabel  = new JLabel("Enabled");
		snoozeLabel   = new JLabel("Snooze time");
		Return        = new JButton("Return"); //we can't set a variable to be return so it's capitalized
		save          = new JButton("Save");
		soundEditor   = new JButton("Edit sounds");
		enabled       = new JCheckBox();
		
		name          = new JTextField(15);
		display       = new JTextField(15);
		snoozeTime    = new JTextField(2);
		year          = new JTextField(4);
		month         = new JTextField(2);
		hour          = new JTextField(2);
		minute        = new JTextField(2);
		day           = new JTextField(2);
		sounds        = new JComboBox(getSounds());
		
		namePanel     = new JPanel(new FlowLayout());
		displayPanel  = new JPanel(new FlowLayout());
		soundPanel    = new JPanel(new FlowLayout());
		enabledPanel  = new JPanel(new FlowLayout());
		snoozePanel   = new JPanel(new FlowLayout());
		date          = new JPanel(new FlowLayout());
		buttons       = new JPanel(new FlowLayout());
		Date current  = new Date();
		swingSetup();
		
		nameLabel.setName("NAMELABEL");
		displayLabel.setName("DISPLAYLABEL");
		soundLabel.setName("SOUNDLABEL");
		enabledLabel.setName("ENABLEDLABEL");
		snoozeLabel.setName("SNOOZELABEL");
		Return.setName("RETURN");
		save.setName("SAVE");
		soundEditor.setName("SOUNDEDITOR");
		enabled.setName("ENABLED");
		name.setName("NAME");
		snoozeTime.setName("SNOOZETIME");
		year.setName("YEAR");
		month.setName("MONTH");
		hour.setName("HOUR");
		minute.setName("MINUTE");
		day.setName("DAY");
		sounds.setName("SOUNDS");
		namePanel.setName("NAMEPANEL");
		displayPanel.setName("DISPLAYPANEL");
		soundPanel.setName("SOUNDPANEL");
		enabledPanel.setName("ENABLEDPANEL");
		snoozePanel.setName("SNOOZEPANEL");
		date.setName("DATE");
		buttons.setName("BUTTONS");
				
		namePanel.add(nameLabel);
		namePanel.add(name);
		displayPanel.add(displayLabel);
		displayPanel.add(display);
		soundPanel.add(soundLabel);
		soundPanel.add(sounds);
		soundEditor.setEnabled(false);
		soundPanel.add(soundEditor);
		enabledPanel.add(enabled);
		enabledPanel.add(enabledLabel);
		snoozePanel.add(snoozeLabel);
		snoozeTime.setText("5");
		snoozePanel.add(snoozeTime);
		month.setText(String.valueOf(current.getMonth()));
		day.setText(String.valueOf(current.getDay()));
		year.setText(String.valueOf(current.getYear()));
		hour.setText(String.valueOf(current.getHours()));
		minute.setText(String.valueOf(current.getMinutes()));
		date.add(month);
		date.add(day);
		date.add(year);
		date.add(hour);
		date.add(minute);
		buttons.add(save);
		buttons.add(Return);
		
		add(namePanel);
		add(displayPanel);
		add(soundPanel);
		add(enabledPanel);
		add(snoozePanel);
		add(date);
		add(buttons);
	}
	private String[] getSounds()
	{
		// TODO soundlist code, same as alarm just for sounds.
		soundList = new ArrayList<String>();
		soundList.add("Attack");
		soundList.add("Buzz");
		soundList.add("Doppel");
		soundList.add("Extreme");
		soundList.add("SiFiDanger");
		String[] soundArray = new String[soundList.size()];
		for(int i=0 ; i <soundList.size();i++)
		{
			soundArray[i] = soundList.get(i);
		}
		return soundArray;
	}
	private void swingSetup()
	{
		Return.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				Alarms a = new Alarms(alarms);
				dispose();
			}
		});
		save.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				// todo: SAVE CODE TODO
				getAndDestroy();
			}
		});
	}
	private void getAndDestroy()
	{
		System.out.println(new Date().toGMTString());
		boolean worked = true;
		Date date = new Date();
		final String finalName = name.getText();
		int    finalSnooze= 5;
		int    finalMonth = date.getMonth();
		int    finalDay   = date.getDay();
		int    finalYear  = date.getYear();
		int    finalHour  = date.getHours();
		int    finalMinute= date.getMinutes();
		final  Date   finalTime;
		final  String  finalSound = sounds.getSelectedItem().toString();
		final boolean finalEnabled = enabled.isSelected();
		final String  finalPrint = display.getText();
		try{finalSnooze = Integer.parseInt(snoozeTime.getText());}catch(Exception e){worked = false;}
		try{finalMonth  = Integer.parseInt(month.getText());}catch(Exception e){worked = false;}
		try{finalDay    = Integer.parseInt(day.getText());}catch(Exception e){worked = false;}
		try{finalYear   = Integer.parseInt(year.getText());}catch(Exception e){worked = false;}
		try{finalHour   = Integer.parseInt(hour.getText())-5;}catch(Exception e){worked = false;}
		try{finalMinute = Integer.parseInt(minute.getText());}catch(Exception e){worked = false;}
		if(!worked)
		{
			JOptionPane.showMessageDialog(null,"Please follow the number format. Only the name is allowed to have non-numerical characters.");
			Add add = new Add(alarms);
			dispose();
		}
		finalTime = new Date(finalYear,finalMonth,finalDay,finalHour,finalMinute);
		Alarm add = new Alarm(finalTime,finalSound,finalSnooze,finalPrint,finalEnabled);
		alarms.add(add);
		FileSaver save = new FileSaver();
		save.saveFile(alarms);
		Alarms alarm = new Alarms(alarms);
		dispose();
	}
	private void debug()
	{
		JButton size  = new JButton("GETSIZE");
		size.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				System.out.println(getSize());
			}
		});
		add(size);
		
	}
}