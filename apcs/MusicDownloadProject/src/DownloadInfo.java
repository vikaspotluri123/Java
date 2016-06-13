/*
 *A music web site keeps track of downloaded music.  For each download
 *the site uses a DownloadInfo object to store a song's title and the number of
 *times it has been downloaded.  Below is a declaration for the DownloadInfo class.
 *
 *
 *Complete the missing code.
 *
 */


public class DownloadInfo
{

	private String title;
	private int numberOfTimesDownloaded;


	/** Create a new instance with the given unique title
	 *and sets the number of downloaded times to 1.
	 *@param title the unique title of the downloaded song
	 */
    public DownloadInfo(String title)
    {
    	title = this.title;
    	numberOfTimesDownloaded =1;
    }

    //*returns the title
    public String getTitle()
    {
    	return title;
    }

    /*adds one to the numberOfTimesDownloaded instance variable
     *indicating that the song has been downloaded
     */
    public void incrementTimesDownloaded()
    {
    	numberOfTimesDownloaded ++;
    }


    /*returns a String version of the DownloadInfo object*/
     public String toString()
     {
     	return "Song name................." + title + "\n Number of times downloaded....................." + numberOfTimesDownloaded + "\n";
     }

}