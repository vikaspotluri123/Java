import java.util.Collection;
import java.util.ArrayList;
public class ListSetTester
{
	public static void main(String[] args)
	{
		ListSet<String> a = new ListSet<String>();
		Collection<String> temp = new ArrayList<String>();
		temp.add("PE");
		temp.add("Chem");
		temp.add("English");
		temp.add("CS");
		temp.add("Spanish");
		temp.add("Euro");
		temp.add("Bio");
		temp.add("CalcAB");
		a.addAll(temp);
		a.addAll(a);
		a.removeAll(a);
		// Insert code to thoroughly test each of your
		// methods in the LinkedListSet class.
		System.out.println(a);
	}
}
