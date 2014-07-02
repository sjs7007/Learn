//Random stuff. Example 7

class Example7
{
	public static void main(String args[])
	{
		//Math stuff 

		int k=2;

		int n = (int)Math.pow(k,3); //actually returns double data type. Howevver typecasted to int to avoid precision error message.
		System.out.println(k+" raised to 3 is : "+n);

		double d = Math.sqrt(k);
		System.out.println("Square root of "+k+" is : "+d);

		//Say you only want to print 3 decimal points use below syntax
		System.out.printf("Square root of "+k+" is %.3f \n",d);

		d=Math.random();
		System.out.println("Random decimal in range [0,1) : "+d);

		System.out.println("Floor and ceil : "+Math.floor(d)+" "+Math.ceil(d));
	}
}
