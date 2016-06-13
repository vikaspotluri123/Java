import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import java.awt.Component;

public class TeamWindow extends JFrame
{
	private static final long serialVersionUID = 6919351797360269783L;
	private JPanel contentPane;
	private static JTable table;
	private static Backend backend;
	private static String query; 
	/**
	 * Create the frame.
	 */
	public TeamWindow(HashMap<String,HashMap<String,String>> e,final Backend backend,String query)
	{
		TeamWindow.query = query;
		TeamWindow.backend = backend;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		table = new JTable();
		table.setFillsViewportHeight(true);
		int index = 0;
		Object[] [] f = new Object[e.size()][];
		Iterator<String> g = e.keySet().iterator();
		while(g.hasNext())
		{
			String h = g.next().toString();
			Object [] i = new Object[3];
			i[0] = e.get(h).get("id");
			i[1] = e.get(h).get("password");
			i[2] = e.get(h).get("name");
			//i[3] = "Delete " + e.get(h).get("id");
			f[index] = i;
			index++;
		}
		table.addKeyListener(new KeyListener()
		{
			public void keyPressed(KeyEvent arg0) {
				arg0.consume();
			}
			public void keyReleased(KeyEvent arg0) {
				arg0.consume();		
			}
			public void keyTyped(KeyEvent arg0) {
				arg0.consume();				
			}
		});
		table.setModel(new DefaultTableModel(f, new String[] {"id", "password", "name"/*,"delete"*/}));
		//table.getColumn("delete").setCellRenderer(new ButtonRenderer());
	    //table.getColumn("delete").setCellEditor(new ButtonEditor(new JCheckBox()));
	    //table.setRowHeight(40);
	    //table.setRowMargin(5);
	    contentPane.add(new JScrollPane(table), BorderLayout.CENTER);
		this.setVisible(true);
	}
	public boolean isCellEditable(int rowIndex, int columnIndex) {
	    return false;
	}
	public static boolean delete(String e)
	{
		e = e.toLowerCase().replace("delete ","").replace(" ","");
		try
		{
			int rowWithButton = -1;
			for(int i = 0 ; i < table.getRowCount(); i ++)
			{
				if(table.getValueAt(i,0).equals(e) || table.getValueAt(i,0).equals(e + " "))
				{
					rowWithButton = i;
					i = table.getRowCount();
				}
			}
			if(rowWithButton > 0)
				return tryToDelete(rowWithButton);
			JOptionPane.showMessageDialog(null,"Failed to find " + e);
			return false;
		}
		catch(Exception i3ii)
		{
			JOptionPane.showMessageDialog(null, "Error deleting " + e);
			return false;
		}
	}
	private static boolean tryToDelete(int row)
	{
		boolean delete = JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null,"Are you sure you want to delete the team with id " + table.getValueAt(row,0) + "?");
		if(delete)
		{
			backend.delete(table.getValueAt(row,0).toString());
		}
		return false;
	}
	class ButtonRenderer extends JButton implements TableCellRenderer
	{	
		private static final long serialVersionUID = 748998764668507275L;
		public ButtonRenderer() {setOpaque(true);}
		public Component getTableCellRendererComponent(JTable table, Object value,
				boolean isSelected, boolean hasFocus, int row, int column)
		{
			if (isSelected)
			{
				setForeground(table.getSelectionForeground());
				setBackground(table.getSelectionBackground());
			}
			else
			{
				setForeground(table.getForeground());
				setBackground(UIManager.getColor("Button.background"));
			}
			setText((value == null) ? "" : value.toString());
			return this;
		}
	}
	class ButtonEditor extends DefaultCellEditor
	{
		private static final long serialVersionUID = 1304122446076678617L;
		protected JButton button;
		private String label;
		private boolean isPushed;
		public ButtonEditor(JCheckBox checkBox)
		{
			super(checkBox);
			button = new JButton();
			button.setOpaque(true);
			button.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e) {fireEditingStopped();}
		    });
		}
		public Component getTableCellEditorComponent(JTable table, Object value,
				boolean isSelected, int row, int column)
		{
			if (isSelected)
			{
				button.setForeground(table.getSelectionForeground());
				button.setBackground(table.getSelectionBackground());
			}
			else
			{
				button.setForeground(table.getForeground());
				button.setBackground(table.getBackground());
			}
			label = (value == null) ? "" : value.toString();
			button.setText(label);
			isPushed = true;
			return button;
		}
		public Object getCellEditorValue()
		{
			if (isPushed)
			{
				TeamWindow.delete(button.getText());
				EventQueue.invokeLater(new Runnable(){public void run(){new APPFRAMe(); System.exit(-1);}});
			}
			isPushed = false;
			return label;
		}
		public boolean stopCellEditing() {isPushed = false;return super.stopCellEditing();}
		protected void fireEditingStopped() {super.fireEditingStopped();}
	}
}
