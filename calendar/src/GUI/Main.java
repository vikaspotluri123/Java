package gui;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.awt.Toolkit;


/**
 * 
 * @author Vikas Potluri
 * 
 * @category gui
 * 
 * 
 */
public class Main
{
	private JFrame frame;
	private backend.Main backend;
	private JProgressBar progressBar;
	/**
	 * Create the application.
	 */
	public Main(backend.Main backend)
	{
		this.backend = backend;
		initialize();
	}
	
	public backend.Main getBackend()
	{
		return backend;
	}

	/**
	 * Initialize the contents of the frame.
	 * @author Vikas Potluri
	 * 
	 * @return void
	 * 
	 * @param null
	 *
	 */
	private void initialize() 
	{
		int windowHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
		int windowWidth  = Toolkit.getDefaultToolkit().getScreenSize().width;
		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 100, 0));
		frame.setBounds((windowWidth / 2) - 300,(windowHeight / 2)-150, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);
		frame.setTitle("Calendar Manager");
		
		progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		frame.getContentPane().add(progressBar, BorderLayout.SOUTH);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 100, 0));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblCalendarManager = new JLabel("Calendar Manager");
		lblCalendarManager.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblCalendarManager.setForeground(new Color(255, 215, 0));
		GridBagConstraints gbc_lblCalendarManager = new GridBagConstraints();
		gbc_lblCalendarManager.anchor = GridBagConstraints.SOUTH;
		gbc_lblCalendarManager.insets = new Insets(0, 0, 5, 0);
		gbc_lblCalendarManager.gridx = 0;
		gbc_lblCalendarManager.gridy = 0;
		panel.add(lblCalendarManager, gbc_lblCalendarManager);
		
		JLabel lblByVikasPotluri = new JLabel("By Vikas Potluri");
		lblByVikasPotluri.setForeground(new Color(255, 215, 0));
		lblByVikasPotluri.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblByVikasPotluri = new GridBagConstraints();
		gbc_lblByVikasPotluri.anchor = GridBagConstraints.NORTH;
		gbc_lblByVikasPotluri.insets = new Insets(0, 0, 5, 0);
		gbc_lblByVikasPotluri.gridx = 0;
		gbc_lblByVikasPotluri.gridy = 1;
		panel.add(lblByVikasPotluri, gbc_lblByVikasPotluri);
		
		JLabel lblVersion = new JLabel("Version 1.1");
		lblVersion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblVersion.setForeground(new Color(255, 215, 0));
		GridBagConstraints gbc_lblVersion = new GridBagConstraints();
		gbc_lblVersion.anchor = GridBagConstraints.SOUTH;
		gbc_lblVersion.insets = new Insets(0, 0, 5, 0);
		gbc_lblVersion.gridx = 0;
		gbc_lblVersion.gridy = 2;
		panel.add(lblVersion, gbc_lblVersion);
		
		JLabel lblLoading = new JLabel("Loading");
		lblLoading.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLoading.setForeground(new Color(255, 215, 0));
		GridBagConstraints gbc_lblLoading = new GridBagConstraints();
		gbc_lblLoading.gridx = 0;
		gbc_lblLoading.gridy = 3;
		panel.add(lblLoading, gbc_lblLoading);
		frame.setVisible(true);
	}
	
	public void setProgressBarValue(int n)
	{
		progressBar.setValue(n);
	}
	public void dispose()
	{
		frame.dispose();
	}
}
