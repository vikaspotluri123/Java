/**
 * @(#)MyMusicListing.java
 *
 *
 * @author
 * @version 1.00 2014/1/28
 */
import java.util.*;



public class MyMusicListing {


    public static void main(String[] args)
    {
    	System.out.println("My Music Download Assignment");
		List <String> songs = new ArrayList<String>();
		songs.add("Upside Down");
		songs.add("Banana Pancakes");
		songs.add("Flake");
		songs.add("Broken");
		songs.add("People Watching");
		songs.add("Upside Down");
		songs.add("Questions");
		songs.add("Banana Pancakes");
		songs.add("Flake");
		songs.add("Broken");
		songs.add("Flake");


        MusicDownloads myDownloads = new MusicDownloads();
        myDownloads.updateDownloads(songs);
        System.out.println(myDownloads);

    }
}
