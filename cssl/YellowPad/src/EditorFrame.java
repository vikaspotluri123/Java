import java.util.HashMap;
import java.util.Map;

import java.awt.*;
import javax.swing.*;


public class EditorFrame extends JFrame
{
	// FIELDS
	public static final Map<EditorPane ,EditorFrame> FRAMES
		= new HashMap<EditorPane, EditorFrame>();

	private EditorPane myPane;

	public static final long serialVersionUID = 0;	// Ignore this


	// CONSTRUCTOR
	public EditorFrame()
	{

		/* Sets the "Look-and-Feel" (LAF) for this GUI. This allows you to override
		 * the normal UI to specify one of the other "pre-built" LAFs or a custom
		 * designed LAF.
		 */
		try {
			String laf = UIManager.getSystemLookAndFeelClassName();/* Uncomment this line to see an example of a different Look-and-Feel
			laf = UIManager.getCrossPlatformLookAndFeelClassName();
//*/
			UIManager.setLookAndFeel(laf);
			//UIManager.setLookAndFeel ( "com.alee.laf.WebLookAndFeel" );
		} catch (Exception e) { e.printStackTrace(); System.out.println("ERROR: LookAndFeel"); }


		/* Configures all of the basic properties of the main window (e.g., title,
		 * size, position, color, default close operation, etc.
		 */
		this.setTitle("YellowPad");
		this.setPreferredSize(new Dimension(500, 600));
		this.setLocation(200, 50);
		this.setBackground(Color.WHITE);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// TODO: Change this


		/* Creates the primary component of this application (an EditorPane,
		 * which you will define elsewhere in this project) and wraps it in
		 * a scrollable frameset (Swing's JScrollPane).
		 */
		myPane = new EditorPane();
		this.add(new JScrollPane(myPane));

		FRAMES.put(myPane, this);


		/* Adds a menu bar to the application (using Swing's JMenuBar class).
		 * You will customize the actual JMenuBar elsewhere in this project
		 * by defining the EditorMenuBar class.
		 *
		 * Note that a referent to the EditorPane from above is passed to
		 * the menu bar's constructor since many of the menu items in the
		 * menu bar will need a way to refer to the actual content pane
		 * (i.e., EditorPane).
		 */
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(new FileMenu(this));
		menuBar.add(new EditMenu(this));
		this.setJMenuBar(menuBar);


		/* Finishes the initial configuration of this frame, forces the
		 * window and components to any pre-specified sizes, and finally
		 * displays the actual window.
		 */
		this.pack();
		this.setVisible(true);
	}


	// METHODS
	public EditorPane getPane() { return myPane; }
}
