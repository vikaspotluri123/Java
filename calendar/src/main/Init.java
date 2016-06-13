package main;
import java.util.ArrayList;
import java.util.prefs.Preferences;
import functions.Functions;
@SuppressWarnings("unused")
public class Init
{
	private boolean initialized;
	private long startTime;
	private long now;
	public Init() throws InterruptedException
	{
		GUI.Splash currentGui = new GUI.Splash();
		currentGui.setVisible(true);
		startTime = System.currentTimeMillis();
		initialized = checkInitialize();
		if(!initialized)
		{
			currentGui.incrementBar(25);
			/*while(now-startTime < 7000)
			{
				//Don't make the calendar load too quickly
				Thread.sleep(1);
				now = System.currentTimeMillis();
			}*/
			GUI.Preferences toLoad = new GUI.Preferences();
			while(!toLoad.ready)
			{
				//wait for the toLoad to load
			}
			currentGui.incrementBar(50);
			currentGui.dispose();
			toLoad.createAndShowGUI();
		}
		else
		{
			GUI.Calendar toLoad = new GUI.Calendar();
			currentGui.incrementBar(25);
			/*while(now-startTime < 10000)
			{
				//Don't make the calendar load too quickly
				Thread.sleep(1);
				now = System.currentTimeMillis();
			}*/
			while(!toLoad.ready)
			{
				//wait
			}
			currentGui.incrementBar(75);
			toLoad.createAndShowGUI();
			currentGui.dispose();
			toLoad.toggleVisiblity();
			toLoad.loop();
			
		}
	}
	private boolean checkInitialize()
	{
		Preferences prefs = Preferences.userNodeForPackage(Init.class);
		//TODO: put in proper preferences
		prefs.putBoolean("debug",true);
		if(prefs.getBoolean("debug", true))
			return true;
		return false;
	}
	public static void main(String[] args) throws InterruptedException 
	{
		Init a = new Init();
	}

}