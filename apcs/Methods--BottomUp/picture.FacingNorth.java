//PreCondition: Blocks are in bag and board is empty
//PostCondition:A tower is made and it is 2 blocks high.
Repeat class Make2Tower until count.right==2
class Make2Tower ()
	{	Supervisor.supplyToA() // Block is now placed on A 
		Inspector.isBlockHavePicture() //Block has a picture?
		if {isBlockHavePicture==true 
						count.right +1 ;
						worker.move(EAST, 2)
						worker.move(SOUTH, 3)
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
			