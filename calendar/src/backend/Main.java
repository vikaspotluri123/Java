package backend;
public class Main
{
	private gui.Main mainGUI;
	
	
	public Main()
	{
		mainGUI = new gui.Main(this);
	}
	
	public gui.Main getMainGUI()
	{
		return this.mainGUI;
	}
	
	public boolean hasMainGUI()
	{
		return mainGUI != null;
	}
	
	public void disposeMainGUI()
	{
		mainGUI.dispose();
		mainGUI = null;
		System.gc(); // We don't need to do this but since we don't need the mainGUI anymore, we should try to clean it up
	}
	public static void main(String [] args)
	{
		backend.Main e = new backend.Main();
		int i = -10;
		long ct = System.currentTimeMillis();
		while (i < 110)
		{
			e.getMainGUI().setProgressBarValue(i);
			while(System.currentTimeMillis() - ct < 75){}
			i++;
			ct = System.currentTimeMillis();
		}
		e.disposeMainGUI();
		System.exit(0);
	}

}
