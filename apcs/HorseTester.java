/**
 * @(#)HorseTester.java
 *
 *
 * @author
 * @version 1.00 2014/2/11
 */

public class HorseTester {


    public static void main(String[] args)
      {
      	Horse [] barn = new Horse[10];

      	barn[0] = new ColoradoRanger("Trigger", 1340);
      	barn[2] = new ColoradoRanger("Silver", 1210);
      	barn[5] = new ColoradoRanger("Patches", 1350);
      	barn[6] = new ColoradoRanger("Duke", 1410);


		HorseBarn myBarn = new HorseBarn(barn);

		System.out.println(myBarn);

		System.out.println(myBarn.findHorse("Trigger"));
		System.out.println(myBarn.findHorse("Silver"));
		System.out.println(myBarn.findHorse("Patches"));
		System.out.println(myBarn.findHorse("Duke"));

		System.out.println();
		myBarn.consolidate();
		System.out.println();
		System.out.println(myBarn);

		System.out.println(myBarn.findHorse("Trigger"));
		System.out.println(myBarn.findHorse("Silver"));
		System.out.println(myBarn.findHorse("Patches"));
		System.out.println(myBarn.findHorse("Duke"));

	//	System.out.println(myBarn.findSmallestWeight());
      }
}
