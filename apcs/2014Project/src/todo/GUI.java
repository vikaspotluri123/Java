package todo;
import alarmclock.*;
import bankaccountpeople.*;
import bankaccountpeople.*;
import _files.*;

import javax.swing.*;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
public class GUI extends JFrame 
{
	private ArrayList<JPanel> panels = new ArrayList<JPanel>();
	private ArrayList<Task>   taskList = new ArrayList<Task>();
	public GUI()
	{
		super("ToDo List | JAVA");
		setLayout(new GridLayout(5,0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(250,500);
		setAlwaysOnTop(true);
		init();
		setLayout(new GridLayout(panels.size()+2,0));
		setVisible(true);
	}
	private void init()
	{
		FileOpen getFile = new FileOpen();
		taskList = getFile.getTasks();
		for(int i = 0 ; i < taskList.size();i++)
		{
			panels.add(makePanel(taskList.get(i)));
		}
		for(int i = 0 ; i < panels.size();i++)
		{
			add(panels.get(i));
		}
	}
	private JPanel makePanel(Task task)
	{
		JPanel panel = new JPanel(new FlowLayout());
		panel.setAlignmentX(TOP_ALIGNMENT);
		JCheckBox enabled = new JCheckBox();
		enabled.setSelected(task.isFinished());
		JLabel name = new JLabel("<html><body><bold><strong>"+task.getName()+"</strong></bold></body></html>");
		name.setFont(new Font(name.getFont().getName(),Font.BOLD,name.getFont().getSize()));
		name.setName("NAME");
		JLabel description = new JLabel(task.getDescription());
		description.setName("DESCRIPTION");
		description.setFont(new Font(name.getFont().getName(),Font.PLAIN,name.getFont().getSize()));
		JButton edit = new JButton("Edit");
		edit.setName("EDIT");
		enabled.setName("ENABLED");
		panel.add(enabled);
		panel.add(name);
		panel.add(description);
		final JPanel temp = panel;
		edit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) 
			{
				int loc = 0;
				for(int i = 0 ; i < temp.countComponents();i++)
				{
					if(temp.getComponent(i).getName().equals("NAME"))
						loc = i;
				}
				JLabel temp2 = (JLabel)(temp.getComponent(loc));
				editPanelSetup(temp2.getText());
			}
			
		});
		panel.add(edit);
		return panel;
	}
	private void editPanelSetup(String cName)
	{
		int task = 0;
		for(int i = 0 ; i < taskList.size();i++)
		{
			if(taskList.get(i).getName().equals(cName))
				task = i;
		}
		EditTask edit = new EditTask(taskList.get(task));
		dispose();
	}
}
