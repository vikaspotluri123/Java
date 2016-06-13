import java.util.*;

		public class ArrayListManipulator
		{
			private List<Object> myData;
				
			public ArrayListManipulator(List<Object> data)
			{
				myData = data;
			}
			
			
		// METHODS...
			
			
			//  precondition: 
			// postcondition: Output the ArrayList using a for loop.
			public void output()
			{
				for (int i = 0 ; i < myData.size() ; i++)
					System.out.print(myData.get(i));
					System.out.println();
			}
			
			//  precondition: 
			// postcondition: Output the contents of the ArrayList in reverse order.
			//                The contents of the ArrayList are unchanged.
			public void outputReverse()
			{
				for (int i = myData.size()-1; i>=0  ;i--)
					System.out.print(myData.get(i));
					System.out.println();
					
			}	
			
			public void outputForEachLoop()
			{
				for (Object temp : myData)
					System.out.print(temp);
					System.out.println();
			}
			
			//  precondition: 'a' and 'b' are valid index positions in myData
			//                and a < b.
			// postcondition: Swaps the positions of the elements in index
			//                positions 'a' and 'b'.
			public void swap(int a, int b)
			{
				Object temp = myData.get(a);
	               myData.set(a, myData.get(b)); 
	               myData.set(b, temp); 
	       }

			
			
			//  precondition: 
			// postcondition: Reverses the order of all elements in the ArrayList
			public void reverse()
			{
				for (int i = 0 ; i < myData.size()/2 ; i++)
					swap(i , myData.size()-1-i);
			}

			
			//  precondition: 
			// postcondition: Shifts all elements left.  
			public void shiftLeft()
			{
				 for (int i =1; i < myData.size(); i++)
		             myData.set(i-1,myData.get(i));              
				
			}
			
			
			//  precondition: 
			// postcondition: Shifts all elements to the right. 
			public void shiftRight()
			{
				 for (int i = myData.size()-2; i>=0 ; i--)
                     myData.set(i+1, myData.get(i));
			}
			
			
			//  precondition: 
			// postcondition: Rotates all elements to the left.
			public void rotateLeft()
			{
				Object temp = myData.get(0);
	            shiftLeft();
	            myData.set(myData.size()-1, temp); 
			}
			
			
			//  precondition: 
			// postcondition: Rotates all elements to the right.
			public void rotateRight()
			{
				 	Object temp = myData.get(myData.size()-1);
		            shiftRight();
		            myData.set(0,temp); 
			}
			
			//  precondition: 'a' and 'b' are valid index positions in myData
			//                and a < b.
			// postcondition: Reverses the order of all elements from index
			//                positions 'a' through 'b'.
			public void reverse(int a, int b)
			{
				int average = (a + b)/2;
				for (int i = 0 ; i < average; i++)
					swap(i , myData.size()-1-i);
			}

			
			//  precondition: 'a' and 'b' are valid index positions in myData
			//                and a < b.
			// postcondition: Shifts all elements from index positions 'a'
			//                through 'b' 1 position to the left.  Index
			//                positions before 'a' and after 'b' should remain
			//                unchanged.
			public void shiftLeft(int a, int b)
			{
				int average = (a+b)/2;
				 for (int i = a+1; i < average; i++)
		             myData.set(i-1,myData.get(i));    
			}
			
			
			//  precondition: 'a' and 'b' are valid index positions in myData
			//                and a < b.
			// postcondition: Shifts all elements from index positions 'a'
			//                through 'b' 1 position to the right.  Index
			//                positions before 'a' and after 'b' should remain
			//                unchanged.
			public void shiftRight(int a, int b)
			{
				int average = (a+b)/2;
				 for (int i = average; i>=0 ; i--)
                     myData.set(i+1, myData.get(i));
			}
			
			
			//  precondition: 'a' and 'b' are valid index positions in myData
			//                and a < b.
			// postcondition: Rotates all elements from index positions 'a'
			//                through 'b' 1 position to the left.
			public void rotateLeft(int a, int b)
			{
				
			}
			
			
			//  precondition: 'a' and 'b' are valid index positions in myData
			//                and a < b.
			// postcondition: Rotates all elements from index positions 'a'
			//                through 'b' 1 position to the right.
			public void rotateRight(int a, int b)
			{
				
			}
			
				
			// postcondition: Traverses through the myData array and builds
			//                a String containing a comma-separated list of
			//                all elements in the myData arr	ay.
			public String toString()
			{		
				return myData.toString();
			}
			
			public static void main(String[] args)
			{
				System.out.println("ArrayList Testing");
				List <Object> myList = new ArrayList<Object>();
								
				myList.add("E");
				myList.add("S");
				myList.add("T");
				myList.add("W");
				myList.add("O");
				myList.add("O");
				myList.add("D");
				myList.add(0, "W");
				
				ArrayListManipulator tester = new ArrayListManipulator(myList);
				
				//System.out.println(tester);
				//tester.output();
				//tester.outputReverse();
				//tester.outputForEachLoop();
				//tester.swap(2,5);
				//tester.reverse();
				//tester.shiftLeft();
				//tester.shiftRight();
				//tester.rotateLeft();
				//tester.rotateRight();
				tester.reverse(1,5);
				tester.output();
				//add method tests to the main to test the methods as you go
				
			}
		}
