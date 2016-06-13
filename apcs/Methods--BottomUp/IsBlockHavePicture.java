//PreCondition: Block on A, 
//PostCondition: We know block has yellow on it
method IsBlockHavePicture()
	{ 
		if (inspector.faceHasPicture(A, TOP) ==true) 
		   		{worker.turnSouthToTop() ; }
		if (inspector.faceIsBlue(A, WEST) ==true) 
				{worke.turnEastToSouth(); }
	}