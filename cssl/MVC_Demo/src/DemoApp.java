import javax.swing.SwingUtilities;


public class DemoApp
{
	private static Model myModel;
	private static View myView;
	private static Controller myController;
	
	private DemoApp()
	{
		myController = new Controller();
		myModel = new Model();
		myView = new View();
	}
	
	public static Model getModel() { return myModel; }
	public static View getView() { return myView; }
	public static Controller getController() { return myController; }
	
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable() {
			public void run() { new DemoApp(); }
		});
	}

}
