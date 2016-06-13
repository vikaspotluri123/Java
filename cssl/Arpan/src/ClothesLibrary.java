import java.util.*;
import java.io.*;
public class ClothesLibrary {
private Map<String, Clothing> myData;
//private int mySize; 


public ClothesLibrary()
{
	myData= new TreeMap<String, Clothing>();
	
}
public Clothing  lookup(String name)
{
	return myData.get(name);
}



public boolean addClothing(String name, Clothing x)
{	
	if (myData.containsKey(name))
	{
		System.out.println("Item Already Exists");
		return false;
	}	
	myData.put(name, x);
	return true;
}
public boolean removeClothing(String name)
{	
	if (!(myData.containsKey(name)))
	{
		System.out.println("No such clothing item exists"); 
		return false;
	}
	myData.remove(name); 
	return true;
}
public List<String> clothingList()
{
	List<String> clothesList = new ArrayList<String>();
	 
	for( String x : myData.keySet())
	{
		clothesList.add(x); 
	}
	return clothesList; 
}

public boolean searchClothing()
{	String s;
	Scanner in=new Scanner(System.in); 
	System.out.println("Enter a clothing item"); 
	s=in.nextLine();
	in.close();
	 
	for(int i =0; i<=myData.size();i++)
	{
		if(myData.get(i).getItemName().equals(s))
		{
			System.out.println(s +"was found at" +i);
			return true;
		}
	}
	return false; 
}

public String printClothesItem(Clothing x)
{
	if(myData.isEmpty())
	{
		System.out.println("No items in the Library");
	}
	if(!(myData.containsValue(x)==true))
	{
		System.out.println( "Item not Found");
		return null;
	}
	System.out.println(x.getItemName());
	return x.getItemName();
	
	
}
public void printAllClothes()
{ 

	Iterator<Clothing> e = myData.values().iterator();
	while(e.hasNext())
	{
		e.next();
	}
	
}
public int size()
{
	int counter=0;
	for(int i =0; i<= myData.size(); i++)
	{
		counter++;
	}
	return counter;
}
public int getAverageTemperature()
{
	 int temperature; 
	 Scanner in = new Scanner(System.in);
	 System.out.println( " PLease enter temperature data for 8 AM,just the numerical values");
	temperature= in.nextInt(); 
	 System.out.println("Please enter temperature data for 10 AM");
	 temperature= temperature + in.nextInt();
	 System.out.println(" Please enter temperature data for 12 PM");
	 temperature= temperature + in.nextInt();
	 System.out.println("Please enter temperature for 4 PM");
	 temperature= temperature + in.nextInt();
	 System.out.println("Please enter temperature for 8 PM");
	 temperature= temperature + in.nextInt();
	 in.close();
	 int averagetemperature= temperature/5;
	 return averagetemperature;
}
	
public int getAverageHumidity()
{
	 int humidity; 
	 Scanner in = new Scanner(System.in);
	 System.out.println( " PLease enter humidity data for 8 AM,just the numerical valuesof the percentage");
	humidity= in.nextInt(); 
	 System.out.println("Please enter humidity data for 10 AM");
	 humidity= humidity + in.nextInt();
	 System.out.println(" Please enter humidity data for 12 PM");
	 humidity= humidity + in.nextInt();
	 System.out.println("Please enter humidity for 4 PM");
	 humidity= humidity + in.nextInt();
	 System.out.println("Please enter humidity for 8 PM");
	 humidity= humidity + in.nextInt();
in.close();
	 int averagehumidity= humidity/5;
	 return averagehumidity;
}
public int getAveragePrecipitation()
{
	 int precipitation; 
	 Scanner in = new Scanner(System.in);
	 System.out.println( " PLease enter precipitation data for 8 AM,just the numerical values of the percentage");
	precipitation= in.nextInt(); 
	 System.out.println("Please enter precipitation data for 10 AM");
	 precipitation= precipitation + in.nextInt();
	 System.out.println(" Please enter precipitation data for 12 PM");
	 precipitation= precipitation + in.nextInt();
	 System.out.println("Please enter precipitation for 4 PM");
	 precipitation= precipitation + in.nextInt();
	 System.out.println("Please enter precipitation for 8 PM");
	 precipitation= precipitation +in.nextInt();
	 in.close();
	 int averageprecipitation=precipitation/5;
	 return averageprecipitation;

}
public Clothing compileData()
{
	 int x = this.getAverageHumidity();
	 int y = this.getAveragePrecipitation();
	 int z = this.getAverageTemperature();  
	 
	Scanner in=new Scanner(System.in); 
	System.out.println("Do you want a shirt or  pants item");
	String s= in.nextLine();
	for(Clothing loyal : myData.values())
	{if(s.equalsIgnoreCase("shirt"))
		{
		loyal.setShirt(true);
		if( z< 60)
		{		 
		 loyal.setSleeve(true); 
		 if( x< 50 )
		 {
			 loyal.setThickness(true); 
		 }
		 if(y<50)
		 {
			 loyal.setMaterial(true);
		 }
		 myData.get(loyal.getItemName());
		 in.close();
		 return loyal; 
	 }
	}
	if( z< 60)
	 {
		 loyal.setSleeve(true); 
		 if( x< 50 )
		 {
			 loyal.setThickness(true);
		 }
		 if(y<50)
		 {
			 loyal.setMaterial(true);
		 }
		 myData.get(loyal.getItemName());
		 in.close();
		 return loyal; 
	 }
	in.close();
	 return loyal;
	}
	in.close();
	System.out.println("Sorry no item was found for this data");
	return null; 
}
public int load(String filename)
{
	int count = 0;
	try 
	{
		Scanner fin = new Scanner(new File(filename));
		while(fin.hasNextLine())
		{
			String[] s = fin.nextLine().split("\t");
			for(int i = 1; i<= s.length ; i++)
			{		
				this.addClothing(s[0], this.lookup(s[0])); 	
			}
		count++;
		}
		fin.close();
	} 
	catch (FileNotFoundException e) 
	{
		e.printStackTrace();
	}
	return count;
}
void save(String filename)
{
	try
	{
		PrintWriter printer = new PrintWriter(new FileWriter(new File(filename)));
		
		for ( String name: clothingList())
		{
			printer.println(name + "/t" + this.lookup(name));
		}
		printer.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
}
}
