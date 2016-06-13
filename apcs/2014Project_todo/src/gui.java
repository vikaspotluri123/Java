import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

import java.io.*;
import java.util.ArrayList;
import java.util.EmptyStackException;
public class gui extends JFrame 
{
	public gui()
	{
		super("ToDo List | JAVA");
		getTasks();
		setVisible(true);
		setSize(250,500);
		setAlwaysOnTop(true);
		ArrayList<Task> conver = getTasks();
	}
	
	public gui(String windowTitle)
	{
		super(windowTitle);
	}
	
	private ArrayList<Task> getTasks()
	{
		ArrayList<Task> tasks = new ArrayList<Task>();
		try
		{
			File task = new File("C:\\users\\vcpotluri\\Copy\\Comp Sci\\Project\\Workspace\\2014Project_todo\\src\\_Files\\task.vv");
			FileInputStream reader = new FileInputStream(task);
			int fileSize = (int)(task.length());
			int temp;
			char tempCastInt;
			String local = "";
			for(int i = 0 ; i <fileSize; i++)
			{
				temp = reader.read();
				tempCastInt = (char)(temp);
				//debug System.out.println("Character key :" + temp + "\n Character :" + tempCastInt);
				if(temp == 10)
				{
					tasks.add(new Task());
					local = "";
				}
				else
				{
					local += tempCastInt;
				}
			}
			reader.close();
		}
		catch(IOException e){e.printStackTrace();}

		return tasks;
	}
	
	public static void main(String args[])
	{
		gui tester = new gui();
	}
}
