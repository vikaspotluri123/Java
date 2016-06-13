
public class Example {

	public static void main(String[] args) {
		System.out.println("Hello World!");
		int number = 0;
		int smallestNumber = 0;
		String name = "Westwood High School";
		char letter ='+';
		int letterNumber = letter;
		
		number = Integer.MAX_VALUE;		
		smallestNumber = number + 1;
		
		System.out.println(number);
		System.out.println("Too big :)");
		System.out.println("");
		System.out.println(smallestNumber);
		System.out.println("Too small :(");
		System.out.println("");
		System.out.println("The letter is "+ letter);
		System.out.println("The number of the letter is "+ letterNumber);
		letter++;
		System.out.println("");
		System.out.println("The new letter is " + letter );
		
		System.out.println(name.charAt(0)); //We defined name String Westwood High School so it prints the  (x) character in it.
		System.out.println(name.indexOf('o')); //Looks where the the character is and gives the location of the first character. If it doesn't exist, it prints -1


	}

}
