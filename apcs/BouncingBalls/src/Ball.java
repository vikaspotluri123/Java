


import mickel.anim.Sprite;
import mickel.image.ImageFile;
import mickel.io.*;
import static mickel.io.Key.*;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

import javax.swing.JOptionPane;

import mickel.audio.AudioFile;
import mickel.audio.AudioFile;

/** Represents a Ball that dynamically bounces around the interior
 *  of a rectangular Stage.
 */
public class Ball extends Sprite
{
	// FIELDS
	// ------------------------------------------------------------
	private int myPosX;		// X-coordinate of this Ball
	private int myPosY;		// Y-coordinate of this Ball

	private int myDirX;		// Horizontal speed of this Ball
	private int myDirY;		// Vertical speed of this Ball

	private int mySize;		// Diameter of this Ball
	private Color myColor;	// Color of this Ball
	
	private int actNumber;
	
	private boolean isActing = true; //Tells if the Balls are moving
	private boolean bounceAudio = false; //The boink sound.
	public String help = "KEYS: \n A: Increase size of balls \n B: Change background \n C: Change color \n D: Debug(disabled) \n H: Help \n M: Music only(no GUI) \n P: Play\\Pause the balls \n Q: Quit \n Z: Decrease ball size \n UP: Defy gravity \n DOWN: Increase the power of gravity \n LEFT: If the boink is on turn it off \n RIGHT: If the boink is off turn it on";
	AudioFile f = new AudioFile("boink.wav");
	static AudioFile backgroundMusic = new AudioFile("MontyPython.mp3");

	// CONSTRUCTORS
	// ------------------------------------------------------------
	/** Constructs a large, red Ball that is initially located in
	 *  the upper left corner of the screen.
	 *
	 *     algorithm: Assign mySize a value of 100.
	 *                Assign myPosX and myPosY a value of
	 *                  one half mySize plus one.
	 *                Assign myDirX a value of 2.
	 *                Assign myDirY a value of 1.
	 *                Assign myColor a Color value of RED.
	 */
	public Ball() {
		mySize  = 100;
		myPosX = 1/2 * mySize + 1;
		myPosY = 1/2 * mySize + 1;
		myDirX = 2;
		myDirY = 1;
		myColor = Color.RED;
		backgroundMusic.loop();
		}

	/** Constructs a small, green Ball that is initially centered
	 *  on a specified region of the screen.
	 *
	 *  precondition: width >= 0, height >= 0
	 *     algorithm: Assign mySize a value of 25.
	 *                Assign myPosX a value of half of width
	 *                Assign myPosY a value of half of height
	 *                Assign myDirX a value of -2.
	 *                Assign myDirY a value of 5.
	 *                Assign myColor a Color value of GREEN.
	 *
	 * @param width		Width of the stage
	 * @param height	Height of the stage
	 */
	public Ball(int width, int height) {
		mySize = 25;
		myPosX = 1/2 * mySize;
		myPosY = 1/2 * mySize;
		myDirX = -2;
		myDirY = 5;
		myColor = Color.GREEN;
	}

	/** Constructs a Ball that initially has the specified
	 *  location, size, and color.
	 *
	 *     algorithm: Assign mySize a value of size.
	 *                Assign myPosX the value of x.
	 *                Assign myPosY the value of y.
	 *                Assign myDirX the value of 3.
	 *                Assign myDirY the value of 3.
	 *                Assign myColor the value of c.
	 *
	 * @param x		The x-coordinate of this Ball's location
	 * @param y		The y-coordinate of this Ball's location
	 * @param size	The diameter of this Ball
	 * @param c		The Color of this Ball
	 */
	public Ball(int x, int y, int size, Color c) {
		mySize = size;
		myPosX = x;
		myPosY = y;
		myDirX = 3;
		myDirY = 3;
		myColor = c;
	}


