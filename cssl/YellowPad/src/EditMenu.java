import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Iterator;
import java.util.ArrayList;
import javax.swing.JMenuItem;
import mickel.gui.EasyMenu;

public class EditMenu extends EasyMenu
{
	// FIELDS
	private EditorFrame myFrame;

	public static final long serialVersionUID = 0;	// Ignore this
	private JMenuItem undoMenu;
	private ArrayList<String> undo = new ArrayList<String>();

	// CONSTRUCTORS
	@SuppressWarnings("deprecation")
	public EditMenu(EditorFrame frame)
	{
		super("Edit");
		this.addMenuItem("Undo","doUndo");
		Iterator<JMenuItem> finder = this.getMenuList().keySet().iterator();
		boolean undoFound = false;
		while(finder.hasNext() && !(undoFound))
		{
			JMenuItem f = finder.next();
			if(f.getLabel() == "Undo")
			{
				undoMenu = f;
				undoFound = true;
			}
		}
		undoMenu.setEnabled(false);
		myFrame = frame;
		myFrame.getPane().addKeyListener(new KeyListener()
		{

			public void keyPressed(KeyEvent arg0) {}
			public void keyReleased(KeyEvent e)
			{
				if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_Z)
				{
					doUndo();
					doUndo();
				}
				else
				{
					if(undo.isEmpty() || undo.get(undo.size()-1).compareTo(myFrame.getPane().getText()) != 0)
					{
						undo.add(myFrame.getPane().getText());
						if(undo.size() >= 100)
							undo.remove(0);
						undoMenu.setEnabled(true);
					}
				}
			}
			public void keyTyped(KeyEvent e){}
			
		});
	}

	// METHODS

	/** The operation to be performed if the user selects "Undo" from
	 *  the Edit menu:
	 *
	 *
	 */
	public void doUndo()
	{
		if(undo.size() > 0)
		{
			myFrame.getPane().setText(undo.remove(undo.size()-1));
			undoMenu.setEnabled(!undo.isEmpty());
		}
		else
			undoMenu.setEnabled(!undo.isEmpty());
	}
}
