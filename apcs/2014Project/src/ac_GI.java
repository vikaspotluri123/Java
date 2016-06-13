/*
 * Created by Vikas Potluri
 */
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.swing.*;
public class ac_GI extends JFrame implements Runnable
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
	public ac_GI()
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
		colon.setFont(new Font("DS-DIGITAL",Font.PLAIN,275));
		colon2.setFont(new Font("DS-DIGITAL",Font.PLAIN,275));
		hr0.setFont(new Font("DS-DIGITAL",Font.PLAIN,275));
		min0.setFont(new Font("DS-DIGITAL",Font.PLAIN,275));
		sec0.setFont(new Font("DS-DIGITAL",Font.PLAIN,275));
		add(buttons);
		add(clock);
		setResizable(false);
		setAlwaysOnTop(true);
		setButtons();
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
		
	}
	public void run()
	{
		start();
	}
}