	// METHODS
	// ------------------------------------------------------------
	/** Performs one frame of movement for this Ball object.
	 *
	 *  precondition:
	 * postcondition: The location of this Ball will be incremented
	 *                by one frame in its current direction of
	 *                movement. If the resulting location lies
	 *                beyond the boundaries of the Stage, this Ball's
	 *                direction will be adjusted accordingly to
	 *                reflect a "bounce".
	 *     algorithm: Increment myPosX by myDirX.
	 *                Increment myPosY by myDirY.
	 *                Declare an int variable w and initialize it
	 *                  with the value of the width of this Ball's
	 *                  Stage.
	 *                Declare an int variable h and initialize it
	 *                  with the value of the height of this Ball's
	 *                  Stage.
	 *                If the left edge of this Ball is less than 0
	 *                  and this Ball is moving left, negate the
	 *                  value of myDirX.
	 *                If the right edge of this Ball is greater than
	 *                  w and this Ball is moving right, negate the
	 *                  value of myDirX.
	 *                If the top edge of this Ball is less than 0
	 *                  and this Ball is moving up, negate the
	 *                  value of myDirY.
	 *                If the bottom edge of this Ball is greater than
	 *                  h and this Ball is moving down, negate the
	 *                  value of myDirY.
	 */
	public void act()
	{
		if(actNumber>=1000)
		{
			setBackgrounds();
			actNumber=0;
		}
		//TODO: Get more background images
		myPosX += myDirX;
		myPosY += myDirY;
		int w = this.getStage().getWidth();
		int h = this.getStage().getHeight();

		if(myPosX < 0 && myDirX <0) //Left Wall
		{
			myDirX *=-1;
			if(bounceAudio == true)
			{				
				f.play();
			}
		}
		else if( myPosX+mySize > w && myDirX >0) //right wall
		{
			myDirX *=-1;
			if(bounceAudio == true)
			{
				f.play();
			}
		}
		else if(myPosY < 0 && myDirY <0) //Top wall
		{
			myDirY *= -1;
			if(bounceAudio == true)
			{
				f.play();
			}
		}
		else if(myPosY+mySize >h && myDirY >0) //Bottom Wall
		{
			myDirY *= -1;
			if(bounceAudio == true)
			{
				f.play();
			}
		}
		actNumber++;
	}

	/** Draws a representation of the current state of this Ball
	 *  onto the graphics canvas, g.
	 *
	 *  precondition: g is the "canvas" of the Stage
	 * postcondition: Draws a representation of the current state
	 *                of this Ball onto the graphics canvas, g.
	 *     algorithm: Set the Color of g to be myColor.
	 *                Paint a filled oval onto g that is located at
	 *                  (myPosX, myPosY) with a width and height of
	 *                  mySize.
	 *
	 * @param g	The "canvas" on which this Ball is to be drawn.
	 */
	public void draw(Graphics2D g)
	{		
		g.setColor(myColor);
		g.fillOval(myPosX,myPosY,mySize,mySize);
	}


	/** Gets the boundaries of this Sprite.
	 *
	 * postcondition: Returns a Shape object that corresponds to the
	 *                characteristics used in the draw() method.
	 *     algorithm: Return a new Ellipse2D.Double object that uses
	 *                  myPosX and myPosY for the x and y parameters
	 *                  and mySize for the width and height parameters.
	 *
	 * @return   The Shape specifying the boundaries of this Sprite
	 */
	public Shape getShape()
	{
		return new Ellipse2D.Double(myPosX,myPosY,mySize,mySize);
	}
	
