import java.util.*;
import static java.lang.System.*;

public class classroomTester {

	public static void main(String[] args) 
	{
		Classroom class1 = new Classroom();
		Classroom class2 = new Classroom(100,'c',900);
		
		class1.setCapacity(1000);
		class1.setHall('c');
		class1.setNumber(123456);
		out.println(class1);
		out.println(class2);
		
	}

}
