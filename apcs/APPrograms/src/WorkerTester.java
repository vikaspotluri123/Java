import java.util.*;
import static java.lang.System.*;

public class WorkerTester {

	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in); //Keyboard input

		Worker worker1 = new Worker("<insert name here>", 15, 8.25);
		Worker worker2 = new Worker();
		out.println("Worker 1's Profile: " +worker1);
		out.println("Worker 2's profile: "+ worker2);
		out.println("Worker 1's name is " + worker1.getName());
		out.println("Worker 1 worked "+worker1.getHoursWorked()+" hours.");
		out.println("Worker 1 gets paid $" + worker1.getHourlyRate() + "/hour.");
		out.println("Worker 1 gets $" + worker1.totalPay());
		worker2.setName("Chub");
		out.println("Worker 2 is " +worker2.getName());
		worker2.payRaise();
		out.print("Worker 2 now gets $"+worker1.getHourlyRate()+"/hr");
		scan.close();// Stops all keyboard input

	}

}
