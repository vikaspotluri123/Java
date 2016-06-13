import java.util.*;
import static java.lang.System.*;

public class AnimalTester {

	public static void main(String[] args) 
	{
		AnimalClass animal1 = new AnimalClass();
		AnimalClass animal2 = new AnimalClass("troller", "human", 150);
		
		animal1.setName("Zebra");
		animal1.setType("Lion");
		animal1.setWeight(1000);
		out.println(animal1);
		out.println(animal2);
		
		out.println(animal2.getName());
		
	}

}
