package alarmclock;
import bankaccount.*;
import bankaccountpeople.*;
import todo.*;
import _files.*;
import java.applet.AudioClip;
import java.awt.List;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

// This class keeps the collection of audio files
// These audio files are used for the alarm buzz
// The GUI keeps an instance of this class.

public class PlayMyMusic
{
    ArrayList audioFiles;  // List of audio files
    AudioClip audioClip ;  // Audio Clip handle

    public PlayMyMusic()  // Default constructor
    {
        audioFiles = null; // Initialize the audioFiles list to null
        try {
			audioClip = (AudioClip) AudioSystem.getClip();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    // This method is called from the GUI.  
    public PlayMyMusic (ArrayList audioFiles)
    {
       this.audioFiles = audioFiles; // Initialize the audioFiles list
       try {
		audioClip = (AudioClip) AudioSystem.getClip();
	} catch (LineUnavailableException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    }

    public void addAudioFile(String aFile)
    {
       audioFiles.add(aFile);  //  Add an audio file to the existing list of audio files
    }

    public void deleteAudioFile(String aFile)
    {
       audioFiles.remove(aFile);  //  remove an audio file from the existing list of audio files
    }

    public void stopAudioFile()
    {
        audioClip.stop();         // Stop the audio file.
    }

    // Plays an audio file.  The file list is already created and the files are on the server
    // User interface shows the files in a list.  The index of the list in GUI is same as the index
    // we have in our audioFile list.  So we take the index and open that audio file
    public void playAudioFile(int index) throws UnsupportedAudioFileException, IOException, LineUnavailableException
    {
         File soundFile = new File((String) audioFiles.get(index));
         AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
         ((Clip) audioClip).open(audioIn);
         ((DataLine) audioClip).start();
         audioClip.loop();
    }
}
