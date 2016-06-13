package main;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.melloware.jintellitype.JIntellitype;
import com.melloware.jintellitype.JIntellitypeConstants;

public class Runner
{
	final private TrayIcon tray;
	private Image trayImage;
	final private foreground.SystemTray sysTray;
	final private PopupMenu trayMenu;
	final MenuItem exitButton;
	
	public Runner()
	{
		try { trayImage = ImageIO.read(new File(".\\img\\icon.jpg"));}
		catch (IOException e) { foreground.Message.showMessage(null,"Exiting... Could not load tray image at "+ e.getStackTrace()); System.exit(0);}
		tray = new TrayIcon(trayImage);
		sysTray = new foreground.SystemTray();
		sysTray.addSystemTray(tray);
		trayMenu = new PopupMenu();
		exitButton = new MenuItem("Exit");
		trayMenu.add(exitButton);
		tray.setPopupMenu(trayMenu);
		tray.setImageAutoSize(true);
		tray.setToolTip("JHotKey");
		exitButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				System.exit(-1);
			}
		});
		
		
	}
	
	public static void main(String [] args)
	{
		Runner e = new Runner();
		System.out.println(System.getProperty("java.io.tmpdir"));
		System.out.print(JIntellitype.isJIntellitypeSupported());
		JIntellitype.getInstance();
		JIntellitype.getInstance().registerHotKey(1, JIntellitypeConstants.MOD_WIN,'w');
		JIntellitype.getInstance().addHotKeyListener(new background.HotKeyListener());
		JIntellitype.getInstance().cleanUp();
		e.getClass();
	}
}
