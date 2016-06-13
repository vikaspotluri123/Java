import java.util.*;
import static java.lang.System.*;

public class TimeRecordTest {

	public static void main(String[] args) 
	{
		TimeRecord time = new TimeRecord();
		out.println(time);
		
		time.advance(0,70);
		out.println(time);
	}

}
