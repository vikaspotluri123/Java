import java.util.*;

import static java.lang.System.*;

public class ShapeTester 
{

	public static void main(String[]  args)
	{
		Shape a = new Circle("circle",15);
		out.println(a);
		a = new Square("square",7);
		out.println(a);
	}
}
