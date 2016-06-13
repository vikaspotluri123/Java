//PreCondition: Nothing on A or X. Blocks are in the bag
//PostCondition: Block on A
method SupplyToA()
	{	Supplier.Supply();
		Worker.grab();
		Worker.move(UP,10) //This is to make sure that the block doesn't run into any towwers
		Worker.move(WEST,2);
		Worker.move(NORTH,4);	
		}