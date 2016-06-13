package todo;
import javax.swing.*;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
public class EditTask extends JFrame 
{
	private String name;
	private String description;
	private boolean complete;
	private JButton save = new JButton("save");
	private JTextField nameEdit= new JTextField(15);
	private JTextField desc= new JTextField(50);	
	public EditTask(Task a)
	{
		super("Edit"+a.getName());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(250,250);
		name = a.getName();
		description = a.getDescription();
		complete = a.isFinished();
		init();
		setVisible(true);
	}
	private void init()
	{
		nameEdit.setText(name);
		desc.setText(description);
		save.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				work();
				JOptionPane.showMessageDialog(null,"task successfully saved. Returning to your tasks.");
				setVisible(false);
				todo.GUI gui = new todo.GUI();
				dispose();
			}
		});
		JPanel panel = new JPanel();
		panel.add(nameEdit);
		panel.add(desc);
		panel.add(save);
		add(panel);
	}
	private void work()
	{
		FileRemove a = new FileRemove(new Task(name,description,complete));
		FileAdd one = new FileAdd(nameEdit.getText(),desc.getText(),false);
	}
}
