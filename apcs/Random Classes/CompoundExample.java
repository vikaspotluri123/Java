public class CompoundExample {
		public static void main(String[] args)
		{
			/* Grades :
			 * 100-90 : A
			 * 89-80  : B
			 * 79-70  : C
			 * < 70   : NOT PASSING
			 */
			int grade = 101948 ;
			if (grade > 100)
				System.out.println ("TOO OP! Your grade is" + grade );
			else
					if ((grade <=100) && (grade >= 90))
					System.out.println("Ok. You got a " + grade "Your grade is an A");
				else
					if ( (grade <90) && (grade >=80))
						System.out.println("Bad. Study more. You got a " + grade " grade is a B");
					else
						 if ((grade < 80) && (grade >=70))
						 	System.out.println("Horrifying! No food for a week. You got a (" + grade ") grade is a C");
						 else System.out.println("I now disown you. You got a " + grade " You are not passing");

		}
}