import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import net.miginfocom.swing.MigLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Iterator;


public class APPFRAMe extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5403541880502996691L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private Backend backend;
	private String stringBase = "TEAM ID \t  TEAM PASSWORD \t TEAM NAME\n\n";
	private JTextPane textPane;
	final JButton btnSearchForTeam;
	final JButton btnAddSchool;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					APPFRAMe frame = new APPFRAMe();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public String generateTeamText()
	{
		String text = this.stringBase;
		TreeMap<String, HashMap<String, String>> data = backend.getData();
		Iterator<String> iterator = data.keySet().iterator();
		while(iterator.hasNext())
		{
			String t = iterator.next();
			HashMap<String,String> v = data.get(t);
			text += v.get("id") + " \t  " + v.get("password") + " \t \t" + v.get("name") + "\n";
		}
		return text;
	}
	/**
	 * Create the frame.
	 */
	public APPFRAMe() {
		btnSearchForTeam = new JButton("Search for Team");
		btnAddSchool = new JButton("Add School");
		backend = new Backend();
		backend.loadTeams();
		backend.reloadAvailablePasswords();
		setResizable(false);
		setTitle("UIL Team Manager Version 1.1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 463, 319);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[262px][50px][111px]", "[119px][23px][23px]"));
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, "cell 0 0 3 1,grow");
		
		textPane = new JTextPane();
		textPane.setText(this.generateTeamText());
		textPane.setEditable(false);
		scrollPane.setViewportView(textPane);
		
		textField = new JTextField();
		contentPane.add(textField, "cell 0 1,growx,aligny center");
		textField.setColumns(10);
		
		
		btnSearchForTeam.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				HashMap<String,HashMap<String,String>> temp = backend.sortByName();
				HashMap<String,HashMap<String,String>> c = new HashMap<String,HashMap<String,String>>();
				Iterator<String> f = temp.keySet().iterator();
				while(f.hasNext())
				{
					String a  = f.next();
					if(a.toLowerCase().indexOf(textField.getText().toLowerCase()) > -1)
						c.put(a,temp.get(a));
				}
				new TeamWindow(c,backend,textField.getText().toLowerCase());
			}
		});
		contentPane.add(btnSearchForTeam, "cell 2 1,alignx center,aligny center");
		
		textField_1 = new JTextField();
		contentPane.add(textField_1, "cell 0 2,growx,aligny center");
		textField_1.setColumns(10);
		
		contentPane.add(btnAddSchool, "cell 2 2,alignx center,aligny center");
		btnAddSchool.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				if(!((textField_1.getText() == "") || (textField_1.getText() == " ") || (textField_1.getText() == "\n") || (textField_1.getText() == "\t")))
				{
					int i = 1;
					String schoolName = textField_1.getText();
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
					backend.save();
					textField_1.setText("");
					textPane.setText(generateTeamText());
				}
			}
		});
	}

}
