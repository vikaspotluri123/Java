
public class word
{
	private String name, definition;
	public word() 
	{
		name = "";
		definition = "";
	}
	
	public void setName(String what)
	{
		name = what;
	}
	
	public void setDefinition(String what)
	{
		definition = what;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getDefinition()
	{
		return definition;
	}
	
	public String nicePrint()
	{
		return "The definition of " +  name + " is " + definition;
	}
	
	public String toString()
	{
		return this.name + " - " + this.definition;
	}
}
