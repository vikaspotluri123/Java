import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;


public class GradePredictorGUI {
	private JTextField C1N;
	private JTextField D1;
	private JTextField D2;
	private JTextField D3;
	private JTextField DN;
	private JTextField perFieldN;
	public GradePredictorGUI()
	{
		JFrame frame = new JFrame("Grade Predictor");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Box vBox = Box.createVerticalBox();
		JScrollPane wholep = new JScrollPane(vBox);
		frame.add(wholep);
		final Box CBox = Box.createVerticalBox();
		Box Category1 = Box.createVerticalBox();
		Box Category2 = Box.createVerticalBox();
		Box Category3 = Box.createVerticalBox();
		Box addCBox = Box.createHorizontalBox();
		vBox.add(CBox);
		CBox.add(Category1);
		CBox.add(Category2);
		CBox.add(Category3);
		vBox.add(addCBox);
		
		//Category1
		Box buttonBox1 = Box.createHorizontalBox();
		Box percentBox1 = Box.createHorizontalBox();
		final Box gradeBox1 = Box.createHorizontalBox();
		Category1.add(buttonBox1);
		Category1.add(percentBox1);
		Category1.add(gradeBox1);
			
			//buttonBox1
			JLabel C1 = new JLabel("Category 1");
			JTextField C1Field = new JTextField();
			JButton C1button = new JButton("Add Grade Space");
			buttonBox1.add(C1);
			buttonBox1.add(C1Field);
			buttonBox1.add(C1button);
			
			//percentBox1
			JLabel perLabel1 = new JLabel("Percent of total grade:");
			final JTextField perField1 = new JTextField();		
			percentBox1.add(perLabel1);
			percentBox1.add(perField1);
			
			//gradeBox1
			JLabel gradeLabel1 = new JLabel("Add grades here:");
			final JTextField C11 = new JTextField();
			gradeBox1.add(gradeLabel1);
			gradeBox1.add(C11);
			
		//Category2
		Box buttonBox2 = Box.createHorizontalBox();
		Box percentBox2 = Box.createHorizontalBox();
		final Box gradeBox2 = Box.createHorizontalBox();
		Category2.add(buttonBox2);
		Category2.add(percentBox2);
		Category2.add(gradeBox2);
			
			//buttonBox2
			JLabel C2 = new JLabel("Category 2");
			JTextField C2Field = new JTextField();
			JButton C2button = new JButton("Add Grade Space");
			buttonBox2.add(C2);
			buttonBox2.add(C2Field);
			buttonBox2.add(C2button);
			
			//percentBox2
			JLabel perLabel2 = new JLabel("Percent of total grade:");
			final JTextField perField2 = new JTextField();		
			percentBox2.add(perLabel2);
			percentBox2.add(perField2);
			
			//gradeBox2
			JLabel gradeLabel2 = new JLabel("Add grades here:");
			final JTextField C12 = new JTextField();
			gradeBox2.add(gradeLabel2);
			gradeBox2.add(C12);
			
		//Category3
		Box buttonBox3 = Box.createHorizontalBox();
		Box percentBox3 = Box.createHorizontalBox();
		final Box gradeBox3 = Box.createHorizontalBox();
		Category3.add(buttonBox3);
		Category3.add(percentBox3);
		Category3.add(gradeBox3);
			
			//buttonBox3
			JLabel C3 = new JLabel("Category 3");
			JTextField C3Field = new JTextField();
			JButton C3button = new JButton("Add Grade Space");
			buttonBox3.add(C3);
			buttonBox3.add(C3Field);
			buttonBox3.add(C3button);
			
			//percentBox3
			JLabel perLabel3 = new JLabel("Percent of total grade:");
			final JTextField perField3 = new JTextField();		
			percentBox3.add(perLabel3);
			percentBox3.add(perField3);
					
			//gradeBox3		
			JLabel gradeLabel3 = new JLabel("Add grades here:");
			final JTextField C13 = new JTextField();
			gradeBox3.add(gradeLabel3);
			gradeBox3.add(C13);
			
		//addCBox
		JButton addCButton = new JButton("Add Category");
		JButton SubmitButton = new JButton("Calculate Grade");
		final JTextArea resultArea = new JTextArea();
		resultArea.setPreferredSize(new Dimension(40, 40));
		addCBox.add(SubmitButton);
		addCBox.add(Box.createHorizontalStrut(100));
		addCBox.add(addCButton);
		addCBox.add(resultArea);
		
		C1button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				D1 = new JTextField();
				gradeBox1.add(D1);
				gradeBox1.revalidate();
			}
		});
		
		C2button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				D2 = new JTextField();
				gradeBox2.add(D2);
				gradeBox2.revalidate();
			}
		});
		
		C3button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				D3 = new JTextField();
				gradeBox3.add(D3);
				gradeBox3.revalidate();
			}
		});
		
		addCButton.addActionListener(new ActionListener()
		{
			int counter = 3;
			
			public void actionPerformed(ActionEvent e)
			{
				counter++;
				Box CategoryN = Box.createVerticalBox();
				CBox.add(CategoryN);
				
				Box buttonBoxN = Box.createHorizontalBox();
				Box percentBoxN = Box.createHorizontalBox();
				final Box gradeBoxN = Box.createHorizontalBox();
				CategoryN.add(buttonBoxN);
				CategoryN.add(gradeBoxN);
					
					//buttonBoxN
					JLabel CN = new JLabel("Category " + counter);
					JTextField CNField = new JTextField();
					JButton CNbutton = new JButton("Add Grade Space");
					buttonBoxN.add(CN);
					buttonBoxN.add(CNField);
					buttonBoxN.add(CNbutton);
					
					//percentBoxN
					JLabel perLabelN = new JLabel("Percent of total grade:");
					perFieldN = new JTextField();		
					percentBoxN.add(perLabelN);
					percentBoxN.add(perFieldN);
					
					//gradeBoxN
					JLabel gradeLabelN = new JLabel("Add grades here:");
					C1N = new JTextField();
					gradeBoxN.add(gradeLabelN);
					gradeBoxN.add(C1N);
					
					CNbutton.addActionListener(new ActionListener()
					{
						public void actionPerformed(ActionEvent e)
						{
							DN = new JTextField();
							gradeBoxN.add(DN);
							gradeBoxN.revalidate();
						}
					});
					
				CategoryN.revalidate();
			}
		});
		
		SubmitButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int x = Integer.parseInt(perField1.getText());
				int y = Integer.parseInt(perField2.getText());
				int z = Integer.parseInt(perField3.getText());
				int n = 0;
				try
				{
					n =Integer.parseInt(perFieldN.getText());
				}
				catch(Exception ECXaer39){}
				List<Integer> a = new ArrayList<Integer>();
				int a1 = Integer.parseInt(C11.getText());
				a.add(a1);
				int aN = 0;
				try
				{
					aN = Integer.parseInt(D1.getText());
				}
				catch(Exception fiae3){}
				a.add(aN);
				List<Integer> b = new ArrayList<Integer>();
				int b1 = Integer.parseInt(C12.getText());
				b.add(b1);
				int bN = 0;
				try
				{
					bN = Integer.parseInt(D2.getText());
				}
				catch(Exception ea2){}
				b.add(bN);
				List<Integer> c = new ArrayList<Integer>();
				int c1 = 0;
				try
				{
					c1 = Integer.parseInt(C13.getText());
				}
				catch(Exception e1){}
				c.add(c1);
				int cN = 0;
				try
				{
					cN = Integer.parseInt(D3.getText());
				}
				catch(Exception ee){}
				c.add(cN);
				
				List<Integer> d = new ArrayList<Integer>();
				int d1 = 0;
				try
				{
					d1 = Integer.parseInt(C1N.getText());
				}
				catch(Exception e1){}
				d.add(d1);
				int dN = 0;
				try
				{
					dN = Integer.parseInt(DN.getText());
				}
				catch(Exception e1){}
				d.add(dN);
				
				CategoryGradePredictor CGP1 = new CategoryGradePredictor(a, x);
				CategoryGradePredictor CGP2 = new CategoryGradePredictor(b, y);
				CategoryGradePredictor CGP3 = new CategoryGradePredictor(c, z);
				double grade = 0;
				if(d != null)
				{
					CategoryGradePredictor CGPN = new CategoryGradePredictor(d, n);
					grade = CGP1.calculateCategoryGrade() + CGP2.calculateCategoryGrade() + CGP3.calculateCategoryGrade() + CGPN.calculateCategoryGrade();
				}
				else
				{
					grade = CGP1.calculateCategoryGrade() + CGP2.calculateCategoryGrade() + CGP3.calculateCategoryGrade();
				}
				String grade2 = String.valueOf(grade);
				resultArea.setText(grade2);
			}
		});
		vBox.add(addCBox);
		vBox.revalidate();
		frame.pack();
		frame.setVisible(true);
		}
		public static void main(String[] args){
		{	
		SwingUtilities.invokeLater(new Runnable() {
		public void run() { new GradePredictorGUI(); }
		});
		}
	}
}
