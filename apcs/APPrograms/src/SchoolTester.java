import java.util.*;
import static java.lang.System.*;

public class SchoolTester {

	public static void main(String[] args) 
	{
		StudentClass myStudent = new StudentClass();
		StudentClass anotherStudent = new StudentClass();
		myStudent.setName("Joe Hsu");
		myStudent.setId(1848121);
		myStudent.setCourse(0,"Biomed");
		myStudent.setCourse(1,"Spanish");
		myStudent.setCourse(2,"PreCal");
		myStudent.setScore(0,99);
		myStudent.setScore(1,100);
		myStudent.setScore(2, 100);
		out.println(myStudent);
		anotherStudent.setName("Goa Li");
		anotherStudent.setId(1481368);
		anotherStudent.setCourse(0,"Spanish");
		anotherStudent.setCourse(1,"Science");
		anotherStudent.setCourse(2,"Sports");
		anotherStudent.setScore(0,95);
		anotherStudent.setScore(1,95);
		anotherStudent.setScore(2, 92);
		out.println(anotherStudent);
		StudentClass.setSchool("The Best High School");
		out.println(anotherStudent);
		out.println(myStudent);
	}

}
