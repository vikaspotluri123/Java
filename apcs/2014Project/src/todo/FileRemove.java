package todo;
import java.io.*;
import java.util.ArrayList;
public class FileRemove 
{
	private ArrayList<Task> tasks = new ArrayList<Task>();
	public FileRemove(Task toDispose)
	{
		FileOpen a = new FileOpen();
		tasks = a.getTasks();
		removeTask(toDispose);
	}
	private void removeTask(Task dispose)
	{
		for(int i = 0; i<tasks.size();i++)
		{
			if(tasks.get(i).getName().equals(dispose.getName()))
				tasks.remove(i);
		}
		FileSave saver = new FileSave(tasks);
		saver.save();
	}
}
