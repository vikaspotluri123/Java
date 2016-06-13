package gui;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JSpinner;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Calendar
{

	private JFrame frmCalendarManager;
	private backend.Main backend;
	private JTable table;
	private JButton btnNewButton;
	private JButton button;
	private JPanel panel;
	private JLabel lblCurrentMonth;
	private JLabel lblCurrentYear;
	private JSpinner spinner;
	private JSpinner spinner_1;
	private JButton btnNewButton_1;
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenu mnEdit;
	private JMenu mnHelp;
	private JMenuItem mntmQuit;
	private JMenuItem mntmNew;
	private JMenuItem mntmSave;
	private JMenuItem mntmBackup;
	private JMenuItem mntmOpen;
	private JMenu mnExport;
	private JMenuItem mntmCsv;
	private JMenuItem mntmUndo;
	private JMenuItem mntmRedo;
	private JMenuItem mntmSelectMonth;
	private JMenuItem mntmDocumentation;
	private JMenuItem mntmCheckForUpdate;
	private JMenuItem mntmAbout;
	
	/**
	 * Create the application.
	 */
	public Calendar(backend.Main backend)
	{
		initialize();
		this.backend = backend;
	}
	
	public backend.Main getBackend()
	{
		return this.backend;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCalendarManager = new JFrame();
		frmCalendarManager.setTitle("Calendar Manager");
		frmCalendarManager.setBounds(100, 100, 552, 547);
		frmCalendarManager.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCalendarManager.getContentPane().setLayout(new MigLayout("", "[][][grow][][]", "[][grow][][grow]"));
		
		table = new JTable();
		table.setRowSelectionAllowed(false);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}
		));
		for(int i = 0 ; i < table.getColumnCount(); i++)
		{
			table.getColumnModel().getColumn(i).setWidth(150);
			table.getColumnModel().getColumn(i).setMaxWidth(150);
			table.getColumnModel().getColumn(i).setMinWidth(150);
		}
		button = new JButton("<");
		frmCalendarManager.getContentPane().add(button, "cell 1 1");
		table.setRowHeight(75);
		JScrollPane e = new JScrollPane(table);
		frmCalendarManager.getContentPane().add(e, "flowx,cell 2 1,alignx center,aligny center");
		
		
		btnNewButton = new JButton(">");
		frmCalendarManager.getContentPane().add(btnNewButton, "cell 3 1");
		
		panel = new JPanel();
		frmCalendarManager.getContentPane().add(panel, "cell 2 2,grow");
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		lblCurrentMonth = new JLabel("Current Month");
		panel.add(lblCurrentMonth);
		
		lblCurrentYear = new JLabel("Current Year");
		panel.add(lblCurrentYear);
		
		spinner = new JSpinner();
		panel.add(spinner);
		
		spinner_1 = new JSpinner();
		panel.add(spinner_1);
		
		btnNewButton_1 = new JButton("Go");
		panel.add(btnNewButton_1);
		
		menuBar = new JMenuBar();
		frmCalendarManager.setJMenuBar(menuBar);
		
		mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		mntmNew = new JMenuItem("New");
		mnFile.add(mntmNew);
		
		mntmSave = new JMenuItem("Save");
		mnFile.add(mntmSave);
		
		mntmBackup = new JMenuItem("Backup");
		mnFile.add(mntmBackup);
		
		mntmOpen = new JMenuItem("Open");
		mnFile.add(mntmOpen);
		
		mnExport = new JMenu("Export");
		mnFile.add(mnExport);
		
		mntmCsv = new JMenuItem("CSV");
		mnExport.add(mntmCsv);
		
		mntmQuit = new JMenuItem("Quit");
		mnFile.add(mntmQuit);
		
		mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		
		mntmUndo = new JMenuItem("Undo");
		mnEdit.add(mntmUndo);
		
		mntmRedo = new JMenuItem("Redo");
		mnEdit.add(mntmRedo);
		
		mntmSelectMonth = new JMenuItem("Select Month...");
		mnEdit.add(mntmSelectMonth);
		
		mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		mntmDocumentation = new JMenuItem("Documentation");
		mnHelp.add(mntmDocumentation);
		
		mntmCheckForUpdate = new JMenuItem("Check for update");
		mnHelp.add(mntmCheckForUpdate);
		
		mntmAbout = new JMenuItem("About");
		mnHelp.add(mntmAbout);
	}

}
