//Vikas Potluri Block 5 Computer Science
public class RectangularPrism extends Solid
{
       
       private double base;
       private double height;
       private double width; 
       
       public RectangularPrism()
       {
               super("Rectangular Prism"); 
               base = 0;
               height =0;
               width=0; 
       }
       
       public RectangularPrism(String name, double base, double height, double width)
       {
       super(name);
       this.height = height;
       this.base = base;
       this.width=width; 
       }

       public RectangularPrism(String name)
       {
       super(name); 
       base = 0;
       height =0; 
       width =0; 
       }
       
       public double volume()
       {
       return base*width*height; 

       }
       
       public String toString()
       {
               return super.toString() + " I am a Rectangular Prism"; 
       }
}
 