public class Inspector
{

	public boolean hasBlock(whichArea);

	public boolean faceHasLetter(whichArea, whichFace);
	public boolean faceHasNumber(whichArea, whichFace);
	public boolean faceHasPicture(whichArea, whichFace);
	public boolean faceHasColor(whichArea, whichFace);

	public boolean faceIsRed(whichArea, whichFace);
	public boolean faceIsGreen(whichArea, whichFace);
	public boolean faceIsBlue(whichArea, whichFace);
	public boolean faceIsYellow(whichArea, whichFace);

	public boolean faceIsUpsideDown(whichArea, whichFace);

//precondition: Block on whichArea
//postcondition: Returns true if block is yellow, returns false if block is not have yellow.
	public boolean blockHasYellow(whichArea)
	{
		if (faceIsYellow(whichArea, NORTH) == true)
			return true ;


		if (faceIsBlue(whichArea, NORTH) == true)
			return true ;


		if (faceIsYellow(whichArea, TOP) == true)
			return true ;


		if (faceIsBlue(whichArea, TOP) == true)
			return true ;


		if (faceIsYellow(whichArea, WEST) == true)
			return true ;


		if (faceIsBlue(whichArea, WEST) == true)
			return true ;


		return false ;
	}

//precondition: Block on whichArea
//postcondition: Returns true if block is Green , returns false if block is not have green.
	public boolean blockHasGreen(whichArea)
	{
		if (faceIsGreen(whichArea, NORTH) == true)
			return true ;


		if (faceIsRed(whichArea, NORTH) == true)
			return true ;


		if (faceIsGreen(whichArea, TOP) == true)
			return true ;


		if (faceIsRed(whichArea, TOP) == true)
			return true ;


		if (faceIsGreen(whichArea, WEST) == true)
			return true ;


		if (faceIsRed(whichArea, WEST) == true)
			return true ;


		return false ;
	}
/*
 ANOTHER WAY TO DO THE blockHasGreen
//precondition: Block on whichArea
//postcondition: Returns true if block is Green , returns false if block is not have green.
	public boolean blockHasGreen(whichArea)
	{
		if (blockHasYellow(whichArea) == true)
				return false ;

		return true ;
	}
*/

	public boolean blockHasBlue(whichArea)
	{
		if (blockHasYellow(whichArea) == true )
			return true ;

		return false;
	}


	public boolean blockHasRed(whichArea)
	{
		if (blockHasGreen(whichArea) == true )
			return true ;

		return false;
	}

}
