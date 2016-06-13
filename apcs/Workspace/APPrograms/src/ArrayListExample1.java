import java.util.Scanner;
import java.util.ArrayList;

public class ArrayListExample1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); //Keyboard input

		ArrayList <String> list = new ArrayList <String>();
		
		
		list.add ("lol");
		list.add ("trolling");
		list.add ("hello");
		
		System.out.println(list);
		System.out.println(list.remove(0));
		
		list.add(0, "hehe");
		list.set(0, "derp");
		System.out.println(list);
		scan.close();// Stops all keyboard input

	}

}
