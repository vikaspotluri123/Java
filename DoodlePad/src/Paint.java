import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Paint {

	JButton clearButton;
	JButton drawButton;
	
	DoodleArea doodleArea;
	ActionListener actionListener = new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == clearButton) {
				doodleArea.clear();
			} else if (e.getSource() == drawButton) {
				doodleArea.black();
			}
	};
	};

	
	public void initialize() {
		JFrame frame = new JFrame("Doodle Pad");
		Container content = frame.getContentPane();
		content.setLayout(new BorderLayout());
		final DoodleArea doodleArea = new DoodleArea();
		
		content.add(doodleArea, BorderLayout.CENTER);
		
		JPanel controls = new JPanel();
		
		JButton clearButton = new JButton("Clear");
		clearButton.addActionListener(actionListener);
		
		JButton drawButton = new JButton("Draw");
		clearButton.addActionListener(actionListener);
		
		
		
		controls.add(clearButton);
		controls.add(drawButton);
		
		
		content.add(controls,  BorderLayout.NORTH);
		
		frame.setSize(600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);	
	}
	
	public static void main(String[] args) {
		new Paint().initialize();
	}
}


	
