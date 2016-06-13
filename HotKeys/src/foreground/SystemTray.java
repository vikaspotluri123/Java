package foreground;

import java.awt.AWTException;

public class SystemTray 
{
	private java.awt.SystemTray thisTray;
	
	public SystemTray()
	{
		thisTray = java.awt.SystemTray.getSystemTray();
	}
	
	public SystemTray(java.awt.SystemTray e)
	{
		thisTray = e;
	}
	
	public java.awt.SystemTray self()
	{
		return this.thisTray;
	}
	
	public void addSystemTray(java.awt.TrayIcon e)
	{
		try {thisTray.add(e);}
		catch (AWTException i) {Message.showMessage(null,"Error adding system tray icon" + i.getStackTrace());}
	}
	
	public void removeSystemTray(java.awt.TrayIcon e)
	{
		thisTray.remove(e);
	}
}