	public void setBackgrounds()
	{
		String backgrounds [] = new String [106];
		backgrounds[0]="0.jpg";
		backgrounds[1]="1.jpg";
		backgrounds[2]="2.jpg";
		backgrounds[3]="3.jpg";
		backgrounds[4]="4.jpg";
		backgrounds[5]="5.jpg";
		backgrounds[6]="6.jpg";
		backgrounds[7]="7.jpg";
		backgrounds[8]="8.jpg";
		backgrounds[9]="9.jpg";
		backgrounds[10]="10.jpg";
		backgrounds[11]="11.jpg";
		backgrounds[12]="12.jpg";
		backgrounds[13]="13.jpg";
		backgrounds[14]="14.jpg";
		backgrounds[15]="15.jpg";
		backgrounds[16]="16.jpg";
		backgrounds[17]="17.jpg";
		backgrounds[18]="18.jpg";
		backgrounds[19]="19.png";
		backgrounds[20]="20.jpg";
		backgrounds[21]="21.jpg";
		backgrounds[22]="22.jpg";
		backgrounds[23]="23.jpg";
		backgrounds[24]="24.jpg";
		backgrounds[25]="25.jpg";
		backgrounds[26]="26.jpg";
		backgrounds[27]="27.jpg";
		backgrounds[28]="28.jpg";
		backgrounds[29]="29.jpg";
		backgrounds[30]="30.jpg";
		backgrounds[31]="31.jpg";
		backgrounds[32]="32.jpg";
		backgrounds[33]="33.jpg";
		backgrounds[34]="34.jpg";
		backgrounds[35]="35.jpg";
		backgrounds[36]="36.jpg";
		backgrounds[37]="37.jpg";
		backgrounds[38]="38.jpg";
		backgrounds[39]="39.jpg";
		backgrounds[40]="40.jpg";
		backgrounds[41]="41.jpg";
		backgrounds[42]="42.jpg";
		backgrounds[43]="43.jpg";
		backgrounds[44]="44.jpg";
		backgrounds[45]="45.jpg";
		backgrounds[46]="46.jpg";
		backgrounds[47]="47.jpg";
		backgrounds[48]="48.jpg";
		backgrounds[49]="49.jpg";
		backgrounds[50]="50.jpg";
		backgrounds[51]="51.jpg";
		backgrounds[52]="52.jpg";
		backgrounds[53]="53.jpg";
		backgrounds[54]="54.jpg";
		backgrounds[55]="55.jpg";
		backgrounds[56]="56.jpg";
		backgrounds[57]="57.jpg";
		backgrounds[58]="58.jpg";
		backgrounds[59]="59.jpg";
		backgrounds[60]="60.jpg";
		backgrounds[61]="61.jpg";
		backgrounds[62]="62.jpg";
		backgrounds[63]="63.jpg";
		backgrounds[64]="64.jpg";
		backgrounds[65]="65.jpg";
		backgrounds[66]="66.jpg";
		backgrounds[67]="67.jpg";
		backgrounds[68]="68.jpg";
		backgrounds[69]="69.jpg";
		backgrounds[70]="70.jpg";
		backgrounds[71]="71.jpg";
		backgrounds[72]="72.jpg";
		backgrounds[73]="73.jpg";
		backgrounds[74]="74.jpg";
		backgrounds[75]="75.jpg";
		backgrounds[76]="76.jpg";
		backgrounds[77]="77.jpg";
		backgrounds[78]="78.jpg";
		backgrounds[79]="79.jpg";
		backgrounds[80]="80.jpg";
		backgrounds[81]="81.jpg";
		backgrounds[82]="82.jpg";
		backgrounds[83]="83.jpg";
		backgrounds[84]="84.jpg";
		backgrounds[85]="85.jpg";
		backgrounds[86]="86.jpg";
		backgrounds[87]="87.jpg";
		backgrounds[88]="88.jpg";
		backgrounds[89]="89.jpg";
		backgrounds[90]="90.jpg";
		backgrounds[91]="91.jpg";
		backgrounds[92]="92.jpg";
		backgrounds[93]="93.jpg";
		backgrounds[94]="94.jpg";
		backgrounds[95]="95.jpg";
		backgrounds[96]="96.jpg";
		backgrounds[97]="97.jpg";
		backgrounds[98]="98.jpg";
		backgrounds[99]="99.jpg";
		backgrounds[100]="100.jpg";
		backgrounds[101]="duke.png";
		backgrounds[102]="duke2.png";
		backgrounds[103]="duke11.png";
		backgrounds[104]="duke12.png";
		backgrounds[105]="duke13.png";
		int x = (int)(Math.random()*backgrounds.length);
		this.getStage().setBackground(new ImageFile(backgrounds[x]));
	}
	
