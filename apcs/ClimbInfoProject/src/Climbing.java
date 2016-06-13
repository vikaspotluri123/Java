/**
 * @(#)Climbing.java
 *
 *
 * @author
 * @version 1.00 2014/1/28
 */

public class Climbing
{


    public static void main(String[] args)
    {

        ClimbingClub hikerClub = new ClimbingClub();
 		hikerClub.addClimb("Monadnock", 274);
 		hikerClub.addClimb("Whiteface", 301);
 		hikerClub.addClimb("Algonquin", 225);
 		hikerClub.addClimb("Monadnock", 344);

 	 	System.out.println(hikerClub);
 		System.out.println("Total climbs          "+ hikerClub.distinctPeakNames());
    }
}
