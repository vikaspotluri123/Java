public class Sphere extends Solid

{
       
       private double radius;
       public Sphere( String name, double r)
       {
               super (name); 
               radius =r; 
       }

       public double volume()
       {
               return 4.0/3.0*Math.PI*(Math.pow(radius, 3)); 
       }
       public String toString()
       {
               return super.toString() + " I am a sphere"; 
       }

}
