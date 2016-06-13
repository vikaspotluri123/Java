import org.json.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

public class Dictionary
{
	private JSONObject dict = new JSONObject();
	/**
	 * @param JSONObject words - a JSON object containing words to add to the dictionary, format should be <String key, ArrayList<String> definition>
	 */
	public Dictionary(JSONObject words)
	{
		dict = words;
	}
	/**
	 * @params - null
	 * Pretty useless constructor.
	 */
	public Dictionary(){}
	/**
	 * @param String w - The word to add a definition to 
	 * @param String d - The definition to add to the word
	 * @return int - the number of definitions w has
	 * @throws IllegalArgumentException - word doesn't exist
	 * @throws JSONException - Word doesn't exist
	 */
	public int addDefinition(String word, String definition) throws IllegalArgumentException, JSONException
	{
		if(dict.has(word))
		{
			ArrayList<String> temp = getWord(word);
			temp.add(definition);
			dict.put(word, temp);
			return temp.size();
			
		}
		else
		{
			ArrayList<String> c = new ArrayList<String>();
			c.add(definition);
			dict.put(word,c);
			return 1;
		}
	}
	/**
	 * @param String w - The word with the definition
	 * @param int i - The index position of the definition to delete
	 * @return String of the definition removed
	 * @throws IllegalArgumentException - If index doesn't exist
	 * @throws JSONException - If word doesn't exist
	 * @throws IndexOutOfBoundsException - If index doesn't exist
	 */
	public String removeDefinition(String word, int index) throws IllegalArgumentException, JSONException, IndexOutOfBoundsException
	{
		ArrayList<String> temp = getWord(word);
		if(temp.size() < index)
			throw new IndexOutOfBoundsException();
		String trash = temp.remove(index);
		dict.put(word,temp);
		return trash;
		
	}
	/**
	 * @param String w - the word to remove
	 * @return ArrayList<String> of the definitions of the removed word
	 * @throws JSONException if selected word doesn't exist
	 */
	public ArrayList<String> removeWord(String word) throws JSONException
	{
		ArrayList<String> deletedWord = getWord(word);
		dict.remove(word);
		return deletedWord;
	}
	/**
	 * @return ArrayList<String> of all of the words in the dictionary, sorted
	 * @throws JSONException - Shouldn't do it but it might. 
	 */
	public ArrayList<String> wordlist() throws JSONException
	{
		JSONArray t = dict.names();
		ArrayList<String> v = new ArrayList<String>();
		for(int i = 0 ; i < t.length(); i++)
			v.add(t.getString(i));
		Collections.sort(v);
		return v;
	}
	/**
	 * @param String letter (only one)
	 * @return ArrayList<String> of the words in the dictionary containing the letter, sorted
	 * @throws JSONException - Shouldn't throw it but in case it does, because word doesn't exist
	 */
	public ArrayList<String> wordlist(String letter) throws JSONException
	{
		JSONArray t = dict.names();
		ArrayList<String> s = new ArrayList<String>();
		for(int i = 0 ; i < t.length(); i++)
		{
			if(t.getString(i).substring(0,1) == letter)
			{
				s.add(t.getString(i));
			}
		}
		Collections.sort(s);
		return s;
	}
	/**
	 * @param String w - The word to get definitions
	 * @return ArrayList<String> of the definitions contained in w
	 * @throws JSONException if w doesn't exist in the dictionary
	 */
	public ArrayList<String> lookup(String word) throws JSONException
	{
		try
		{
			return getWord(word);
		}
		catch(JSONException e)
		{
			System.out.println("Could not find the word " + word +  " in the dictionary." );
			return new ArrayList<String>();
		}
	}
	/**
	 * @param String w
	 * @return Whether or not w exists in the dictionary. 
	 */
	public boolean contains(String word)
	{
		return dict.has(word);
	}	
	/**
	 * @return int - the number of words in the dictionary
	 */
	public int size()
	{
		return dict.length();
	}
	/**
	 * @param String f - the location of the wordlist, split by newlines for words and tabs for definition splits
	 * @return int - the number of words added to the dictionary.
	 */
	public int load(String filename)
	{
		// 9 = tab, 10 or 13 = new word and skip 
		ArrayList<ArrayList<String>> tempdef  = new ArrayList<ArrayList<String>>();
		try
		{
			File taskFile= new File(filename);
			FileInputStream reader = new FileInputStream(taskFile);
			ArrayList<String> unparsed = new ArrayList<String>();
			String t = "";
			byte[] bytes;
			while(reader.available() > 0)
			{
				//ArrayList<String> topush = new ArrayList<String>();
				int c = reader.read();
				if(c == 10 || c == 13)
				{
					unparsed.add(t);
					t = "";
					reader.read();
				}
				else
				{
					t += Character.toString((char)c);
				}
			}
			for(String a : unparsed)
			{
				ArrayList<String> wordDef = new ArrayList<String>();
				bytes = a.getBytes();
				String f = "";
				for(int i = 0 ; i < bytes.length; i++)
				{
					if(bytes[i] == 9)
					{
						wordDef.add(f);
						f = "";
					}
					else
					{
						f += (Character.toString((char)bytes[i]));
					}
				}
				wordDef.add(f);
				tempdef.add(wordDef);
			}
			for(ArrayList<String> a : tempdef)
			{
				String word = a.remove(0);
				for(String def : a)
					this.addDefinition(word, def);
			}
			reader.close();
		}
		catch(Exception e){e.printStackTrace();}
		return tempdef.size();
	}
	/**
	 * @param String f - The place to save it
	 * @throws FileNotFoundException if the file doesn't exist (overwrites)
	 * @throws JSONException - Will not
	 */
	public void save(String fileName) throws FileNotFoundException, JSONException
	{
		PrintWriter writer = new PrintWriter(fileName);
		JSONArray keys = dict.names();
		char tab = 9;
		for(int i = 0; i < keys.length(); i++)
		{
			writer.print(keys.getString(i));
			writer.print(tab);
			ArrayList<String> defs = getWord(keys.getString(i));
			for(int  j =0 ; j < defs.size(); j++)
			{
				writer.print(defs.get(j));
				if(j != defs.size()-1)
					writer.print(tab);
			}
			writer.println();
		}
		writer.close();
	}
	/**
	 * @param String w - The word to print out
	 * @throws JSONException if the word doesn't exist
	 */
	public  void printWord(String word) throws JSONException
	{
		ArrayList<String> definitions = getWord(word);
		System.out.println("Definitions for the word \"" + word + "\":");
		for(String a : definitions)
		{
			System.out.println("      "+a);
		}
	}
	/**
	 * @param String l - The letter to get all words
	 * @throws JSONException - shouldn't happen
	 */
	public void printAlpha(String letter) throws JSONException
	{
		JSONArray keys = dict.names();
		ArrayList<Integer> sortInts = new ArrayList<Integer>();
		for(int i = 0 ; i < keys.length(); i++)
		{
			if(keys.getString(i).substring(0,1).toLowerCase().compareTo(letter.toLowerCase()) == 0)
				sortInts.add(i);
		}
		if(sortInts.size() <= 0)
		{
			System.out.println("There are no definitions beginning with the letter '" + letter + "'.");
			return;
		}
		System.out.println("Words that begin with '" + letter + "' in this dictionary:");
		for(int i : sortInts)
		{
			printWord(keys.getString(i));
		}
	}
	/**
	 * @throws JSONException
	 * @does Prints all of the words in the dictionary
	 */
	public void printAll() throws JSONException
	{
		JSONArray t = dict.names();
		for(int i = 0 ; i < t.length() ; i++)
		{
			printWord(t.getString(i));
		}
	}
	/**
	 * @param w
	 * @return
	 * @throws JSONException
	 */
	private ArrayList<String> getWord(String w) throws JSONException
	{
		JSONArray temp = (JSONArray) dict.get(w);
		ArrayList<String> list = new ArrayList<String>();
		int len = temp.length();
		for (int i=0;i<len;i++)
			list.add(temp.get(i).toString()); 
		return list;
	}
}
