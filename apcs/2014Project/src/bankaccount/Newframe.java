package bankaccount;
import java.awt.GridLayout;
import javax.swing.*;
public class Newframe extends JFrame 
{
	JLabel welcome = new JLabel("Welcome to a New Frame");
	JPanel panel = new JPanel();
	JButton accountSettings = new JButton("Manage your account");
	JButton viewBalance = new JButton("View your balance");
	JButton addFunds = new JButton("Deopsit");
	JButton withdraw = new JButton("Withdraw");
	Newframe()	
	{
		super("Welcome");
		setSize(300,200);
		setLocation(500,280);
		setLayout(new GridLayout());
	}
}