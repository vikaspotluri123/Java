package alarmclock;
import bankaccountpeople.*;
import bankaccount.*;
import todo.*;
import _files.*;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.*;
public class GUI extends JFrame implements Runnable
{
	private static final long serialVersionUID = 1039836195741574975L;
	private JPanel clock = new JPanel();
	private JPanel buttons = new JPanel();
	private JLabel hr0 = new JLabel();
	private JLabel min0 = new JLabel();
	private JLabel sec0 = new JLabel();
	private JLabel colon = new JLabel(" : ");
	private JLabel colon2 = new JLabel(" : ");
	private Date date = new Date();
	private int hours;
	private int minutes;
	private int seconds;
	private boolean stop = true;
	private JButton options = new JButton("Options");
	private JButton alarms = new JButton("Alarms");
	private GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	public GUI()
	{
		super("ALARM CLOCK | JAVA");
		init();
	}
	private void init()
	{
		setSize(ge.getMaximumWindowBounds().width,ge.getMaximumWindowBounds().height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Color color = new Color(10,12,40);
		Color fg = new Color(255,255,255);
		clock.setLayout(new GridBagLayout());
		clock.setBounds((ge.getMaximumWindowBounds().width)/4, (ge.getMaximumWindowBounds().height)/4, clock.getWidth(), clock.getHeight());
		clock.setBackground(color);
		hr0.setForeground(fg);
		min0.setForeground(fg);
		sec0.setForeground(fg);
		colon.setForeground(fg);
		colon2.setForeground(fg);
		font();
		setVisible(true);
		clock.add(hr0);
		clock.add(colon);
		clock.add(min0);
		clock.add(colon2);
		clock.add(sec0);
		options.setBounds(150,150,10,10);
		alarms.setBounds(105,105,10,10);
		buttons.setBounds(ge.getMaximumWindowBounds().width-150,ge.getMaximumWindowBounds().height-100,150,100);
		buttons.add(options);
		buttons.add(alarms);
		buttons.setBackground(color);
		Font clockF = new Font("DS-DIGITAL",Font.PLAIN,275);
		colon.setFont(clockF);
		colon2.setFont(clockF);
		hr0.setFont(clockF);
		min0.setFont(clockF);
		sec0.setFont(clockF);
		add(buttons);
		add(clock);
		setResizable(false);
		setAlwaysOnTop(true);
		setButtons();
		startAlarms(createAlarms());
	}
	private void startAlarms(ArrayList<Alarm> things)
	{
		ArrayList<AlarmThread> threads = new ArrayList<AlarmThread>();
		for(int i = 0 ; i < things.size(); i ++)
		{
			threads.add(new AlarmThread(things.get(i).getAlarmTime()));
		}
		for(int i = 0 ; i <threads.size();i++)
		{
			threads.get(i).run();
		}
	}
	private ArrayList<Alarm> createAlarms()
	{
		ArrayList<Alarm> alarms = new ArrayList<Alarm>(); //general arrays to get everything started
		ArrayList<String> breaks = new ArrayList<String>(); // when there's a line break
		ArrayList<String> vika = new ArrayList<String>();	 //the array with the bits and pieces
		String local = ""; 									//temporary String
		//debug String a = ""; 								//full string
		String temp; 										// the full String with :
		String temp2;										 // 1 character to compare
		int until = 0; 										// lets us know where to start the substring
		boolean needToSkip = false; 						//skips over colons
		try
		{
			File alarm = new File("bin\\_files\\alarms.vv");
			FileInputStream reader = new FileInputStream(alarm);
				int size = (int)alarm.length();																					 //gets the size of the file, in bytes which are casted to ints
				for(int i = 0 ; i < size ; i++) //reads the file
				{	
					int fileReadOutput = reader.read(); //the actual process of reading the file, gives a hex output
					char value = (char)(fileReadOutput); //converts the hex to a char
					if((fileReadOutput== 10)) //if the read is = int 10, enter in char
					{
						breaks.add(local); //add the string local, which is the the entire string before the add
						local = ""; //reinit local
					}
					else //otherwise...
					{
						//debug a += value;
						local += value; //add the character to the local var.
					}
				}
			}
			catch(Exception e){	}
			for(int i = 0 ; i<breaks.size();i++) //for loop for splitting it up even mroe
			{
				temp = breaks.get(i); //get the string with colons
				until = 0; //default value of until
				needToSkip = false; //default value of needToSkip
				if(!needToSkip) // if needToSkip is false..
				{
					for(int j = 0; j < temp.length();j++) //for the length of the string temp
					{
						temp2 = temp.substring(j,j+1); //get the character
						if(temp2.equals(":") && until != j && !(until > j-1)) //if it's a colon
						{
							vika.add(temp.substring(until,j)); //add a substring of everything up to the colon
							until = j+1; //we don't want the colon in the next array index
							needToSkip = true; //we don't want to run this after doing a colon
						}
					}
				}
				else //otherwise...
				{
					needToSkip = false; //skip over the next one
				}
			}
			/*
			 * Prereq: Each position has a fixed length, no matter what
			 * Post: in the arrayList people, every single person can be found, and we can get info about them.
			 * */
			for(int i = 0 ; i < vika.size(); i++)
			{
				
				alarms.add(new Alarm(
						new Date(Integer.parseInt(vika.get(i)),
								Integer.parseInt(vika.get(i+1)),
								Integer.parseInt(vika.get(i+2)),
								Integer.parseInt(vika.get(i+3)),
								Integer.parseInt(vika.get(i+4))),
								vika.get(i+5),
								Integer.parseInt(vika.get(i+6)),
								vika.get(i+7),
								Boolean.parseBoolean(vika.get(i+8))));
				i+=8;
			}
			return alarms;
		}     
	private void font(){try{ge.registerFont(Font.createFont(Font.TRUETYPE_FONT,new File("src\\_files\\DS-DIGIT.TTF")));}catch (FontFormatException | IOException e) {e.printStackTrace();}}
	@SuppressWarnings("deprecation")
	public void start()
	{
		while(stop)
		{
			date = new Date();
			hours = (Integer)(date.getHours());
			minutes = (Integer)(date.getMinutes());
			seconds = (Integer)(date.getSeconds());
			hr0.setText(String.format("%02d", hours));
			min0.setText(String.format("%02d", minutes));
			sec0.setText(String.format("%02d", seconds));
			repaint();
		}
	}
	private void setButtons()
	{
		alarms.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0)
			{
				Alarms alarm = new Alarms(createAlarms());
				dispose();
			}});
		options.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				Options options = new Options(createAlarms());
				dispose();
			}
		});
	}
	public void run()
	{
		start();
	}
}