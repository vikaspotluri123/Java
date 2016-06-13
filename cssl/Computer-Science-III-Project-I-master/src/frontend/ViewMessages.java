package frontend;

import java.awt.EventQueue;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.GridBagLayout;

import javax.swing.JComboBox;

import java.awt.GridBagConstraints;

import javax.swing.JButton;

import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ViewMessages {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewMessages window = new ViewMessages();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ViewMessages() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.getContentPane().setForeground(Color.WHITE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		final JComboBox comboBox = new JComboBox();
		if(new backend.BackEnd().getUsers().size() < 0)
		{
			JOptionPane.showMessageDialog(frame,"No Users to view messages from!");
			frame.dispose();
		}
		comboBox.setModel(new DefaultComboBoxModel(new backend.BackEnd().getUsers().toArray()));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 0;
		gbc_comboBox.gridy = 1;
		frame.getContentPane().add(comboBox, gbc_comboBox);
		
		JButton btnGo = new JButton("Go!");
		GridBagConstraints gbc_btnGo = new GridBagConstraints();
		gbc_btnGo.gridx = 0;
		gbc_btnGo.gridy = 4;
		frame.getContentPane().add(btnGo, gbc_btnGo);
		frame.setTitle("View Messages | Random Name");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		btnGo.addMouseListener(new MouseListener(){

			public void mouseClicked(MouseEvent arg0)
			{
				String username = comboBox.getSelectedItem().toString();
				List<String> e = new ArrayList<String>();
				try {e = new backend.BackEnd().getMessages(username);} catch (IOException e1) {}
				String g ="";
				for(String f : e)
				{
					g += f + "\n";
				}
				JOptionPane.showMessageDialog(frame,"Messages from "  + username + ": \n" + g);
			}

			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
			});
	}

}
