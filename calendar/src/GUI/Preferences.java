package GUI;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
public class Preferences extends JPanel 
{
	private static final long serialVersionUID = 8952558434779358602L;
	private ArrayList<JPanel> panels = new ArrayList<JPanel>();
	private ArrayList<String> hTexts = new ArrayList<String>();
	private ArrayList<String> panelNames = new ArrayList<String>();
	public boolean ready = false;
    public Preferences() 
    {
        super(new GridLayout(1, 1));
        this.setSize(new Dimension(500,500));
        this.requestFocus();
        JTabbedPane tabbedPane = new JTabbedPane();
        setupArrays();
        if(panels.size() == hTexts.size() && panels.size() == panelNames.size())
        {
        	for(int i = 0 ; i < panels.size();i++)
        	{
        		tabbedPane.addTab(
        				panelNames.get(i),
        				null,
        				panels.get(i),
        				hTexts.get(i)
        				);
        	}
        }
        else
        {
        	System.out.println("Panels and help texts do not match...Please check calendar.GUI.Preferences.setupArrays()");
        }
        tabbedPane.setSize(new Dimension(500,500));
        add(tabbedPane);
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        ready = true;
    }
    private void setupArrays()
    {
    	panels.add(makeTextPanel("General"));
    	panels.get(0).setPreferredSize(new Dimension(450,600)); //Option: sets the size of the pane
        panels.add(makeTextPanel("Page 2"));
        panels.add(makeTextPanel("Page 3"));
        panels.add(makeTextPanel("Page 4"));
        hTexts.add("Manage General Preferences");
        hTexts.add("Page 2");
        hTexts.add("Page 3");
        hTexts.add("Page 4");
    }
    protected JPanel makeTextPanel(String text) 
    {
    	panelNames.add(text);
        JPanel panel = new JPanel(false);
        JLabel filler = new JLabel(text);
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(1, 1));
        panel.add(filler);
        return panel;
    }
    public void createAndShowGUI() 
    {
        JFrame frame = new JFrame("TabbedPaneDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Preferences(), BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }
}