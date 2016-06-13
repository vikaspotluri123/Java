import java.util.*;

import static java.lang.System.*;

public class BookTester {

	public static void main(String[] args) 
	{
		BookClass book1 = new BookClass();
		BookClass book2 = new BookClass();
		
		book1.setTitle("Trolling All Day");
		book1.setAuthor("Your mother");
		book1.setFiction(true);
		book1.setNumberOfPages(9000);
		book1.setPublishDate(new Date(100,8,3));
		
		book2.setTitle("Trolling All Night");
		book2.setAuthor("Your dad");
		book2.setNumberOfPages(9001);
		book2.setPublishDate(new Date(12,1,2));
		book2.setFiction(false);
		out.println(book1);
		out.println(book2);
	}

}
