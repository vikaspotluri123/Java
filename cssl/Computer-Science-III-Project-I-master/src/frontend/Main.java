package frontend;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;

import javax.swing.UIManager;

import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Component;

import javax.swing.Box;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Main {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
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
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(UIManager.getColor("Button.disabledShadow"));
		frame.getContentPane().setBackground(UIManager.getColor("Button.foreground"));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblWelcomeBackUser = new JLabel("Welcome back, user");
		lblWelcomeBackUser.setForeground(Color.WHITE);
		lblWelcomeBackUser.setBackground(Color.BLACK);
		GridBagConstraints gbc_lblWelcomeBackUser = new GridBagConstraints();
		gbc_lblWelcomeBackUser.insets = new Insets(0, 0, 5, 0);
		gbc_lblWelcomeBackUser.gridx = 0;
		gbc_lblWelcomeBackUser.gridy = 1;
		frame.getContentPane().add(lblWelcomeBackUser, gbc_lblWelcomeBackUser);
		
		JLabel lblWhatDoYou = new JLabel("What do you want to do?");
		lblWhatDoYou.setBackground(Color.BLACK);
		lblWhatDoYou.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblWhatDoYou = new GridBagConstraints();
		gbc_lblWhatDoYou.insets = new Insets(0, 0, 5, 0);
		gbc_lblWhatDoYou.gridx = 0;
		gbc_lblWhatDoYou.gridy = 2;
		frame.getContentPane().add(lblWhatDoYou, gbc_lblWhatDoYou);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.insets = new Insets(0, 0, 5, 0);
		gbc_horizontalStrut.gridx = 0;
		gbc_horizontalStrut.gridy = 3;
		frame.getContentPane().add(horizontalStrut, gbc_horizontalStrut);
		
		JButton btnNewButton = new JButton("New Message");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0){
				new NewMessage();
			}
		});
		btnNewButton.setVerticalAlignment(SwingConstants.BOTTOM);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(UIManager.getColor("Button.light"));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 4;
		frame.getContentPane().add(btnNewButton, gbc_btnNewButton);
		
		JButton btnNewButton_1 = new JButton("View Messages");
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setBackground(UIManager.getColor("CheckBox.interiorBackground"));
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.gridx = 0;
		gbc_btnNewButton_1.gridy = 5;
		frame.getContentPane().add(btnNewButton_1, gbc_btnNewButton_1);
		frame.setTitle("Main Window | Random Application");
		btnNewButton_1.addMouseListener(new MouseListener()
		{
			public void mouseClicked(MouseEvent arg0)
			{
				new frontend.ViewMessages().main(null);;
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
		});
		frame.setVisible(true);
	}

}
