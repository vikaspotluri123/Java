package base;
import alarmclock.*;
import bankaccount.gui;
import bankaccount.runner;
import bankaccountpeople.*;
import todo.*;
import _files.*;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class GUI extends JFrame
{
	private static final long serialVersionUID = 1L;
	private JButton button1 = new JButton("Do banking");
	private JButton button2 = new JButton("Open task manager");
	private JButton button3 = new JButton("Work your alarm clock");
	private JPanel one = new JPanel();
	private GraphicsEnvironment dimensionss = GraphicsEnvironment.getLocalGraphicsEnvironment();
	public GUI()
	{
		super("Multi task manager");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(dimensionss.getMaximumWindowBounds().width,dimensionss.getMaximumWindowBounds().height);
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
				bankaccount.gui bank = new bankaccount.gui();
				bank.setAlwaysOnTop(true);
				dispose();
			}
		});	
		button2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				todo.GUI tasker = new todo.GUI();
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
