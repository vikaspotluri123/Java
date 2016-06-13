//PreCondition: Blocks are in bag and board is empty
//PostCondition:A tower is made and it is 2 blocks high.
Repeat class Make2Tower until count==2
class Make2Tower ()
	{	Supervisor.supplyToA() // Block is now placed on A 
		Inspector.blockHasYellowFace() //Block is yellow
		if {blockHasYellowFace==true 
						count +1 ;
						worker.move(EAST, 3)
						worker.move(SOUTH, 2)
						worker.release()
					}
		else {  worker.grab()
				worker.move(UP,9)
				worker.move(SOUTH, 5)
				worker.move(EAST, 2)
				supplier.remove()
				}
		system.out.println("Jail Release 777-7777")	
			}
			