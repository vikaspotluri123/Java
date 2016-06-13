import java.util.ArrayList;
import java.util.HashMap;

public class Graph
{
	private HashMap<Integer,ArrayList<Edge>> graph;
	
	public Graph()
	{
		graph = new HashMap<Integer,ArrayList<Edge>>();
	}
	public boolean addNode(int id, ArrayList<Edge> edges)
	{ 
		//System.out.println("GRAPH:10:ID " + id);
		if(graph.containsKey(id))
			return false;
		graph.put(id, edges);
		return true;
	}
	
	public ArrayList<Edge> getNode(int id)
	{
		return graph.get(id);
	}
	
	public boolean containsNode(int id)
	{
		return graph.containsKey(id);
	}
	
	public HashMap<Integer,ArrayList<Edge>> getGraph()
	{
		return graph;
	}
	
	public void setNode(int id, ArrayList<Edge> edges)
	{
		graph.put(id, edges);
	}
	
	public String toString()
	{
		return graph.toString() + "\n";
	}
}
