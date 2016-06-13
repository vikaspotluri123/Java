package alarmclock;
public class Sound 
{
	String soundName;
	String soundLocation;
	public Sound(String name, String fileLocation)
	{
		soundName = name;
		soundLocation = fileLocation;
	}
	public String getName()
	{
		return soundName;
	}
	public String getFileLocation()
	{
		return soundLocation;
	}
	public void setFileLocation(String s)
	{
		soundLocation = s;
	}
	public void setName(String n)
	{
		soundName = n;
	}
	public String toString()
	{
		return"------------------------You are viewing the toString function of a Sound------------------------ \n"
			+ "The name of the sound is :                 "+getName()+"\n"
			+" The sound file location is :               "+getFileLocation()+"\n"
			+"-------------------------------End of Sound toString---------------------------------------------";
	}
}