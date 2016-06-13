package GUI;
import java.awt.Color;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.Container;
import java.awt.Font;

import javax.swing.*;
public class Splash extends JWindow 
{
	private static final long serialVersionUID = -2492791064824814097L;
	private static JProgressBar progressBar = new JProgressBar();
	private double screenHeight = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	private double screenWidth =  Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	private GraphicsEnvironment dimensions = GraphicsEnvironment.getLocalGraphicsEnvironment();
    public Splash() 
    {
        Container container = getContentPane();
        container.setLayout(null);
        JPanel panel = new JPanel();
        panel.setBorder(new javax.swing.border.EtchedBorder());
        panel.setBackground(Color.magenta); //Option:Sets the color of the Splash background of the Text Panel
        panel.setBounds(10, 10, 348, 150);
        panel.setLayout(null);
        container.add(panel);
        JLabel label = new JLabel("Calendar");
        label.setFont(new Font("Verdana", Font.BOLD, 22));
        label.setBounds(120, 70, 280, 20);
        JLabel labelS = new JLabel("(c) 2014 by Vikas Potluri");
        labelS.setFont(new Font("Verdana", Font.PLAIN, 11));
        labelS.setBounds(110, 90, 280, 20);
        panel.add(label);
        panel.add(labelS);
        progressBar.setMaximum(50); //Option: Set the max length of the progress bar (depending on the content that needs to load)
        progressBar.setBounds(55, 180, 250, 15);
        container.add(progressBar);
        incrementBar(0);
        setBounds(dimensions.getMaximumWindowBounds().width/2,dimensions.getMaximumWindowBounds().height/2,0,0);
        setSize(370, 215);
        setVisible(true);
    }
    public void incrementBar(int step)
    {
    	progressBar.setValue(step);
    }
    public void toggleVisibility()
    {
    	if(this.isVisible())
    		this.setVisible(false);
    	else
    		this.setVisible(true);
    }
}