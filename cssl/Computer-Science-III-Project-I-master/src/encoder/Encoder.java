package encoder;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Encoder 
{
    
	private String fileName;
	private FileWriter fileWriter;
	private FileReader fileReader;
	
	public Encoder (String filename)
	{
		this.fileName = filename;
	}
	
	private String encode (String plaintext)
	{
		String encoded = "";
		//Encodes plain text into obfuscated text
		for (char c : plaintext.toCharArray())
		{
			int p = (int) c;
			p = p + 13;
			char d = (char)p;
			encoded += String.valueOf(d);
		}
		return encoded;
	}
	
	private String decode (String encodedText)
	{
		String decoded = "";
		//Encodes plain text into obfuscated text
		
		for (char c : encodedText.toCharArray())
		{
			int p = (int) c;
			p = p - 13;
			char d = (char)p;
			decoded += String.valueOf(d);
		}
		return decoded;
	}
	
	public void write(String plaintext)
	{
		List<String> prev = this.read();
		String encoded = "";
		for(String s : prev)
			encoded += encode(s)  + "\n"; 
		encoded += this.encode(plaintext);
		try 
		{
			fileWriter = new FileWriter(this.fileName);
			fileWriter.write(encoded);
			fileWriter.close();
		} 
		catch (IOException e){e.printStackTrace();}
	}
	
	public List<String> read()
	{
		String e = "";
		char txt = 'a';
		try
		{
			fileReader = new FileReader(fileName);
			int read = fileReader.read();
			while(read != -1)
			{
				txt = (char) read;
				read = fileReader.read();
				e += txt;
			}
			fileReader.close();
		}
		catch (IOException ef){}
		String [] f = e.split("\n");
		List<String> g = new ArrayList<String>();
		for(String t : f)
			g.add(decode(t));
		return g;
	}
}