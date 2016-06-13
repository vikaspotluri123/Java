package bankaccount;
//imports
import alarmclock.*;
import bankaccountpeople.*;
import todo.*;
import _files.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import javax.swing.*;
import java.util.ArrayList;
public class gui extends JFrame
{
	/*
	 * Global variables
	 * */
	//Login
	JButton blogin = new JButton("Login");
	JPanel panel = new JPanel();
	JLabel username = new JLabel("Username:");
	JLabel password = new JLabel("Password:");
	JButton forgot =  new JButton("Forgot Password");
	JTextField txuser = new JTextField(15);
	JPasswordField pass = new JPasswordField(15);
	boolean loggedIn = false;
	ArrayList<Person> people = new ArrayList<Person>(); //every single person in the bank
	//multi-use
	Person user;
	public gui()
	{
		super("Login Autentification");
		load();
		setAlwaysOnTop(true);
	}
	public void load()
	{
		JPanel load = new JPanel();
		JLabel username = new JLabel("Please wait wile BOIOS loads");
		username.setBounds(150,100,10,0);
		setSize(300,200);
		setLocation(500,280);
		panel.setLayout (null); 
		load.add(username);
		add(load);
		setVisible(true);
		init();
		remove(load);
	}
	public void init()
	{
		people = downloadFile();
		username.setBounds(35,30,75,20);
		txuser.setBounds(115,30,150,20);
		password.setBounds(35,65,75,20);
		pass.setBounds(115,65,150,20);
		blogin.setBounds(100,100,80,20);
		forgot.setBounds(70,125,140,20);
		add(forgot);
		panel.add(username);
		panel.add(password);
		panel.add(blogin);
		panel.add(txuser);
		panel.add(pass);
		try {UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");} catch (ClassNotFoundException | InstantiationException| IllegalAccessException | UnsupportedLookAndFeelException e) {e.printStackTrace();}
		add(panel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setKeys();
	}
	public void setKeys()
	{		
		blogin.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) {login();}
		});	
		pass.addKeyListener(new KeyListener()
		{
			public void keyPressed(KeyEvent e)
				{if(e.getKeyCode() == 10){login();}}
			public void keyReleased(KeyEvent e)
				{if(e.getKeyCode() == 10){login();}}
			public void keyTyped(KeyEvent e)
				{if(e.getKeyCode() == 10){login();}}
		});
		forgot.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {forgot();}
			
		});
	}
	public void forgot()
	{
		Forgot file = new Forgot(people);
		dispose();
	}
	@SuppressWarnings("deprecation")
	public void login()
	{
		{
			String puname = txuser.getText();
			String ppaswd = pass.getText();
			int validPerson = personExists(puname, ppaswd);
			if(puname.equals("test") && ppaswd.equals("12345") ||  validPerson != -1) 
			{
				if(!(validPerson != -1))
					user = new Client("Tester","1","Client",0L,0,0,0,"TEST","12345");
				else
				user = people.get(validPerson);
				Newframe loginSuccess = new Newframe("<html><center><p>Welcome,</p><br/><p> "+user.getUsername()+"   ("+user.getName()+")</p></center></html>");
				loginSuccess.setAlwaysOnTop(true);
				dispose();
				loggedIn = true;
			}
			else 
			{
				String error;
				if(validPerson == -1)
					error = "Incorrect credientials supplied";
				else error = "System error. Please try again";
				setAlwaysOnTop(false);
				JOptionPane.showMessageDialog(null,error);
				setAlwaysOnTop(true);
				txuser.setText(txuser.getText());
				pass.setText("");
				txuser.requestFocus();
			}				
		}
	}
	public int personExists(String a, String b)
	{
		for(int i = 0 ; i <people.size();i++)
		{
			if(a.equalsIgnoreCase(people.get(i).getUsername()))
			{
					if((people.get(i).getPassword().equals(b)))
							return i;
					else return -1;
			}
		}
		return -1;
	}
	public ArrayList<Person> downloadFile()
	{
		//general arrays to get everything started
		ArrayList<String> breaks = new ArrayList<String>(); // when there's a line break
		String local = ""; 									//temporary String
		//debug String a = ""; 								//full string
		//Used to make the array which contains 1 bit of info in every index
		ArrayList<String> vika = new ArrayList<String>();	 //the array with the bits and pieces
		String temp; 										// the full String with :
		String temp2;										 // 1 character to compare
		int until = 0; 										// lets us know where to start the substring
		boolean needToSkip = false; 						//skips over colons
		try													 //Required for File and FileInputStream classes
		{
			File reader = new File("src\\people.txt"); //Opens the file
			FileInputStream file = new FileInputStream(reader); 																//allows the file to be read
			int size = (int)reader.length();																					 //gets the size of the file, in bytes which are casted to ints
			for(int i = 0 ; i < size ; i++) //reads the file
			{	
				int fileReadOutput = file.read(); //the actual process of reading the file, gives a hex output
				char value = (char)(fileReadOutput); //converts the hex to a char
				if((fileReadOutput== 10)) //if the read is = int 10, enter in char
				{
					breaks.add(local); //add the string local, which is the the entire string before the add
					local = ""; //reinit local
				}
				else //otherwise...
				{
					//debug a += value;
					local += value; //add the character to the local var.
				}
			}
			file.close();//closes the file
		}
		catch(Exception e){	} //catches the problem
		for(int i = 0 ; i<breaks.size();i++) //for loop for splitting it up even mroe
		{
			temp = breaks.get(i); //get the string with colons
			until = 0; //default value of until
			needToSkip = false; //default value of needToSkip
			if(!needToSkip) // if needToSkip is false..
			{
				for(int j = 0; j < temp.length();j++) //for the length of the string temp
				{
					temp2 = temp.substring(j,j+1); //get the character
					if(temp2.equals(":") && until != j && until != j-1) //if it's a colon
					{
						vika.add(temp.substring(until,j)); //add a substring of everything up to the colon
						until = j+1; //we don't want the colon in the next array index
						needToSkip = true; //we don't want to run this after doing a colon
					}
				}
			}
			else //otherwise...
			{
				needToSkip = false; //skip over the next one
			}
		}
		/*
		 * Prereq: Each position has a fixed length, no matter what
		 * Post: in the arrayList people, every single person can be found, and we can get info about them.
		 * */
		for(int i = 0 ; i < vika.size(); i++)
		{
			switch(vika.get(i).toLowerCase()) //switch: checks the different types of people
			{
				case "manager": //If the type of person is a manager,...
				{
					people.add(new Manager(vika.get(i+1),vika.get(i+2),vika.get(i),Long.parseLong(vika.get(i+3)),vika.get(i+4),vika.get(i+5),Boolean.parseBoolean(vika.get(i+6))));
					if(i+6 < vika.size())
					i +=6;
					break;
				}
				
				case "bankteller":
				{
					people.add(new BankTeller(vika.get(i+1),vika.get(i+2),vika.get(i),Long.parseLong(vika.get(i+3)),vika.get(i+4),vika.get(i+5),Boolean.parseBoolean(vika.get(i+6))));
					if(i+6 < vika.size())
					i += 6;
					break; //vika.get(i+1),vika.get(i+2),vika.get(i),Long.parseLong(vika.get(i+3)),vika.get(i+4),vika.get(i+5),Boolean.parseBoolean(vika.get(i+6))
				}
				case "computer":
				{
					people.add(new Computer(vika.get(i+1),vika.get(i),Long.parseLong(vika.get(i+2)),vika.get(i+3),vika.get(i+4)));
					if(i+4 < vika.size())
					i +=4;
					break;
				}
				default:
				{
					people.add(new Person());
				}
			}
		}
		return people; 
	}     
}