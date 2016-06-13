public class Edge
{
	private int starting;
	private int ending;
	
	public Edge(int starting, int ending)
	{
		this.starting = starting;
		this.ending = ending;
	}
	
	public int getStarting()
	{
		return starting;
	}
	
	public int getEnding()
	{
		return ending;
	}
	
	public void setStarting(int where)
	{
		starting = where;
	}

	public void setEnding(int where)
	{
		ending = where;
	}
	
	public String toString()
	{
		return "{Starting: " + starting + " , Ending: " + ending + "}\n"; 
	}

}