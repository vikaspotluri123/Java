/**
 *The list of downloaded information is stored in a MusicDownloads object.
 *
 */

import java.util.*;


public class MusicDownloads
{

	/*The list of downloaded information.
	 *Guaranteed not to be null and not contain duplicate titles;
	 */
	private List <DownloadInfo> downloadList;


	/**Creates the list of downloaded information**/
    public MusicDownloads()
    {
    	downloadList = new ArrayList <DownloadInfo>();
    }



    /* Returns a reference to the DownloadInfo object with the requested title if it exists.
     *@param title  the requested title
     *@return a reference to the DownloadInfo object with the title
     *        that matches the parameter title if it exists in the list;
     *        null otherwise
     *
     *POSTCONDITION:  no changes were made to the downloadList
     */
    public DownloadInfo getDownloadInfo (String title)
    {

        for(int i = 0; i <downloadList.size();i++)
                if (title.equals(downloadList.get(i).getTitle()))
                        return downloadList.get(i);
        return null;
      }



   	/** Updates downloadList with information from titles.
   	 *@param   a list of song titles
   	 *
   	 *POSTCONDITION:
   	 * - there are no duplicate titles in downloadList
   	 * - no entries were removed from downloadList
   	 * - all songs in title are represented in downloadList
   	 * - for each existing entry in downloadList, the download count is increased b
   	 *    the number of times its title appeared in titles
   	 * - the order of the existing entries in downloadList is not changed
   	 * - the first time an object with title from titles is added to downloadList, it
   	 *    is added to the end of the list.
   	 * - new entries in downloadList appear in the same order in which
   	 *     they first appear in titles
   	 * - for each new entry in downloadList, the download count is equal
   	 *     to the number of times its title appears in  titles.
   	 */
    public void updateDownloads(List <String> titles)
    {          
            for(int i = 0; i < titles.size(); i ++)
            {
                    if (getDownloadInfo(titles.get(i)) != null)
                            getDownloadInfo(titles.get(i)).incrementTimesDownloaded();
                                                       
                    
                    else
                    downloadList.add(new DownloadInfo(titles.get(i)));
                                                                           
            }
    }
	/**returns a String version of the downloadList
	 */
	 public String toString()
	 {
		 return "" + downloadList.toString();
	 }


}