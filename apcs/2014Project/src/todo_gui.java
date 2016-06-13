/*
 * Created by Vikas Potluri
 */
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
public class todo_gui extends JFrame 
{
	private ArrayList<JPanel> panels = new ArrayList<JPanel>();
	public todo_gui()
	{
		super("ToDo List | JAVA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setSize(250,500);
		setAlwaysOnTop(true);
		ArrayList<todo_Task> conver = getTasks();
		loadPanels(conver);
	}	
	public todo_gui(String windowTitle)
	{
		super(windowTitle);
	}
	private void loadPanels(ArrayList<todo_Task> tasks)
	{
		for(int i = 0 ; i <tasks.size();i++)
			{
				panels.add(i,new JPanel());
				panels.get(i).setSize(getWidth(), 10);
				//change this to tasks.get(i).getTaskGUI()
				panels.get(i).add(new JLabel(tasks.get(i).toString()));
			}
	}
	private ArrayList<todo_Task> getTasks()
	{
		ArrayList<todo_Task> tasks = new ArrayList<todo_Task>();
		try
		{
			File task = new File("src\\_Files\\task.vv");
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
					tasks.add(new todo_Task());
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
}
