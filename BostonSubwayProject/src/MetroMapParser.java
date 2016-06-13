import java.awt.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class MetroMapParser 
{
	
	private BufferedReader fileInput;
	private ArrayList<StationObject> stationObjectList;
	private ArrayList<ArrayList<StationObject>> ListOfRoutes;

	public static void main(String[] args) 
	{
		
		if (args.length != 1)
		{
			usage();
			System.exit(0);
		}
		String filename = args[0];
		try
		{
			MetroMapParser mmp = new MetroMapParser(filename);
			mmp.generateGraphFromFile();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	private static void usage()
	{
		System.out.println("java ex3.MetroMapParser<filename>");
	}
	
	public ArrayList<StationObject> getStationObjectList()
	{
		return stationObjectList;
	}

	public MetroMapParser(String filename) throws IOException
	{
		fileInput = new BufferedReader(new FileReader(filename));
		stationObjectList = new ArrayList<StationObject>();
		//stationObjectList.add(null);
	}
	
	public void generateGraphFromFile() throws IOException, Exception
	{
		String line = fileInput.readLine();
		StringTokenizer st;
		String stationID;
		String stationName;
		String lineName;
		String outboundID, inboundID;
		
		while (line != null)
		{
			//StationObject so = new StationObject();
			
			st = new StringTokenizer(line);
			if (!st.hasMoreTokens())
			{
				line = fileInput.readLine();
				continue;
			}
			
			
			stationID = st.nextToken();
			//so.setStationID(Integer.parseInt(stationID));
			if (!st.hasMoreTokens())
			{
				throw new Exception("no station name");
			}

			stationName = st.nextToken();
			//so.setStationName(stationName);
			if(!st.hasMoreTokens()) 
			{
				throw new Exception("station is on no lines");
			}
			
			ArrayList<ConnectionLine> connectionLineList = new ArrayList<ConnectionLine>();
			
			while(st.hasMoreTokens()) 
			{			
				lineName = st.nextToken();
				if(!st.hasMoreTokens()) 
				{
					throw new Exception("poorly formatted line info");
				}
				outboundID = st.nextToken();
				if(!st.hasMoreTokens()) 
				{
					throw new Exception("poorly formatted adjacent stations");
				}

				inboundID = st.nextToken();
				ConnectionLine _line = new ConnectionLine(lineName, Integer.parseInt(outboundID), Integer.parseInt(inboundID));
				connectionLineList.add(_line);
			}
			StationObject so = new StationObject(stationName, Integer.parseInt(stationID), connectionLineList);
			stationObjectList.add(so);
			line = fileInput.readLine();
		}
	}
	
	public int LookupStationID(String station)
	{
		for (StationObject so : stationObjectList)
		{
			//System.out.println(stationObjectList.get(3).getStationName());
			//System.out.println(so.getStationName());
			//if (so != null)
			///System.out.println(so.getStationName());
			String thisName = so.getStationName();
			//System.out.println(thisName);
			if (thisName.equals(station))
			{
				System.out.println("HELLO");
				//System.out.print(so.getStationName());
				return so.getStationID();
			}
			
		}
		//returns "0" if the station is not found.
		return 0;
	}
	
	public void FindRoute(String startStation, String endStation)
	{
		int _startStation = LookupStationID(startStation);
		
		int _endStation = LookupStationID(endStation);
		StationObject endStationObject = new StationObject();
		endStationObject = stationObjectList.get(_endStation - 1);
		boolean foundStation = false;
		StationObject so = new StationObject();
		so = stationObjectList.get(_startStation - 1);
		ListOfRoutes = new ArrayList<ArrayList<StationObject>>();
		ArrayList<StationObject> stationsToSearchFrom = new ArrayList<StationObject>();
		stationsToSearchFrom.add(so);
		{
			ArrayList<StationObject> temp = new ArrayList<StationObject>();
			temp.add(so);
			ListOfRoutes.add(temp);
		}
		outerloop:
		while (foundStation = true)
		{
			ArrayList<StationObject> newStationsToSearchFrom = new ArrayList<StationObject>();
			
			//for each station "s" in the list of stations to search from
			for (StationObject s : stationsToSearchFrom)
			{
				//get the Route that contains that station "s" and store it as a temp, while deleting
				//the original route from ListOfRoutes.
				ArrayList<StationObject> temp = new ArrayList<StationObject>();
				innerloop:
				
				for (ArrayList<StationObject> o : ListOfRoutes)
				{
					if (o.contains(s))
					{
						temp = o;
						ListOfRoutes.remove(o);
						break innerloop;
					}
				}
				
				//find the stations that are outbounding from "s". Make ArrayList<StationObject>
				//items that are identical to "temp" with the stations outbounding from "s" appended
				//on the end. Reinsert them into ListOfRoutes.
				for (Integer oS : s.getInBoundingStations())
				{
					ArrayList<StationObject> newRoute = new ArrayList<StationObject>();
					newRoute = temp;
					StationObject appendingStation = new StationObject();
					appendingStation = stationObjectList.get(oS - 1);
					newStationsToSearchFrom.add(appendingStation);
					newRoute.add(appendingStation);					
					ListOfRoutes.add(newRoute);
					//if we find that the appending station is in fact the one we're looking for, 
					//set "foundStation" to true, and go to the "getRoute" method
					if (appendingStation.equals(endStationObject))
					{
						getRoute(endStationObject);
						foundStation = true;
						break outerloop;
					}
				}
				ListOfRoutes.stationsToSearchFrom = new ArrayList<StationObject>();
				stationsToSearchFrom = new ArrayList<StationObject>();
			}
		}
	}

	private void getRoute(StationObject endStationObject) 
	{
		for (ArrayList<StationObject> Route : ListOfRoutes)
		{
			if (Route.contains(endStationObject))
			{
				displayRoute(Route);
			}
		}
	}

	private void displayRoute(ArrayList<StationObject> route) 
	{
		for (StationObject s : route)
		{
			System.out.println(s.getStationName());
		}
	}
}
