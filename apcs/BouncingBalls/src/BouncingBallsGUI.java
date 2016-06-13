


import mickel.anim.Stage;

import mickel.image.ImageFile;

import java.awt.Color;

/** The primary GUI window of the BouncingBalls application.
 */
public class BouncingBallsGUI
{

	// FIELDS
	// ------------------------------------------------------------
	private Stage myStage;			// The base window for the app.
	public String help = "KEYS: \n A: Increase size of balls \n B: Change background \n C: Change color \n D: Debug(disabled) \n H: Help \n M: Music only(no GUI) \n P: Play\\Pause the balls \n Q: Quit \n Z: Decrease ball size \n UP: Defy gravity \n DOWN: Increase the power of gravity \n LEFT: If the boink is on turn it off \n RIGHT: If the boink is off turn it on";

	// CONSTRUCTORS
	// ------------------------------------------------------------
	/** Constructs and initializes each of the components for this
	 *  GUI window.
	 *
	 *  postcondition: The primary GUI window is initialized and
	 *                   its animation cycle is started.
	 *      algorithm: Initialize a new Stage to have a title of
	 *                   "Bouncing Balls", a width of 400, and a
	 *                   height of 400.
	 *                 Set the background of myStage to be a new
	 *                   Color of your choice, preferably with a
	 *                   low alpha value. For example, translucent
	 *                   orange would be new Color(200,100,0,66)
	 *                 Optionally, set the background of myStage
	 *                   to be an image (GIF, JPEG, or PNG)
	 *                   of your choice. For example, the Duke.png
	 *                   file has been provided for you. Construct
	 *                   it using new ImageFile("Duke.png")
	 *                 Set the location of myStage such that it
	 *                   will be centered on a 1280 x 1024 screen.
	 *                   HINT: Use a mathematical expression to
	 *                   automatically calculate the appropriate
	 *                   x and y coordinate the upper left corner
	 *                   of myStage.
	 *                 Invoke this object's addSprites() method.
	 *                 Tell myStage to open its window.
	 *                 Tell myStage to start its animation cycle.
	 * @throws InterruptedException 
	 */
	public BouncingBallsGUI()
	{
		myStage = new Stage("Bouncing Balls",400,400,250);
		myStage.setBackground(new Color(255,255,255,0));
		setBackgrounds();
		myStage.setLocation(100,100);
		addSprites(myStage);
		myStage.openWindow();
		myStage.start();
		myStage.setAlwaysOnTop(true);
		
		System.out.println(help);
	}
	
		// the Thread.sleep doesn't work because it causes a whit window.

	// METHODS
	// ------------------------------------------------------------
	/** Constructs and adds multiple Ball objects to the Stage.
	 *
	 *  postcondition: Constructs and adds one Ball object for each
	 *                   of the 3 Ball constructors to the Stage.
	 *      algorithm: Declare a Ball variable called b1 and assign
	 *                   to it a new Ball object with no parameters.
	 *                 Declare a Ball variable called b2 and assign
	 *                   to it a new Ball object with 2 specific
	 *                   parameters (width and height of myStage).
	 *                 Declare a Ball variable called b3 and assign
	 *                   to it a new Ball object with 4 specific
	 *                   parameters (x-location, y-location, size,
	 *                   color) of your choice and add it to myStage.
	 *                 Add b1 to myStage.
	 *                 Add b2 to myStage.
	 *                 Add b3 to myStage.
	 * @param myStage2 
	 */
	private void addSprites(Stage myStage2)
	{
		Ball b1 = new Ball();
		Ball b2 = new Ball(myStage2.getHeight(),myStage.getWidth());
		Ball b3 = new Ball(165,165,100,Color.red);
		
		myStage2.add(b1);
		myStage2.add(b2);
		myStage2.add(b3);
		
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
		myStage.setBackground(new ImageFile(backgrounds[x]));
	}

}
