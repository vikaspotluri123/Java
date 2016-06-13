import java.util.Scanner;

public class BackgroundArrayListMaker {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); //Keyboard input
		for(int i =0; i <=100; i++)
		{
			System.out.println("backgrounds["+i+ "]=" +"\""+i+".jpg"+"\"");			
		}
		
		
		scan.close();// Stops all keyboard input

	}

}
