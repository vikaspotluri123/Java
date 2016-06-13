package alarmclock;
import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
public class Sounds
{
	String fileContents = "";
	ArrayList<Sound> soundList;
	public Sounds()
	{
		getSounds();
	}
	public void getSounds()
	{
		ArrayList<String> bits = readFile();
		soundList = new ArrayList<Sound>();
		for(int i = 0 ; i < bits.size();i++)
		{
			soundList.add(new Sound(bits.get(i),bits.get(i+1)));
			i = i +1;
		}
		makeFile(soundList);
	}
	public void addSound(String name, String src)
	{
		if(checkExists(name))
		{
			copy(src);
			soundList.add(new Sound(name,src));
			makeFile(soundList);
			saveFile();
		}
	}
	public ArrayList<String> readFile()
	{
		ArrayList<String> bits = new ArrayList<String>();
		try
		{
			File a = new File("bin\\_files\\sounds.vv");
			FileInputStream reader = new FileInputStream(a);
			int size = (int)(a.length());
			String singChar = "";
			int intSingChar;
			String full = "";
			for(int i = 1 ; i < size ; i++)
			{
				intSingChar = reader.read();
				singChar = String.valueOf((char)(intSingChar));
				if(intSingChar == 58)
				{
					bits.add(full);
					full = "";
				}
				else if(intSingChar == 10){}
				else
				{
					full +=singChar;
				}
			}
			reader.close();
		}
		catch(Exception e){e.printStackTrace();}
		return bits;
	}
	public void saveFile()
	{
		try
		{
			File toSave = new File("bin\\_files\\sounds.vv");
			FileOutputStream a = new FileOutputStream(toSave);
			Writer writer = new BufferedWriter(new OutputStreamWriter(a));
			writer.write(fileContents);
			writer.close();
			a.close();
		}
		catch(Exception e){}
	}
	public void copy(String a)
	{
		try
		{
			File toCopy = new File(a);
			File toMove = new File("bin\\_files\\sounds\\"+a);
			Files.copy(toCopy.toPath(),toMove.toPath());
		}
		catch(Exception e){}
	}
	private void makeFile(ArrayList<Sound> toSave)
	{
		fileContents ="";
		char a = 10;
		for(int i = 0 ; i<soundList.size();i++)
		{
			fileContents += a+soundList.get(i).getName()+":"+soundList.get(i).getFileLocation()+":";
		}
	}
	public ArrayList<Sound> getListOfSounds()
	{
		getSounds();
		return soundList;
	}
	public void removeSound(String soundName)
	{
		for(int i = 0 ; i < soundList.size(); i++)
		{
			if(soundList.get(i).getName() == soundName)
			{
				soundList.remove(i);
				makeFile(soundList);
				saveFile();
			}
			else if(soundList.get(i).getName().equals(soundName))
			{
				soundList.remove(i);
				makeFile(soundList);
				saveFile();
			}
		}
	}
	private boolean checkExists(String name)
	{
		for(int i = 0 ; i < soundList.size();i++)
		{
			if(soundList.get(i).getName().equals(name))
			{
				return false;
			}
			else if(soundList.get(i).getName() == name)
			{
				return false;
			}
		}
		return true;
	}
}
