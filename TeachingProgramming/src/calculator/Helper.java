package calculator;
public class Helper
{

	/**
	 * We have already done this!
	 *
	 * Adds a and b together
	 *
	 * precondition: a is a number, b is a number
	 *	  algorithm: return the sum (+) of a and b
	 *
	 *@param a			Starting number
	 *@param b			How much to add to starting number
	 *@return sum	sum of a and b
	 */
	public static int add(int a, int b)
	{
		return a + b;
	}

	/** Returns the product of 2 numbers
	 *
	 *  precondition: a is a number, b is a number
	 *     algorithm: create an int called result. Set it to 0
	 *     			  while b > 0...
	 *     				add a to result
	 *     				decrement b. //comment why we need to do this.
	 *     			  return result
	 *
	 * @param a			Starting number
	 * @param b			What you are multiplying by
	 * @return product	product of a and b
	 */
	public static int slowMultiply(int a, int b)
	{
		int result = 0;
		while(b > 0)
		{
			result += a;
			b--;
		}
		return result;
	}

	/** Returns the product of 2 numbers
	 *
	 *  precondition: a is a number, b is a number
	 *     algorithm: return the product (*) of a and b
	 *
	 * @param a			Starting number
	 * @param b			What you are multiplying by
	 * @return product	product of a and b
	 */
	public static int fastMultiply(int a, int b)
	{
		return a * b;
	}

	/** Returns the product of 2 numbers
	 *
	 *  precondition: a is a number, b is a number
	 *     algorithm: return the product by using the fastMultiply method
	 *
	 * @param a			Starting number
	 * @param b			What you are multiplying by
	 * @return product	product of a and b
	 */
	public static int multiply(int a, int b)
	{
		return fastMultiply(a,b);
	}

	/** Returns the difference of 2 numbers
	 *
	 *  precondition: a is a number, b is a number
	 *     algorithm: return the difference (-) of a and b
	 *
	 * @param a			Starting number
	 * @param b			How much you are taking away from a
	 * @return difference	difference of a and b
	 */
	public static int subtract(int a, int b)
	{
		return a - b;
	}

	/** Returns the difference of 2 numbers
	 *
	 *  precondition: a is a number, b is a number
	 *     algorithm: if hardWay is true
	 *     				make b - (multiply b by -1)
	 *     				add a and b (using add method)
	 *     			  else
	 *     				use the other subtract method to subtract b from a
	 *
	 * @param a			Starting number
	 * @param b			What you are multiplying by
	 * @param hardWay	Tells you if you should do it the hard way
	 * @return difference	difference of a and b
	 */
	public static int subtract(int a, int b, boolean hardWay)
	{
		if(hardWay)
		{
			b = multiply(b,-1);
			return add(a,b);
		}
		return subtract(a,b);
	}

	/** Returns the quotient of 2 numbers
	 *
	 *  precondition: dividend is a number, divisor is a number
	 *     algorithm: cast (using (int)) the quotient (/) of dividend and divisor
	 *
	 * @param dividend		total number you have
	 * @param divider		how many groups to create
	 * @return quotient		how many in each group.
	 */
	public static int divide(int dividend, int divisor)
	{
		return (int)(dividend/divisor);
	}

	/** Returns the modulus of 2 numbers
	 *
	 *  precondition: a is a number, b is a number
	 *     algorithm: return modulus (%) of a and b
	 *
	 * @param dividend		total number you have
	 * @param divider		how many groups to create
	 * @return modulus		number remaining after equally splitting.
	 */
	public static int modulus(int dividend, int divisor)
	{
		return dividend % divisor;
	}

	/** Returns the quotient of 2 numbers
	 *
	 *  precondition: a is a number, b is a number
	 *     algorithm: create 2 variables (double) - decimial, integer
	 *     			  	where integer is the return value of divide
	 *     				and decimal is the return value of modulus
	 *     				then use the computer to divide decimal by the divisor
	 *     				return the sum of integer and decimal.
	 *
	 * @param dividend		total number you have
	 * @param divider		how many groups to create
	 * @return modulus		number remaining after equally splitting.
	 */
	public static double decimalDivide(int dividend, int divisor)
	{
		int integer = divide(dividend,divisor);
		double decimal = modulus(dividend,divisor);
		decimal /= divisor;
		return integer + decimal;
	}
	public static void main(String [] args){}
}
