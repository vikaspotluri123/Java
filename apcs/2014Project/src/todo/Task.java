package todo;
import alarmclock.*;
import bankaccountpeople.*;
import bankaccount.*;
import _files.*;
public class Task
{
	private String description;
	private String name;
	private boolean finished;
	public Task(String n, String d, boolean f)
	{
		description = d;
		name = n;
		finished = f;
	}
	
	public void setName(String n)
	{
		name = n;
	}
	public String getName()
	{
		return name;
	}
	public void setDescription(String d)
	{
		description = d;
	}
	public String getDescription()
	{
		return description;
	}
	public void setFinished(boolean b)
	{
		finished = b;
	}
	public boolean isFinished()
	{
		return finished;
	}
}
