import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
public class deleteLater {
	public static void main(String[] arguments) 
	{
			ArrayList<Person> people = new ArrayList<Person>();
			ArrayList<Integer> colon = new ArrayList<Integer>();
			int peopleInArray = 0;
			byte[] store = new byte[1];
			try
			{
				File reader = new File("C:\\Users\\vcpotluri\\Copy\\Comp Sci\\Project\\Workspace\\2014Project\\src\\people.txt");
				FileInputStream file = new FileInputStream(reader);
				int size = (int)reader.length();
				for(int i = 0 ; i < size ; i++)
				{
					int fileReadOutput = file.read();
					if(!(fileReadOutput== 13))
					{
						System.out.print(fileReadOutput);
					}
					else 
						{
						System.out.print("<enter>");
						file.read();
						}
				}
				file.close();
			}
			catch(Exception e)
			{
				System.out.println("Error: "+e);
			}
			//return people;
			System.out.println(colon);
	}
}