import java.awt.List;
import java.util.ArrayList;

public class StationObject 
{
	private String StationName;
	private int StationID;
	private ArrayList<ConnectionLine> connectionLineList;
	
	public StationObject()
	{
		connectionLineList = new ArrayList<ConnectionLine>();
	}
	
	public StationObject(String _stationName, int _stationID)
	{
		connectionLineList = new ArrayList<ConnectionLine>();
		StationName = _stationName;
		StationID = _stationID;
	}
	
	public StationObject(String _stationName, int _stationID, ArrayList<ConnectionLine> _lineList)
	{
		connectionLineList = new ArrayList<ConnectionLine>();
		StationName = _stationName;
		StationID = _stationID;
		connectionLineList = _lineList;
	}
	
	public void setStationName(String stationName)
	{
		StationName = stationName;
	}
	
	public void setStationID(int stationID)
	{
		StationID = stationID;
	}
	
	public String getStationName()
	{
		return StationName;
	}
	
	public int getStationID()
	{
		return StationID;
	}
	
	public ArrayList<Integer> getInBoundingStations()
	{
		ArrayList<Integer> inBoundingStationIDs = new ArrayList<Integer>();
		for (ConnectionLine c : connectionLineList)
		{
			inBoundingStationIDs.add(c.getInBoundID());
		}
		return inBoundingStationIDs;
	}
	
	public ArrayList<Integer> getOutBoundingStations()
	{
		ArrayList<Integer> outBoundingStationIDs = new ArrayList<Integer>();
		for (ConnectionLine c : connectionLineList)
		{
			outBoundingStationIDs.add(c.getOutBoundID());
		}
		return outBoundingStationIDs;
	}
}
