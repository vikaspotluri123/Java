
public class ConnectionLine 
{
	private String lineName;
	private int outboundID;
	private int inboundID;
	
	public ConnectionLine(String _lineName, int _outboundID, int _inboundID)
	{
		lineName = _lineName;
		outboundID = _outboundID;
		inboundID = _inboundID;
	}
	
	public ConnectionLine()
	{
		
	}
	
	public String getLineName()
	{
		return lineName;
	}
	
	public int getOutBoundID()
	{
		return outboundID;
	}
	
	public int getInBoundID()
	{
		return inboundID;
	}
}
