

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JFileChooser;

import mickel.gui.EasyMenu;


public class FileMenu extends EasyMenu
{
	// FIELDS
	private EditorFrame myFrame;

	private File myFile;

	public static final long serialVersionUID = 0;	// Ignore this


	// CONSTRUCTORS
	public FileMenu(EditorFrame frame)
	{
		super("File");

		/* Use the helper method provided below to create each menu item.
		 */
		this.addMenuItem("New", "doNew");
		this.addMenuItem("Open...", "doOpen");
		this.addMenuItem("Save", "doSave");
		this.addMenuItem("Save As...", "doSaveAs");
		this.addMenuItem("Close", "doClose");
		this.addMenuItem("Exit", "doExit");


		myFrame = frame;

	}




	// METHODS

	/** The operation to be performed if the user selects "New" from
	 *  the File menu:
	 *
	 *  Instantiates a new EditorFrame.
	 */
	public void doNew()
	{
		new EditorFrame();
	}

	/** The operation to be performed if the user selects "Open..." from
	 *  the File menu:
	 *
	 *
	 */
	public void doOpen()
	{
		// use a FileChooser object (see JavaDocs) to select a File???
		// use a Scanner to read the contents of the file???
		// set the text of myPane to be the contents read from the file???
		
		/*FileChooser*/
		
		JFileChooser  chooser = new JFileChooser("..\\");
		int x = chooser.showOpenDialog(myFrame);
		if(x == JFileChooser.APPROVE_OPTION)
		{
			myFile = chooser.getSelectedFile();
			/*Scanner */
			try
			{
				FileInputStream reader = new FileInputStream(myFile);
				String text = "";
				while(reader.available() > 0)
				{
					text += String.valueOf((char)(reader.read()));
				}
				EditorFrame e = new EditorFrame();
				e.getPane().setText(text);
				reader.close();
			}
			catch(Exception e){System.out.println(e);}
		}

		System.out.println("open");
	}

	/** The operation to be performed if the user selects "Save" from
	 *  the File menu:
	 *
	 *
	 */
	public void doSave()
	{
		if(myFile == null)
			doSaveAs();
		else
		{
			PrintWriter p;
			try {
				myFile.createNewFile();
				p = new PrintWriter(myFile);
				p.write(myFrame.getPane().getText());
			} catch (FileNotFoundException e) {doSaveAs();} catch (IOException e) {e.printStackTrace();}
			
		}

	}

	/** The operation to be performed if the user selects "Save As..." from
	 *  the File menu:
	 *
	 *
	 */
	public void doSaveAs()
	{
		// use a FileChooser object (see JavaDocs) to select a File???
		// doSave()???

		JFileChooser  chooser = new JFileChooser("..\\");
		int x = chooser.showOpenDialog(myFrame);
		if(x == JFileChooser.APPROVE_OPTION)
		{
			myFile = chooser.getSelectedFile();
			doSave();
		}
	}

	/** The operation to be performed if the user selects "Close" from
	 *  the File menu:
	 *
	 *
	 */
	public void doClose()
	{
		// prompt to save, if necessary???
		// setVisible(false) the parent frame???

		System.out.println("close");
	}

	/** The operation to be performed if the user selects "Exit" from
	 *  the File menu:
	 *
	 *
	 */
	public void doExit()
	{
		// doClose() on all open windows (so that it will prompt for save)???
		System.exit(0);
	}




}
