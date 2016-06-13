/**
 * @(#)ClimbingClub.java
 *
 *
 * @author
 * @version 1.00 2014/1/28
 */
import java.util.*;

public class ClimbingClub
{

	/*The list of climbs completed by members of the club
	 *Guaranteed not to be null. Contains only non-null references
	 */
	private List <ClimbInfo> climbList;

    //Creates a new ClimbingClub object
    public ClimbingClub()
    {
    	climbList = new ArrayList <ClimbInfo>();    	//TODO:     instantiate the climbList ArrayList
    }

      /**Adds a new climb with name peakName and time climbTime
     *to the list of climbs while maintaining the list in alphabetical order.
     *@param peakName : the name of the mountain peak climbed
     *@param climbTime : the number of minutes taken to complete the climb
     *
     *This implementation of addClimb should create a new ClimbInfo object with the
     *given name and time and then insert the object into the appropriate position in
     *climbList.  Entries that have the same name will be grouped together and can
     *appear in any order within the group.
     *
     *
     * HINT:
     *
     *  You need to look at the list's elements until you find a peak name that is greater than or equal to the
     *  one you are trying to add.  You want to stop looping if you find a peak name that is greater than or equal to the
     *  one you are trying to add so we will use a while loop not a for loop.
     *
     *	The loop will stop at a peak name that is greater than or equal to the one you are trying to add OR when
     *  it has no more elements to look at.
     *
     *  In either case you will add the new ClimbInfo to the ArrayList at the index.
     *
     *Algorithm:																																									   
     *create an index variable and initialize it to zero.
     *while the index number is less than the number of climbs in the ArrayList
     *and the climb's name at index in the ArrayList is less than (use compareTo) the peak's name
	 *add one to your index variable
	 *add a climb to your ArrayList at the index location
	 *
     */
     public void addClimb(String peakName, int climbTime)
     {
    	 int i = 0;
    	 while(i<climbList.size() && climbList.get(i).getName().compareTo(peakName)<0)
    	 {
    		climbList.add(i,new ClimbInfo(peakName,climbTime));
    		i++;
    	 }
    	 	
     }

     /** @return the number of distinct names in the list of climbs  */
     public int distinctPeakNames()
     {
		return climbList.size();
     }

     public String toString()
     {
     	String s =  "";

     	for (ClimbInfo climb : climbList)
     		s += climb.getName()+ "\t\t\t" + climb.getTime() +"\n";

     	return s;
     }





}