	public void setMusic(int arrayNumber)
	{
		if(arrayNumber != -1)
		{
		String [] songs = new String [10];
		songs[0] = "electronic.mp3";
		songs[1] = "jaz.mp3";
		songs[2] = "general.mp3";
		songs[3] = "heavy_metal.mp3";
		songs[4] = "thrash_metal.mp3";
		songs[5] = "electronic.mp3";
		songs[6] = "hard_rock.mp3";
		songs[7] = "punk_rock.mp3";
		songs[8] = "rock_and_roll.mp3";
		songs[9] = "alternative (64).mp3";
		backgroundMusic.stop();
		backgroundMusic = new AudioFile(songs[arrayNumber]);
		backgroundMusic.play();
		}
		else 
		{
			backgroundMusic = new AudioFile("MontyPython.mp3");
			backgroundMusic.play();
			keyTyped(P);
		}
		
	}
	

	/* The following methods are event-handling methods that respond
	 * to keyboard events and mouse events. You may wish to experiment
	 * with these to add additional "user controls" for Ball objects.
	 */
	public void keyPressed (Key k) 
	{
		if(k == A)
			mySize++;
		else if (k==Z)
			mySize--;
		else if(k == DOWN)
		{
			myPosY=400-mySize;
		}
		else if (k == UP)
		{
			myPosY =0;
			backgroundMusic.stop();
			backgroundMusic = new AudioFile("general.mp3");
			backgroundMusic.play();
		}
		else if(k == LEFT)
		{
			bounceAudio = false;
		}
		else if(k == RIGHT)
		{
			bounceAudio = true;
		}
		else if(k == B)setBackgrounds();
		else if(k == C){myColor = randomColor();}
		else if(k == Q) System.exit(-1);
		else if(k == M)
		{
			this.getStage().dispose();
		}
		else if(k == O)
		{
			//getStage().setOpacity(JOptionPane.showInputDialog(null, "What is the opacity? They have to be floating numbers"));
		}
		else if(k == ONE)
		{
			setMusic(0);
		}
		else if(k == TWO)
		{
			setMusic(1);
		}
		else if(k == THREE)
		{
			setMusic(2);
		}
		else if(k == FOUR)
		{
			setMusic(3);
		}
		else if(k == FIVE)
		{
			setMusic(4);
		}
		else if(k == SIX)
		{
			setMusic(5);
		}
		else if(k == SEVEN)
		{
			setMusic(6);
		}
		else if(k == EIGHT)
		{
			setMusic(7);
		}
		else if(k == NINE)
		{
			setMusic(8);
		}
		else if(k == ZERO)
		{
			setMusic(9);
		}
		else if(k == G)
		{
			setMusic(-1);
		}
	}
	public Color randomColor()
	{
		return new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
	}
	public void keyReleased(Key k) 	{ if(k == H) JOptionPane.showMessageDialog(null, help);}
	public void keyTyped   (Key k) 
	{
		 if(k == P)
		{
			if(isActing == true)
			{
				this.getStage().stop();
				isActing = false;
			}
			else if (isActing == false)
			{
				this.getStage().start();
				isActing = true;
			}
		}
	//	else if(k == D)System.out.println(isActing+" "+x+" "+y);
	}
	public void mousePressed (int x, int y) {  myPosX=x; myPosY=y; }
	public void mouseReleased(int x, int y) { }
	public void mouseClicked (int x, int y) { myPosX = y; myPosY =x; }
	public void mouseMoved   (int x, int y) { myPosX=x; myPosY=y; }
	public void mouseDragged (int x, int y) { /* TODO: Insert code */ }
	public void mouseEntered (int x, int y) {  }
	public void mouseExited  (int x, int y) { getStage().add(new Ball(165,100,165,randomColor())); }
}
// random color generator:  c = new Color((int)(math.random()*255),(int)(math.random()*255),(int)(math.random()*255))