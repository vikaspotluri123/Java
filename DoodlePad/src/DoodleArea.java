import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JComponent;

@SuppressWarnings("serial")
public class DoodleArea extends JComponent {

	private Image image;
	private Graphics2D g2;
	private int x;
	private int y;
	private int oldX;
	private int oldY;

	public DoodleArea(){
		setDoubleBuffered(false);
		
		addMouseListener(new MouseAdapter() {		

			public void mousePressed(MouseEvent e) {
					//save x,y coordinate when mouse is pressed
					oldX = e.getX();
					oldY = e.getY();
				}
		});
	
		addMouseMotionListener(new MouseMotionAdapter() {
			
			public void mouseDragged(MouseEvent e) {
				x = e.getX();
				y = e.getY();
				
				if(g2 != null) {
					g2.drawLine(oldX, oldY, x, y);
					repaint();
					oldX = x;
					oldY = y;
				}
			}
			
		});
		
	}
	
	protected void paintComponent(Graphics g) {
		if(image == null) {
			image = createImage(getSize().width, getSize().height);
			g2 = (Graphics2D)image.getGraphics();
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			
			clear();
		}
		
		g.drawImage(image, 0, 0, null);
	}
	
	public void clear() {
		g2.setPaint(Color.white);
		g2.fillRect(0, 0, getSize().width, getSize().height);
		g2.setPaint(Color.black);
		repaint();
	}
	
	public void black() {
		g2.setPaint(Color.black);
	}
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
