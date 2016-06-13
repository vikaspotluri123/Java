import javax.swing.*;

import org.json.JSONException;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;


public class Dictionary_App 
{
	private Dictionary myDictionary;
	
	
	public Dictionary_App()
	{
		myDictionary = new Dictionary();
		
		final JFrame frame = new JFrame("Will Li's Slamjam Dicionary Extravaganza");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setPreferredSize(new Dimension(600, 400));
		frame.setLocation(400, 200);
		frame.setResizable(false);
		
		Box outerBox = Box.createHorizontalBox();
		frame.add(outerBox);
		
		Box leftBox = Box.createVerticalBox();
		Box rightBox = Box.createVerticalBox();
		outerBox.add(leftBox);
		outerBox.add(rightBox);
		
		// left box
		Box searchBox = Box.createHorizontalBox();
		JButton save = new JButton("save");
		JButton load = new JButton("load");
		
		final JTextField searchField = new JTextField();
		final JButton searchButton = new JButton("Find");
		
		Font font = new Font("Comic Sans MS", Font.BOLD, 24);
		searchField.setFont(font);
		
		searchBox.add(searchField);
		searchBox.add(searchButton);
		
		leftBox.add(searchBox);
		leftBox.add(Box.createVerticalStrut(275));
		leftBox.add(save);
		leftBox.add(load);
		
		//right box
		final JTextPane defPane = new JTextPane();
		JScrollPane scrollPane = new JScrollPane(defPane);
		rightBox.add(scrollPane);
		
		defPane.setEditable(false);		
		scrollPane.setPreferredSize(new Dimension(300, 150));
		
		Box addDefBox = Box.createHorizontalBox();
		rightBox.add(addDefBox);
				
		Box wordDefBox = Box.createVerticalBox();
		JButton addButton = new JButton("Add");
		
		addDefBox.add(wordDefBox);
		addDefBox.add(addButton);
		
		JTextField wordField = new JTextField();
		JTextField defField = new JTextField();
		wordDefBox.add(wordField);
		wordDefBox.add(defField);
		
		wordField.setMaximumSize(new Dimension(250, 30));
		defField.setMaximumSize(new Dimension(250, 30));
		wordField.setMinimumSize(new Dimension(250, 30));
		defField.setMinimumSize(new Dimension(250, 30));
		
		
		load.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				JFileChooser chooser = new JFileChooser(new File("."));
				int filename = chooser.showOpenDialog(frame);
				if(filename == JFileChooser.APPROVE_OPTION)
				{
				//	myDictionary.load(chooser.getSelectedFile().getAbsolutePath());
					JOptionPane.showMessageDialog(frame,"Loaded " + myDictionary.load(chooser.getSelectedFile().getAbsolutePath()) + " words into the dictionary");
				}
			}
			
		});
		
		save.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				JFileChooser chooser = new JFileChooser(new File("."));
				int filename = chooser.showSaveDialog(frame);
				if(filename == JFileChooser.APPROVE_OPTION)
				{
				//	myDictionary.load(chooser.getSelectedFile().getAbsolutePath());
					try {
						myDictionary.save(chooser.getSelectedFile().getAbsolutePath());
					} catch (FileNotFoundException | JSONException e1) {
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(frame,"Saved to "+ chooser.getSelectedFile().getAbsolutePath());
				}
			}
			
		});
		
		searchButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(myDictionary.contains(searchField.getText()))
				{
					try
					{
						ArrayList<String> words = myDictionary.lookup(searchField.getText());
						defPane.setText(defPane.getText()+"Definitions for the word \""+searchField.getText()+"\":\n\n");
						for(String a : words)
						{
							defPane.setText(defPane.getText()+"     "+a+"\n\n");
						}
						defPane.setText(defPane.getText()+"----------------------------------------- \n\n");
					}
					catch (JSONException e1){JOptionPane.showMessageDialog(frame,"ERROR: " + e1.getMessage());}
				}
				else
					JOptionPane.showMessageDialog(frame,"The word \"" + searchField.getText() + "\" does not exist.");
			}
		});
		searchField.addKeyListener(new KeyListener()
		{
			public void keyPressed(KeyEvent e) 
			{
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
					searchButton.doClick();
			}
			public void keyReleased(KeyEvent e){}
			public void keyTyped(KeyEvent e){}
		});
		frame.pack();
		frame.setVisible(true);
	}
	
	
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Dictionary_App();
			}});
	}
	
	
	
	

}
