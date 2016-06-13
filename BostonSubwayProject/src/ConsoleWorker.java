import java.io.IOException;
import java.util.ArrayList;

public class ConsoleWorker {

	public static void main(String[] args) throws Exception 
	{
		// TODO Auto-generated method stub
		System.out.println("ddddd");
		MetroMapParser mmp = new MetroMapParser("bostonmetro.txt");
		mmp.generateGraphFromFile();
		//ArrayList<StationObject> x = mmp.getStationObjectList();
		//System.out.println(x.get(2).getStationName());
		mmp.FindRoute("OakGrove", "State");
		//System.out.println(25);
		//int i = mmp.LookupStationID("Waban");
		//System.out.println(i);
	}

}
