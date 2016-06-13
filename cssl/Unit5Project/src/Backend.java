import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 * @author Vikas Potluri
 *
 */
public class Backend
{

	/**
	 * HashMap<String [id],HashMap<String [detail], String [value]>> - the data
	 * TreeSet<String> - A TreeSet of passwords
	 */
	private TreeMap<String,HashMap<String,String>> data = new TreeMap<String,HashMap<String,String>>();
	private TreeSet<String> availablePasswords;
	private static final String TAB = "\t";
	private static final String NEWLINE = "\n";
	/**
	 * 
	 */
	public Backend()
	{
		
	}
	
	public Backend(TreeMap<String,HashMap<String,String>> d)
	{
		data = d;
		reloadAvailablePasswords();
	}
	
	public TreeMap<String,HashMap<String,String>> getData()
	{
		return data;
	}
	
	public String generatePassword()
	{
		String pass = availablePasswords.first();
		availablePasswords.remove(pass);
		return pass;
	}
	
	public void addTeam(String id, String pass, String name)
	{
		HashMap<String,String> e = new HashMap<String,String>();
		e.put("password", pass);
		e.put("id", id);
		e.put("name", name);
		data.put(name, e);
	}
	
	public HashMap<String,HashMap<String,String>> sortByName()
	{
		HashMap<String,HashMap<String,String>> name = new HashMap<String,HashMap<String,String>>();
		Iterator<String> e = data.keySet().iterator();
		while(e.hasNext())
		{
			String id = e.next();
			HashMap<String,String> f = data.get(id);
			id = f.get("name");
			name.put(id,f);			
		}
		return name;
	}
	public ArrayList<String> startsWith(String p)
	{
		ArrayList<String> t = new ArrayList<String>();
		HashMap<String,HashMap<String,String>> names = this.sortByName();
		Iterator<String> e = names.keySet().iterator();
		while(e.hasNext())
		{
			String name = e.next();
			if(name.contains(p))
				t.add(name);
		}
		return t;
	}
	public boolean reloadAvailablePasswords()
	{
		try
		{
			FileInputStream e = new FileInputStream(new File("passwords.txt"));
			String readSoFar = "";
			TreeSet<String> passwords = new TreeSet<String>();
			while(e.available() > 0)
			{
				char read = (char)e.read();
				if(read == '\t')
				{
					passwords.add(readSoFar);
					readSoFar = "";
				}
				else readSoFar += read;
			}
			availablePasswords = passwords;
			e.close();
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Error loading password list");
			return false;
		}
		
	}
	
	public boolean contains(String w)
	{
		return data.containsKey(w);
	}
	
	public HashMap<String, String> lookup(String id)
	{
		return data.get(id);
	}
	
	public void loadTeams()
	{
		try
		{
			FileInputStream e = new FileInputStream(new File("teams.txt"));
			ArrayList<String> info = new ArrayList<String>();
			String temp = "";
			while(e.available() > 0)
			{
				char read = (char)e.read();
				if(read == '\n')
				{
					info.add(temp);
					addTeam(info.get(0),info.get(1),info.get(2));
					info = new ArrayList<String>();
					temp = "";
				}
				else if(read == '\t')
				{
					info.add(temp);
					temp = "";
				}
				else temp += read;
			}
			e.close();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Error loading team list");
		}
	}
	public boolean delete(String w)
	{
		if(data.containsKey(w))
		{
			
		}
		return false;
	}
	public void save()
	{
		String toWrite = "";
		Iterator<String> dataI = data.keySet().iterator();
		while(dataI.hasNext())
		{
			HashMap<String,String> e = data.get(dataI.next());
			toWrite += e.get("id") + Backend.TAB + e.get("password") + Backend.TAB + e.get("name") + Backend.NEWLINE;
		}
		try
		{
			PrintWriter e = new PrintWriter(new File("teams.txt"));
			e.print(toWrite);
			e.close();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Error saving teamlist");
		}
		
		toWrite = "";
		Iterator<String> passwordsI = availablePasswords.iterator();
		while(passwordsI.hasNext())
		{
			toWrite += passwordsI.next() + Backend.TAB;
		}
		
		try
		{
			PrintWriter e = new PrintWriter(new File("passwords.txt"));
			e.print(toWrite);
			e.close();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Error saving available password list");
		}		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Backend e = new Backend();
		e.addTeam("team1", "dinero", "Cedar Ridge");
		e.addTeam("team2", "ignite", "McNeil #1");
		e.addTeam("team3", "madlib", "Round Rock");
		e.addTeam("team4", "cactus", "Stony Point #1");
		e.addTeam("team5", "nitwit", "Westwood");
		e.addTeam("team6", "shovel", "McNeil #2");
		e.addTeam("team7", "leaves", "Stony Point #2");
		e.addTeam("team8", "canary", "Stony Point #3");
		e.save();
	}
}
