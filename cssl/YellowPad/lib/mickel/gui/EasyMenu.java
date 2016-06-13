package mickel.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.lang.IllegalAccessException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JMenu;
import javax.swing.JMenuItem;


public abstract class EasyMenu extends JMenu implements ActionListener
{
	// FIELDS
	private Map<JMenuItem, Method> myMenuItems;

	public static final long serialVersionUID = 0;	// Ignore this


	// CONSTRUCTORS
	public EasyMenu(String title)
	{
		super(title);

		myMenuItems = new HashMap<JMenuItem, Method>();
	}


	// METHODS
	/** Handles any events that this menu object is notified about. Whenever
	 *  the user selects any of the menu items, that item will trigger the
	 *  invocation of this method. The method then uses the Event's
	 *  getSource() method to determine which item triggered the event and
	 *  then invokes the appropriate helper method to perform the operation
	 *  chosen by the user.
	 *
	 * @param     evt      The event that is to be handled.
	 */
	public void actionPerformed(ActionEvent evt)
	{
		Object source = evt.getSource();

		for (JMenuItem item : myMenuItems.keySet())
		{
			if (source.equals(item))
			{
				try
				{
					myMenuItems.get(item).invoke(this, (Object[]) null);
				}
				catch (InvocationTargetException e) { e.printStackTrace(); }
				catch (IllegalAccessException e) { e.printStackTrace();}
				return;
			}
		}
	}
	public Map<JMenuItem, Method> getMenuList()
	{
		return myMenuItems;
	}
	/** Constructs and adds a menu item to this menu. Also adds this menu
	 *  object as an "ActionListener" for the menu item, so that when the
	 *  user selects the menu item, this class will be notified of the
	 *  event and will handle it.
	 *
	 * @param     text      The title of the menu item.
	 * @return    The JMenuItem that has been created and added to the menu.
	 */
	public void addMenuItem(String text, String methodName)
	{
		Method method  = null;
		try
		{
			Class<?> c = this.getClass();
			Class<?>[] args = null;
			method = c.getMethod(methodName, args);
		}
		catch (NoSuchMethodException e) { e.printStackTrace(); }

		JMenuItem item = new JMenuItem(text);
		item.addActionListener(this);
		this.add(item);

		myMenuItems.put(item, method);
	}

}
