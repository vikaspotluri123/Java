import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

public class Temp extends JFrame
{
	private JPanel contentPane;
	private JTextField txtTeamName;
	private JTextField txtPassword;
	private JTextField txtName;
	private JTextField txtTeam;
	private JTextField txtPassword_1;
	private JTextField txtName_1;
	private JTextField txtDeleteThis;
	private Backend backend;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Temp frame = new Temp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Temp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		txtName = new JTextField();
		txtName.setText("ID");
		txtName.setEditable(false);
		contentPane.add(txtName, "2, 2, fill, default");
		txtName.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setText("Password");
		txtPassword.setEditable(false);
		contentPane.add(txtPassword, "4, 2, fill, default");
		txtPassword.setColumns(10);
		
		txtTeamName = new JTextField();
		txtTeamName.setText("Team Name");
		txtTeamName.setEditable(false);
		contentPane.add(txtTeamName, "6, 2, fill, default");
		txtTeamName.setColumns(10);
		
		txtDeleteThis = new JTextField();
		txtDeleteThis.setText("Delete this");
		txtDeleteThis.setEditable(false);
		contentPane.add(txtDeleteThis, "12, 2, fill, default");
		txtDeleteThis.setColumns(10);
		
		txtTeam = new JTextField();
		txtTeam.setText("team1");
		contentPane.add(txtTeam, "2, 4, fill, default");
		txtTeam.setColumns(10);
		
		txtPassword_1 = new JTextField();
		txtPassword_1.setText("password");
		contentPane.add(txtPassword_1, "4, 4, fill, default");
		txtPassword_1.setColumns(10);
		
		txtName_1 = new JTextField();
		txtName_1.setText("Name");
		contentPane.add(txtName_1, "6, 4, fill, default");
		txtName_1.setColumns(10);
		
		JButton btnDelete_1 = new JButton("DELETE");
		contentPane.add(btnDelete_1, "12, 4");
	}
}