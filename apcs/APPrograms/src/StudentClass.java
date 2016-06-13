public class StudentClass
{
	private String name;
	private int id;
	private double average;
	private String [] courses;
	private int [] scores;
	private static String schoolName = "Westwood High School";
	
	public StudentClass()
	{
		name = "";
		id = 0;
		average = 0;
		courses= new String [3];
		scores = new int [3];
		
		
	}
	public String getName()
	{
		return name;
	}
	public int getId()
	{
		return id;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	
	public String getCourse(int whichCourse)
	{
		return courses[whichCourse];
	}
	
	public double getScore(int whichCourse)
	{
		return scores[whichCourse];
	}
	public static void setSchool(String name)
	{
		schoolName = name;
	}
	
	public String toString()
	{
		String s = "\n" ;
		s += "School Name......"+ schoolName+"\n";
		s += "Name............."+ getName() +"\n";
		s += "Id..............."+ getId()+"\n";
		s += "Average.........."+ setAverage()+"\n";
		
		for(int i = 0; i < courses.length; i++)
		{
			s += getCourse(i) + " ";
		}
		
		s += "\nScores........";
		
		for(int i = 0 ; i <scores.length; i++)
		{
			s += getScore(i)+ "   ";
		}
		s +="\n\n";
		return s;		
	}
	
	public boolean setCourse(int whichCourse, String courseNumber)
	{
		if(whichCourse < 0 || whichCourse >= courses.length)
			return false;
		courses[whichCourse] = courseNumber;
			return true;
	}
	
	public boolean setScore(int whichScore, int whatScore)
	{
		if(whichScore < 0 || whichScore >= scores.length)
			return false;
		scores[whichScore] = whatScore;
			return true;
	}
	
	private double setAverage()
	{
		average = 0;
		double s = 0.0;
		for(int i = 0 ; i <scores.length; i++)
		{
			s += scores[i];
		}
		
		average = (s/scores.length);		
		
		return average;
	}
	
	public boolean equals(StudentClass that)
	{
		if (this.getId() != that.getId())
			return false;	
		
		return true;
	}
}
