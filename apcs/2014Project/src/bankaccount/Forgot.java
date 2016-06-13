package bankaccount;
import alarmclock.*;
import bankaccountpeople.*;
import todo.*;
import _files.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
public class Forgot extends JFrame
{
	private static final long serialVersionUID = -8271324946061160361L;
	private ArrayList<Person> people = new ArrayList<Person>();
	JLabel username = new JLabel("What is your email address?");
	JTextField user = new JTextField(15);
	JButton submit = new JButton("Submit");
	JPanel panel = new JPanel();
	public Forgot(ArrayList<Person> peoplse)
	{
		super("Forgot password | Bank of the Internet");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.add(username);
		panel.add(user);
		people = peoplse;
		panel.add(submit);
		setSize(200,120);
		add(panel);
		setButtons();
		setVisible(true);
	}
	public void setButtons()
	{
		submit.addActionListener(new ActionListener()
		{public void actionPerformed(ActionEvent arg0) {searchAndDestroy();}});
		user.addKeyListener(new KeyListener()
		{public void keyPressed(KeyEvent e){if(e.getKeyCode() ==10)searchAndDestroy();} public void keyReleased(KeyEvent e) {if(e.getKeyCode() ==10)searchAndDestroy();}	public void keyTyped(KeyEvent e) {if(e.getKeyCode() ==10)searchAndDestroy();}});
	}
	public void searchAndDestroy()
	{
		String email = user.getText();
		boolean finished = false;
		boolean containsAt = false;
		boolean containsDot = false;
		for(int i = 0 ; i < email.length(); i ++)
		{
			if(email.substring(i,i+1).equals("@"))
				containsAt = true;
			else if(email.substring(i,i+1).equals("."))
				containsDot = true;
		}
		
		if(!(containsAt&&containsDot))
		{
			JOptionPane.showMessageDialog(null,"Please enter a valid email address.");
			user.requestFocus();
			return;
		}
		for(int i = 0 ; i < people.size(); i++)
		{
			if(people.get(i).getUsername().equals(email))
			{
				ResetPass bank = new ResetPass(people,people.get(i).getUsername());
				bank.setAlwaysOnTop(true);
				finished = true;
				dispose();
			}
		}
		if(!finished)
		{
			JOptionPane.showMessageDialog(null,"The email address you entered does not exist in our system. Please try agian.");
			username.setText("");
		}
	}
	
}
