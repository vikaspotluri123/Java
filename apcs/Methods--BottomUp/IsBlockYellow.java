//PreCondition: Block on A, 
//PostCondition: We know block has yellow on it
method IsBlockYellow()
	{ 
		if (inspector.faceIsBlue(area, TOP) ==true) or 
		   (inspector.faceIsYellow(area,TOP) ==true)
				return true ;
		if (inspector.faceIsBlue(area, NORTH) ==true) or 
		   (inspector.faceIsYellow(area,NORTH) ==true)
				return true ; 
		if (inspector.faceIsBlue(area, WEST) ==true) or 
		   (inspector.faceIsYellow(area,WEST) ==true)
				return true ;
	}