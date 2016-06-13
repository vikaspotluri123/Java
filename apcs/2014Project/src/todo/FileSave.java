package todo;
import java.io.*;
import java.util.ArrayList;
public class FileSave
{
	private ArrayList<Task> taskList;
	private String toSave;
	public FileSave(ArrayList<Task> l)
	{
		taskList = l;
		init();
	}
	private void init()
	{
		char enter = 10;
		for(int i = 0 ; i < taskList.size();i++)
		{
			toSave +=taskList.get(i).getName()+":"+taskList.get(i).getDescription()+":"+enter;
		}
	}
	public void save()
	{
		try
		{
			File alarms = new File("bin\\_files\\todolist.vv");
			FileWriter Vikas = new FileWriter(alarms.getAbsoluteFile());
			Vikas.write(toSave);
			Vikas.close();
		}
		catch(Exception e)
		{e.printStackTrace();}
	}
	public static void main(String args[])
	{
		FileSave tryer = new FileSave(new ArrayList<Task>());
		tryer.save();
	}
}