public class Supervisior
{
	//precondition:  block in bag
	//postcondition: 1 Block on LOCATION (2 north of X) with the yellow face on top
	public void SCRIPT (String [] args)
	{
		count = 0;
		while (count <1)
		{
			supplyToB();
			if (Inspector.blockHasYellow(B) == true)
			{
				putYellowOnTop(B);
				Worker.move(EAST, 2);
				Worker.move(SOUTH, 2);
				Worker.release();
				Worker.move(SOUTH, 2);  //Returns worker to X
				count = count + 1 ;
		}

			else
		{
				Worker.move(EAST, 2);
				Worker.move(SOUTH , 4);
				worker.release();
				Supplier.remove();

		}
	}

		}


	//precondition: Bag has blocks, x and a have no blocks on them.
	//postcondition:Block on A
	public void supplyToA()
	{
		supplier.supply();
		Worker.grab();
		Worker.move(UP, 5);
		Worker.move(NORTH, 4);
		worker.move(WEST, 2);
	}

	//precondition: Bag has blocks, X and B have no blocks on them.
	//postcondition:Block on B
	public void supplyToB()
	{

		supplier.supply();
		Worker.grab();
		Worker.move(UP, 5);
		Worker.move(NORTH, 4);
		worker.move(EAST, 2);
	}


	//precondition: Block on whichArea (A or B)
	//postcondition:Block has color facing top
	public void putColorOnTop(whichArea){
		if (inspector.faceHasColor(whichArea, NORTH) == true )
			{
				worker.turnSouthToTop();
			}
		}

		if (inspector.faceHasColor(whichArea, WEST) == true )
			{
				worker.turnTopToEast();
			}
		}
/*-------------------------------------------------------------------------------*/
	//precondtion: Block has a yellow side
	//postcondition: Block will have yellow facing top
	public void putYellowOnTop(whichArea)
	{
		if (Inspector.faceIsYellow(whichArea, EAST) == true)
		{
			Worker.turnTopToEast();
			Worker.turnTopToEast();
			Worker.turnTopToEast();

			/* Another way
			 *Worker.turnEastToSouth();
			  Worker.turnSouthToTop();
			*/
		}


		if (Inspector.faceIsYellow(whichArea, WEST) == true)
		{
			Worker.turnTopToEast();
		}

		if (Inspector.faceIsYellow(whichArea, NORTH) == true)
		{
			Worker.turnTopToEast();
			Worker.turnTopToEast();
			Worker.turnTopToEast();
		}

		if (Inspector.faceIsYellow(whichArea, SOUTH) == true)
		{
			Worker.turnSouthToTop();
		}

		if (Inspector.faceIsYellow(whichArea, BOTTOM) == true)
		{
			Worker.turnTopToEast();
			Worker.turnTopToEast();
			/* Another way
			 Worker.turnSouthToTop();
			 Worker.turnSouthToTop();
			 */
		}
	}
}

//Precondition: Block on whichArea
//Postcondition : Output the color on any face of the block
	public void colorOnNorth(whichArea)
	{
		if (Inspector.faceHasColor(whichArea, whichFace) == true )
		{
			if(Inspector.faceIsRed(whichArea, whichFace) == true)
				System.out.println("The " + whichFace + "face is RED");
			else
				if (Inspector.faceIsGreen(whichArea, whichFace) == true)
					System.out.println("The " + whichFace + "face is GREEN");
				else
					if(Inspector.faceIsYellow(whichArea, whichFace) == true)
						System.out.println("The " + whichFace + "face is Yellow");
					else
						System.out.println("The " + whichFace + "face is BLUE");
		}
		else
			System.out.println("The " + whichFace + "face has no color on it");

	}

	public void colorOnTop
	{
	//precondition: Block on whichArea (A or B)
	//postcondition:Block has color facing top
		if (inspector.faceHasColor(whichArea, NORTH) == true )
			{
				worker.turnSouthToTop();
			}

		else
			if (inspector.faceHasColor(whichArea, WEST) == true )
				{
					worker.turnTopToEast();
				}
	}