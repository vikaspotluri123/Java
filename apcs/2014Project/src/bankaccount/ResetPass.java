package bankaccount;
import alarmclock.*;
import bankaccountpeople.*;
import todo.*;
import _files.*;
import javax.swing.*;

import bankaccountpeople.Person;

import java.awt.event.*;
import java.util.ArrayList;
public class ResetPass extends JFrame
{
	private static final long serialVersionUID = 1L;
	private JPasswordField password = new JPasswordField(15);
	private JLabel passwordl = new JLabel("New password");
	private JPasswordField cpassword = new JPasswordField(15);
	private JLabel cpasswordl = new JLabel("Confirm new password");
	private JButton change = new JButton("Change password");
	private JTextField username = new JTextField(15);
	private JLabel usernamel = new JLabel("Username");
	private JPanel panel = new JPanel();
	private ArrayList<Person> people = new ArrayList<Person>();
	public ResetPass(ArrayList<Person> person)
	{	
		super("Reset password | Bank of the Internet");
		people = person;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cpasswordl.setBounds(0,0,100,100);
		usernamel.setBounds(200,200,100,100);
		setSize(200,250);
		panel.add(usernamel);
		panel.add(username);
		panel.add(passwordl);
		panel.add(password);
		panel.add(cpasswordl);
		panel.add(cpassword);
		panel.add(change);
		add(panel);
		setButton();
		setVisible(true);
		password.requestFocus();
	}
	public ResetPass(ArrayList<Person> person, String username)
	{	
		super("Reset password | Bank of the Internet");
		people = person;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cpasswordl.setBounds(0,0,100,100);
		usernamel.setBounds(200,200,100,100);
		setSize(200,250);
		this.username.setText(username);
		panel.add(usernamel);
		panel.add(this.username);
		panel.add(passwordl);
		panel.add(password);
		panel.add(cpasswordl);
		panel.add(cpassword);
		panel.add(change);
		add(panel);
		setButton();
		setVisible(true);
		password.requestFocusInWindow();
	}
	private void setButton()
	{
		change.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				setPassword();
			}
		});
	}
	@SuppressWarnings("deprecation")
	private void setPassword()
	{
		String username = this.username.getText();
		boolean passwordSet = false;
		String newPass = password.getText();
		String confirm = cpassword.getText();
		if(!newPass.equals(confirm))
		{JOptionPane.showMessageDialog(null,"Passwords do not match.");return;}
		else
		{
			for(int i = 0; i < people.size(); i++)
			{
				if(people.get(i).getUsername().equals(username))
					{
						people.get(i).setPassword(newPass);
						passwordSet = true;
						FileSaver save = new FileSaver(people);
						save.save();
					}
			}
		}
		if(!passwordSet)
			JOptionPane.showMessageDialog(null,"We couldn't set the password for you. Sorry. Please try again later.");
	}
}
