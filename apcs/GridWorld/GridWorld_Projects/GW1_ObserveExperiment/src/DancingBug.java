import info.gridworld.actor.Bug; 
public class DancingBug extends Bug 
{ 
	private int[] turns; 
	private int currentStep; 
 
 public DancingBug(int[] turns) 
 { 
	 this.turns = turns; 
	 currentStep = 0; 
 } 
 
 public void turn(int times) 
 { 
	 for(int j = 1; j <= times; j++) 
	 { 
		 turn(); 
	 } 
 } 
 
 public void act() 
 { 
	 if(currentStep == turns.length) 
		 currentStep = 0; 
	 turn (turns[currentStep]); 
	 currentStep++; 
	 super.act(); 
 } 
}