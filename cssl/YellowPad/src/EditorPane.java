import javax.swing.*;
import java.awt.*;


public class EditorPane extends JTextPane
{
	// FIELDS
	/* A set of standard color values and dimensions to be used in drawing
	 * this actual contents of this EditorPane.
	 */
	public static final Color YELLOWPAD = new Color(255, 255, 100);
	public static final Color BLUELINE = new Color(100, 100, 255);
	public static final Color REDLINE = new Color(255, 100, 100);
	public static final int LEFTMARGIN = 75;

	public static final long serialVersionUID = 0;	// ignore this


	// CONSTRUCTORS
	public EditorPane()
	{
		Font f = new Font("Comic Sans MS", Font.PLAIN, 15);
		this.setFont(f);
		this.setBackground(new Color(0,0,0,0));


		/* SAMPLE: Elsewhere in this class, when you need to access or
		 * modify the text of this EditorPane, you can use the getText()
		 * and setText() methods as shown below.
		 *
		 * Note how the text is all one, single String (as opposed to
		 * multiple, individual lines of text). "New Line" characters ('\n')
		 * are used to terminate and separate different lines.
		 */
//		this.setText("This is a test...\n...and this is another test. :)");
//		String s = this.getText();
	}



	// METHODS
	/* This is the primary method of any GUI object for drawing the actual
	 * component on the screen. It is invoked automatically whenever the
	 * window/frame/component needs to be redrawn.
	 *
	 * Note the last line ("super.paint(g);"), which invokes the
	 * overridden version of the paint() method. This is important for
	 * ensuring that any superclass elements are drawn also. The call
	 * to super.paint(g) can be done before you do your drawing or after.
	 */
	public void paint(Graphics g)
	{
		/* FontMetrics allow you to measure the actual height/width of
		 * the String values that are to be drawn on the Graphics object (g).
		 * This is useful in determining alignment of Strings. Here, we are
		 * using it to determine how far apart to space the "ruled lines" on
		 * our simulated "paper".
		 */
		FontMetrics metrics = getComponentGraphics(g).getFontMetrics();
		int lineSpacing = metrics.getHeight();

		/* For setting the overall background color of a component, you must
		 * draw an actual rectangle in the desired color and spanning the
		 * entire dimensions of the component (i.e., upper-left corner is
		 * at 0,0 and the dimensions are determined by the getWidth() and
		 * getHeight() methods of this pane object).
		 */
		g.setColor(YELLOWPAD);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());


		/* Draws red margin lines and each of the horizontal, blue lines
		 * creating the appearance of a sheet of yellow, legal pad paper.
		 */
		g.setColor(REDLINE);
		g.drawLine(LEFTMARGIN -5, 0, LEFTMARGIN - 5, this.getHeight());
		g.drawLine(LEFTMARGIN, 0, LEFTMARGIN, this.getHeight());

		g.setColor(BLUELINE);
		for (int i = lineSpacing; i < this.getHeight(); i += lineSpacing)
		{
			g.drawLine(0, i, this.getWidth(), i);
		}

		/* Invokes the overridden version of this method to draw any
		 * additional elements that might be specified by the superclasses.
		 */
		super.paint(g);
	}



}
