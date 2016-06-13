import java.util.*;
import static java.lang.System.*;

public class WordListTester {

	public static void main(String[] args) 
	{
		ArrayList <String>words = new ArrayList<String>();
		words.add("cat");
		words.add("mouse");
		words.add("frog");
		words.add("dog");
		words.add("rat");
		
		WordList tester = new WordList(words);
		System.out.println(tester);
		System.out.println(tester.numWordsOfLength(3));
		System.out.println(tester.numWordsOfLength(4));
		tester.removeWordsOfLength(3);
		System.out.println(tester);
		
	}

}
