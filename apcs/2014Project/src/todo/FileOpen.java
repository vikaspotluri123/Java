package todo;
import java.io.*;
import java.util.ArrayList;
public class FileOpen
{
	private ArrayList<Task> taskList = new ArrayList<Task>();
	public FileOpen()
	{
		init();
	}
	private void init()
	{
		ArrayList<String> bits = new ArrayList<String>();
		try
		{
			File taskFile= new File("bin\\_files\\todolist.vv");
			FileInputStream reader = new FileInputStream(taskFile);
			int size = (int)(taskFile.length());
			String bit = "";
			String full = "";
			char readChar;
			String readString;
			for(int i = 0 ; i < size; i++)
			{
				readChar = (char)(reader.read());
				readString = String.valueOf(readChar);
				switch(readChar)
				{
					case 58:
					{
						bits.add(bit);
						bit = "";
						full += readString;
						break;
					}
					case 10:
					{
						break;
					}
					default:
					{
						bit += readString;
						full += readString;
						break;
					}
				}
			}	
			for(int i = 0 ; i < bits.size();i++)
			{
				Task a = new Task(bits.get(i),bits.get(i+1),false);
				taskList.add(a);
				i++;
			}
			reader.close();
		}
		catch(Exception e){}
	}
	public ArrayList<Task> getTasks()
	{
		return taskList;
	}
}