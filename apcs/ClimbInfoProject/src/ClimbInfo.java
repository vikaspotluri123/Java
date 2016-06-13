/**
 * @(#)ClimbInfo.java
 *
 *
 * @author
 * @version 1.00 2014/1/28
 *
 *A moutain climbing club maintans a record of climbs that its memebers
 *have made.  Information about a climb includes the name of the mountain peak and the
 *amount of time it took to reach the top.  The information is contained
 *in the ClimbInfo class as declared below
 */


public class ClimbInfo
{

	private String peakName;
	private int climbTime;


	/**Creates a ClimbInfo object with name peakName and time climbTime.
	 *@param peakName : the name of the mountain peak
	 *@param climbTime : the number of minutes taken to complete the climb
	 */
    public ClimbInfo(String peakName, int climbTime)
    {
    	peakName = this.peakName;
    	climbTime = this.climbTime;

    }

    /* @return - the name of the mountain peak
     */
     public String getName()
     {
     	return peakName;
     }

     /**@return  - the number of minutes taken to complete the climb
      */
      public int getTime()
      {
      	return climbTime;
      }




}
