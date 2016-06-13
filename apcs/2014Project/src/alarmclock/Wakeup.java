package alarmclock;
import bankaccount.*;
import bankaccountpeople.*;
import todo.*;
import _files.*;

import java.io.IOException;
import java.util.Date;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

// This is alarm class which plays music when the current
// time is equal to ore more than the alarm time

public class Wakeup
{
    Date wakeupTime;  // The calendar instance with time set to alarm time
    int audioFileIndex;   // Index of audio file to play for this alarm
    PlayMyMusic playMusic;  //music player class. This is created by GUI

    public Wakeup()  //Default Constructor
    {
       wakeupTime = null;
       audioFileIndex = -1;
       playMusic = null;
    }

    public Wakeup(int index, int year, int month, int date, int hour, int min) 
    {
         wakeupTime = new Date();
         audioFileIndex = index;
         playMusic = null;
    }

    public void setMyMusic(PlayMyMusic playMyMusic)
    {
       playMusic  = playMyMusic;
    }

    // if we are snoozed then we wait for 5 minutes. 
    // So, advance the alarm time by that much
    // and stop the sound
    
    public void setSnooze()
    {
       wakeupTime = new Date(System.currentTimeMillis()+5*60*1000);
       stopTheSound();
    }

    // Stop the alarm
    public void stopTheSound()
    {
        if(playMusic == null) 
           return;
        playMusic.stopAudioFile();
    }

    // Play the audio file
    public void playTheAudio()
    {
        if(playMusic == null) 
           return;
        try 
        {
			playMusic.playAudioFile(audioFileIndex);
		} 
        catch (UnsupportedAudioFileException | IOException| LineUnavailableException e) {//do nothing
			}
		}

    // The GUI will call this method
    // If it is time we return true.  
    //    Then the GUI need to loop the sound every few seconds
    // If it is not time, then the GUI will call this after 1 min to check if it is time
    // When the user selects stop then we stop playing the audio

    public boolean isItTime()
    {
        Date current = new Date();

        // If the alarm time is greater than or equal to present time that means
        // the alarm need to start playing the audio.

        if (wakeupTime.compareTo(current) >= 0 )
        {
            playTheAudio();
            return true;
        }
        return false;
    }
}

