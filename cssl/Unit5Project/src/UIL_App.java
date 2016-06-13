import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;

public class UIL_App 
{
	private Backend backend;
	
	
	public UIL_App()
	{
		backend = new Backend();
		
		final JFrame frame = new JFrame("UIL Thing");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setPreferredSize(new Dimension(300,175));
		frame.setLocation(400, 200);
		frame.setResizable(false);
		frame.setVisible(true);
		Box outerBox = Box.createHorizontalBox();
		frame.add(outerBox);
		
		Box leftBox = Box.createVerticalBox();
		//Box rightBox = Box.createVerticalBox();
		outerBox.add(leftBox);
		//outerBox.add(rightBox);
		
		// left box
		Box searchBox = Box.createHorizontalBox();
		//J//Button save = new JButton("save");
		//JBu//tton load = new JButton("load");
		
		final JTextField searchField = new JTextField();
		final JButton searchButton = new JButton("Find teams!");
		
		Font font = new Font("Comic Sans MS", Font.BOLD, 24);
		searchField.setFont(font);
		
		searchBox.add(searchField);
		searchBox.add(searchButton);
		
		leftBox.add(searchBox);
		leftBox.add(Box.createVerticalStrut(50));
		//leftBox.add(save);
		//leftBox.add(load);
		
		//right box
		final JTextPane defPane = new JTextPane();
		//rightBox.add(scrollPane);
		
		defPane.setEditable(false);		
		//scrollPane.setPreferredSize(new Dimension(300, 150));
		
		Box addDefBox = Box.createHorizontalBox();
		final JLabel statusBox = new JLabel("Status");
		/*right*/leftBox.add(addDefBox);
		/*right*/leftBox.add(statusBox);
				
		Box wordDefBox = Box.createVerticalBox();
		JButton addButton = new JButton("Add School");
		
		addDefBox.add(wordDefBox);
		addDefBox.add(addButton);
		
		final JTextField wordField = new JTextField();
		wordDefBox.add(wordField);
		
		//wordField.setMaximumSize(new Dimension(100, 30));
		//wordField.setMinimumSize(new Dimension(100, 30));
		
		addButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				if(!((wordField.getText() == "") || (wordField.getText() == " ") || (wordField.getText() == "\n") || (wordField.getText() == "\t")))
				{
					statusBox.setText("Analyzing...");
					int i = 1;
					String schoolName = wordField.getText();
					boolean teamNameSet = ! backend.contains(schoolName);
					while(!teamNameSet)
					{
						if(backend.contains(schoolName + " #"+i))
							i++;
						else
						{
							schoolName = schoolName + " #"+i;
							teamNameSet = true;
						}
					}
					backend.addTeam("team"+(backend.getData().size()+1), backend.generatePassword(), schoolName);
					statusBox.setText("Updating...");
					backend.save();
					wordField.setText("");
					statusBox.setText("Ready");
				}
			}
		});
		
		searchButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				String text = searchButton.getText();
				ArrayList<String> matched = backend.startsWith(text);
				HashMap<String,HashMap<String,String>> temp = backend.sortByName();
				for(String m : matched)
				{
					
				}
			}
		});
		frame.pack();
		statusBox.setText("Loading data...");
		backend.reloadAvailablePasswords();
		backend.loadTeams();
		statusBox.setText("Ready");
	}
	
	
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new UIL_App();
			}});
	}
	
	
	
	

}
