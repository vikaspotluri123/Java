import java.util.*;


public class Tester {
	public static void main(String args[])
	{
		
		Scanner in= new Scanner(System.in);
		System.out.println("Enter Yes to start program"); 
		
		//String s=in.nextLine();
		 in.close();
		
		    ClothesLibrary pew= new ClothesLibrary();
		    
		    
			System.out.println("Do you want to add Clothes?");
			String b=in.nextLine();
				if(b.equalsIgnoreCase("Yes"))
				{	Clothing loyal= new Clothing(); 
					boolean addmore =true;
					while(addmore==true)
					{
						System.out.println("What is the name of the item?(include color and any other distinguishing features)");
						loyal.setItemName(in.nextLine());
						System.out.println("is it a shirt");
						String d= in.nextLine();
						if(d.equalsIgnoreCase("Yes"))
						{
							loyal.setShirt(true);
							System.out.println("Is it long sleeved?");
							
							String e=in.nextLine();
							if(e.equalsIgnoreCase("Yes"))
							{
								loyal.setSleeve(true);
							}
							System.out.println("Is it made of wool?");
							String f = in.nextLine();
							if(f.equalsIgnoreCase("Yes"))
							{
								loyal.setMaterial(true);
							}
							
							System.out.println("Is it thick?");
							String g = in.nextLine();
							if(g.equalsIgnoreCase("Yes"))
							{
								loyal.setThickness(true);
							}
							
						}
						else {
						System.out.println("Is it long sleeved?");
						String h= in.nextLine();
						if(h.equalsIgnoreCase("Yes"))
						{
							loyal.setSleeve(true);
						}
						System.out.println("Is it made of wool?");
						
						String i =in.nextLine(); 
						if(i.equalsIgnoreCase("Yes"))
						{
							loyal.setMaterial(true);
						}
						System.out.println("Is it thick?");
						String j=in.nextLine();
						if(j.equalsIgnoreCase("Yes"))
						{
							loyal.setThickness(true);
						}
						}
						pew.addClothing(loyal.getItemName(),loyal);
						System.out.println("You entered this item:" + loyal.getItemName());
						System.out.println("Do you want to add more items?");
						String k = in.nextLine();
						if(!k.equalsIgnoreCase("Yes"))
				{
							addmore = false; 
						}
						else
						{
							addmore= true;
						}
								
					}
			
					
				}
			
		 System.out.println("Do you want to remove any items?");
		 if(in.nextLine().equalsIgnoreCase("Yes"))
		 {
			boolean removemore=true;
			while(removemore==true)
			{
			 System.out.println("What is the item name of the Clothing Item you wish to remove?");
			 pew.removeClothing(in.nextLine());
			 System.out.println("Would you like to Remove more?");
			 if(!in.nextLine().equalsIgnoreCase("Yes"))
			 {
				 removemore=false;
			 }
			 else{ 
				 removemore=true;
			 }
			}
			 
		}
		System.out.println("Saving your Library");
		
		 System.out.println("Would You Like to View your Current Clothes Library?");
		 if(in.nextLine().equalsIgnoreCase("Yes"))
		 {
			 pew.printAllClothes();
		 }
		 System.out.println("Would you like to have the program start a reccomendation?");
		 if(in.nextLine().equalsIgnoreCase("Yes"))
				 {
			 			pew.compileData();
				 }
		 
	}
		
			
		}
	
	
