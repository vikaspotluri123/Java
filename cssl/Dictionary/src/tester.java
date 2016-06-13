import org.json.JSONException;
//import org.json.JSONObject;

import java.io.FileNotFoundException;
//import java.util.ArrayList;

public class tester {

public static void main(String [] args) throws JSONException, FileNotFoundException
{
	Dictionary dict = new Dictionary();
	System.out.println("STEP: Adding Vikas as a definition for Mickel...\n Added "+dict.addDefinition("Mickel","Potluri") + " definition");
	dict.printAll();
	dict.save("Project5.txt");
	dict.load("Dictionary\\ibglossary.txt");
	System.out.println("There are "+dict.size()+" words in this dictionary");
	System.out.println("STEP: Looking up definitions for the word \"Mickel\"...\n"+dict.lookup("Mickel"));
	System.out.println("STEP: Looking up the word \"test\" in the dictionary...\n Definitions for the word test: "+dict.lookup("test"));
	System.out.println("STEP: Printing all words that begin with 'p'");
	dict.printAlpha("p");
	System.out.println("STEP: Printing all words that begin with 'g'");
	dict.printAlpha("g");
}
}