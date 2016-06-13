//Vikas Potluri Block 5 Computer Science
import java.util.*;

import static java.lang.System.*;

public class SolidMain 
{

	public static void main(String [] args)
	{
		Solid shape;
		shape = new Sphere("Sphere",4);
		shape.toString();
		
		shape = new RectangularPrism();
		shape.toString();
		
		List <Solid> shapes = new ArrayList<Solid>();
		
		shapes.add(new Sphere("Sphere",1));
		shapes.add(0,new RectangularPrism());
		shapes.add(0,new Sphere("Sphere",2));
		
		for(int i =0 ; i < shapes.size();i++)
		{
			out.println(shapes.get(i));
		}
		
		shapes.set(0,new RectangularPrism());
		shapes.remove(2);
		out.println();
		
		for(Solid name : shapes)
		{
			out.println(name);
		}
		
		
	}
}
