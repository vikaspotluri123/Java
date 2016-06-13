import java.util.*;
import static java.lang.System.*;
import java.util.Date;

public class BookClass {
	
	private String title;
	private String author;
	private Date publishDate;
	private boolean fiction;
	private int numPages;
	

	public static void main(String[] args) 
	{
				
	}
	
	public String toString()
	{
		String s="";
		s = s + "Tite..................." + title + "\n";
		s = s + "Author................." + author + "\n";
		s = s + "Fiction................" + fiction + "\n";
		s = s + "Publishing Date........" + publishDate + "\n";
		s = s + "Number of Pages........" + numPages + "\n";
		return s;
	}
	
	public String getTitle()
	{
		return title;
	}
	public String getAuthor()
	{
		return author;
	}
	public boolean getFiction()
	{
		return fiction;
	}
	public Date getPublishDate()
	{
		return publishDate;
	}
	public int getNumberOfPages()
	{
		return numPages;
	}
	
	public void setTitle(String n)
	{
		this.title = n;
	}
	public void setAuthor(String n)
	{
		this.author = n;
	}
	public void setFiction(boolean n)
	{
		this.fiction = n;
	}
	public void setPublishDate(Date n)
	{
		this.publishDate =n;		
	}
	public void setNumberOfPages(int n)
	{
		this.numPages = n;
	}
}
