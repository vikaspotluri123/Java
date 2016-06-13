public class practice 
{
	public void stepOne()
	{
		int [] digits = {3,1,4,1,5,9};
		double var = 3.14159;
		stepTwo(digits,var);
		for(int k = 0 ; k < digits.length;k++)
			System.out.println(digits[k] +" ");
		System.out.print("#"+var);
	}
	public void stepTwo(int[]digits,double var)
	{
		digits = new int[5];
		var = 0.0;
		for(int x = 0 ; x < digits.length; x++)
			digits[x]=0;
	}
	public static void main(String [] args)
	{	
		stepOne();
	}
}
