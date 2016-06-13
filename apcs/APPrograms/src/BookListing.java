import java.util.*;
import static java.lang.System.*;

public class BookListing {

	public static void main(String[] args) 
	{
		List <BookClass> myBooks = new ArrayList<BookClass>();
		
		myBooks.add(new BookClass());
		myBooks.add(new BookClass());
		myBooks.add(new BookClass());
		myBooks.add(new BookClass());
		myBooks.add(new BookClass());
		myBooks.add(new BookClass());
		
		myBooks.get(0).setTitle("Book Name Goes Here");
		myBooks.get(0).setAuthor("Troller number");
		myBooks.get(0).setFiction(true);
		myBooks.get(0).setNumberOfPages(0104014104);
		myBooks.get(0).setPublishDate(new Date(122,41,2));
		out.println(myBooks);	
	}

}
