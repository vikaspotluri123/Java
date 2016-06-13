package frontend;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.DefaultComboBoxModel;
import java.awt.Insets;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;

public class NewMessage {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the application.
	 */
	public NewMessage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(UIManager.getColor("Button.foreground"));
		frame.getContentPane().setBackground(UIManager.getColor("Button.foreground"));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblWhoDoYou = new JLabel("Who do you want to send the message to?");
		lblWhoDoYou.setForeground(UIManager.getColor("Button.highlight"));
		lblWhoDoYou.setBackground(UIManager.getColor("Button.foreground"));
		GridBagConstraints gbc_lblWhoDoYou = new GridBagConstraints();
		gbc_lblWhoDoYou.insets = new Insets(0, 0, 5, 0);
		gbc_lblWhoDoYou.gridx = 0;
		gbc_lblWhoDoYou.gridy = 1;
		frame.getContentPane().add(lblWhoDoYou, gbc_lblWhoDoYou);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.insets = new Insets(0, 0, 5, 0);
		gbc_horizontalStrut.anchor = GridBagConstraints.WEST;
		gbc_horizontalStrut.gridx = 0;
		gbc_horizontalStrut.gridy = 2;
		frame.getContentPane().add(horizontalStrut, gbc_horizontalStrut);
		
		final JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setForeground(UIManager.getColor("Button.background"));
		comboBox.setBackground(UIManager.getColor("Button.foreground"));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 0;
		gbc_comboBox.gridy = 3;
		frame.getContentPane().add(comboBox, gbc_comboBox);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setTitle("New Message | Random project name");
		frame.setVisible(true);
		comboBox.setModel(new DefaultComboBoxModel(new backend.BackEnd().getUsers().toArray()));
		
		JLabel lblOr = new JLabel("OR");
		lblOr.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblOr = new GridBagConstraints();
		gbc_lblOr.insets = new Insets(0, 0, 5, 0);
		gbc_lblOr.gridx = 0;
		gbc_lblOr.gridy = 4;
		frame.getContentPane().add(lblOr, gbc_lblOr);
		
		JLabel lblTypeInThe = new JLabel("Type in the username...");
		lblTypeInThe.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblTypeInThe = new GridBagConstraints();
		gbc_lblTypeInThe.insets = new Insets(0, 0, 5, 0);
		gbc_lblTypeInThe.gridx = 0;
		gbc_lblTypeInThe.gridy = 5;
		frame.getContentPane().add(lblTypeInThe, gbc_lblTypeInThe);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 0;
		gbc_textField_1.gridy = 6;
		frame.getContentPane().add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JLabel lblWhatMessageDo = new JLabel("What message do you want to send?");
		lblWhatMessageDo.setBackground(UIManager.getColor("CheckBox.focus"));
		lblWhatMessageDo.setForeground(UIManager.getColor("Button.disabledShadow"));
		GridBagConstraints gbc_lblWhatMessageDo = new GridBagConstraints();
		gbc_lblWhatMessageDo.insets = new Insets(0, 0, 5, 0);
		gbc_lblWhatMessageDo.gridx = 0;
		gbc_lblWhatMessageDo.gridy = 8;
		frame.getContentPane().add(lblWhatMessageDo, gbc_lblWhatMessageDo);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 9;
		frame.getContentPane().add(textField, gbc_textField);
		textField.setColumns(10);
		
		JButton btnSendMessag = new JButton("Send Message");
		btnSendMessag.setBackground(UIManager.getColor("Button.foreground"));
		GridBagConstraints gbc_btnSendMessag = new GridBagConstraints();
		gbc_btnSendMessag.gridx = 0;
		gbc_btnSendMessag.gridy = 11;
		frame.getContentPane().add(btnSendMessag, gbc_btnSendMessag);
		btnSendMessag.addMouseListener(new MouseListener()
		{
			public void mouseClicked(MouseEvent arg0)
			{
				System.out.println(textField.getText());
				if(textField.getText().length() >  0)
				{
					if(textField_1.getText().length() > 0)
					{
						new backend.BackEnd().addMessage(textField_1.getText(),textField.getText());
						JOptionPane.showMessageDialog(frame.getContentPane(),"Sent the message \n \"" + textField.getText() + "\" \n to "+ textField_1.getText());
					}
					else
					{
						new backend.BackEnd().addMessage(comboBox.getSelectedItem().toString(),textField_1.getText());
						JOptionPane.showMessageDialog(frame.getContentPane(),"Sent the message \n \"" + textField.getText() + "\" \n to "+ comboBox.getSelectedItem().toString());
					}
				}
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0){}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
		});
		String [] s = new String [1];
		s[0] = "No users!";
		if(comboBox.getModel().getSize() < 0)
			comboBox.setModel(new DefaultComboBoxModel<String>(s));
	}

}
