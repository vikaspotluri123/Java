import java.util.Stack;


/** TOWERS OF HANOI PUZZLE
 *
 *  LEGEND: In an ancient city in India, so the legend goes, monks in a
 *          temple were assigned to move a pile of 64 sacred disks from a
 *          pillar in one corner of the temple to another pillar in the
 *          center of the temple. The disks are fragile, so only one can
 *          be carried at a time. Likewise, a larger disk cannot be placed
 *          on top of a smaller disk or else they will break. To add to the
 *          monks' task, there is only one other pillar in the temple (in
 *          the opposite corner) that is sacred enough for a pile of disks
 *          to be placed there.
 *
 *          So, the monks start moving disks back and forth between the
 *          three pillars, always keeping each pile in order (largest on the
 *          bottom, smallest on the top). The legend is that, before the
 *          monks make the final move to complete the ultimate pile on the
 *          center pillar, the temple will turn to dust and the world will
 *          end. Is there any truth to this legend?
 *
 *    GOAL: Move all of the disks from the first peg to the center peg.
 *
 *   RULES: Only 1 disk may be moved at a time.
 *          No disk may be placed on top of a smaller disk.
 */
public class TowersOfHanoi
{
	// FIELDS
	// ----------------------------------------------------------------------
	private Stack<SacredDisk> a;		// 1st pillar of sacred disks
	private Stack<SacredDisk> b;		// 2nd pillar of sacred disks
	private Stack<SacredDisk> c;		// 3rd pillar of sacred disks
	
	
	// CONSTRUCTORS
	// ----------------------------------------------------------------------
	/** Initializes myPegA to have n sacred disks ranging from size 1 to n,
	 *  with the smaller disks on the top of the stack and the larger disks
	 *  on the bottom of the stack.  Initializes myPegB and myPegC to be
	 *  empty stacks.
	 */
	public TowersOfHanoi(int n)
	{
		a = new Stack<SacredDisk>();
		b = new Stack<SacredDisk>();
		c = new Stack<SacredDisk>();
		
		for (int i = n; i > 0; i--)
			a.push(new SacredDisk(i));
	}
	
	
	// METHODS
	// ----------------------------------------------------------------------
	/** precondition: All disks are stacked in ascending order on myPegA.
	 * postcondition: All disks are stacked in ascending order on myPegB.
	 *                Disks must be moved from one peg to another according
	 *                to the rules of the Towers of Hanoi puzzle.  Displays
	 *                the contents of the three pegs after each move of a
	 *                single disk. (HINT: You may write additional helper 
	 *                methods if necessary.)
	 */
	public void solve()
	{
		solve(a.size(), a,b,c);
	}
	public void solve(int n, Stack<SacredDisk> a, Stack<SacredDisk> b, Stack<SacredDisk> c)
	{
		if(n == 1)
			move(a,b);
		else
		{
			solve(n-1,a,c,b);
			solve(1,a,b,c);
			solve(n-1,c,b,a);
		}
	}
	private void move(Stack<SacredDisk> from, Stack<SacredDisk> to)
	{
		to.push(from.pop());
		System.out.println(toString());
	}
	/** precondition: myPegA, myPegB, and myPegC each contain 0 or more
	 *                disks.
	 * postcondition: Returns a String representation of the puzzle,
	 *                showing the current contents of each peg.
	 */
	public String toString()
	{
		String s = "";
		s += "A:" + a + "\n";
		s += "B:" + b + "\n";
		s += "C:" + c + "\n";
		return s;
	}
	
	
	/** Main method.  Instantiates and solves a Towers of Hanoi puzzle.
	 */
	public static void main(String[] args)
	{
		TowersOfHanoi t = new TowersOfHanoi(4);
		System.out.println("BEFORE...");
		System.out.println(t);

		t.solve();

		System.out.println("AFTER...");
		System.out.println(t);
	}
	
	
}

