package todo;
import java.io.*;
import java.util.ArrayList;
public class FileAdd
{
	private ArrayList<Task> taskList;
	private String description;
	private String name;
	private boolean completed;
	public FileAdd(String n, String d, boolean c)
	{
		FileOpen list = new FileOpen();
		taskList = list.getTasks();
		name = n;
		description = d;
		init();
	}
	private void init()
	{
		boolean can = true;
		for(int i = 0 ; i <taskList.size();i++)
		{
			if(taskList.get(i).getName().equals(name))
				can = false;
		}
		if(can)
		{
			taskList.add(new Task(name,description,completed));
			FileSave save = new FileSave(taskList);
			save.save();
		}
	}
}