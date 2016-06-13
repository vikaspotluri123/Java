import java.util.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import static java.lang.System.*;

public class FileManipulator {

	public static void main(String[] args) 
	{
		File file = new File("src/ArrayListExample1.java");
		try
		{
			FileOutputStream stream = new FileOutputStream(file);
		}
		catch(IOException e)
		{
			out.println("fatal error!");
		}
	}

}
