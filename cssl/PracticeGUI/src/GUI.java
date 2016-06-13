import java.awt.Color;
import java.awt.Dimension;
//import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class GUI {

	private JFrame myFrame;
	private JButton myButton;
	private JButton myButton2;

	public GUI()
	{
		myFrame = new JFrame("Sample Button");
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setLocation(100,250);
		
		myButton = new JButton("Click to start");
		myButton2 = new JButton("Button #2");
		
		myButton.setSize(new Dimension(300,100));
		myButton.setPreferredSize(new Dimension(300,100));
		myButton.setMinimumSize(new Dimension(300,100));
		myButton.setMaximumSize(new Dimension(300,100));
		
		Box theBox = Box.createHorizontalBox();
		
		theBox.add(myButton);
		theBox.add(Box.createHorizontalStrut(100));
		theBox.add(myButton2);
		
		myFrame.add(theBox);
		
		myButton2.addMouseListener(new MouseListener()
		{
			public void mouseClicked(MouseEvent e)
			{
				
			}
			public void mouseEntered(MouseEvent arg0) 
			{
				int x = (int)(Math.random()*800);
				int y = (int)(Math.random()*800);
				myFrame.setLocation(x,y);
			 
			}
			public void mouseExited(MouseEvent arg0)
			{
				
			}
			public void mousePressed(MouseEvent arg0) 
			{
				
			}
			public void mouseReleased(MouseEvent arg0)
			{
				
			}
		});
		
		myButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (myButton.getText().equals("ON")) {
					myButton.setText("OFF");
					myButton.setForeground(new Color(200,0,0));
				}
				else
				{
					myButton.setText("ON");
					myButton.setForeground(new Color(0,200,0));
				}
			}
		});

		myFrame.pack();
		myFrame.setVisible(true);
	}

	public JButton getButton() { return myButton; }


	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable() {
			public void run() { new GUI(); }
		});
	}

}
