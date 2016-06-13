import java.util.*;
import static java.lang.System.*;

public class SchoolFile {

	public static void main(String[] args) 
	{
		ArrayList <HighSchoolStudent> list = new ArrayList<HighSchoolStudent>();
		
		list.add(0, new Freshman());
		list.add(0, new Sophomore());
		list.set(2, new Junior());
		list.set(1, new Senior());
		
		for (int i =0; i <list.size(); i++)
		{
			out.println(list.get(i));
		}
		
		for(HighSchoolStudent me : list)
		{
			out.println("$W@GG" + me);
		}
		
	}

}
