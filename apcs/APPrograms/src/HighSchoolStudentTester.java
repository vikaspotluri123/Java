import java.util.*;
import static java.lang.System.*;

public class HighSchoolStudentTester {

	public static void main(String[] args) 
	{
		HighSchoolStudent [] list = new HighSchoolStudent[5];
		list[0] = new HighSchoolStudent();
		list[1] = new Freshman();
		list[2] = new Sophomore();
		list[3] = new Junior();
		list[4] = new Senior();
		
		for(HighSchoolStudent x : list)
			out.println(x);
	}

}
