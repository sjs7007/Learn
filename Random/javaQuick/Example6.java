class Example6
{
	public static void main(String args[])
	{
		String s="10";

		//String to Integer Conversions

		//String to integer
		int n = Integer.parseInt(s); 
		System.out.println(s+ " in base 10 is : "+n);
		//String to integer by default has base 10 but you can give other bases like 2 for e.g.
		n = Integer.parseInt(s,2);
		System.out.println(s+" in base 2 is : "+n);


		//Character to string
		char c='A';
		s = Character.toString(c);

		//type casting 
		int cAscii = (int)(c);
		System.out.println(c+" typecasted to int : "+cAscii);

		//Integer to string
		String temp=Integer.toString(n);
		System.out.println(n+" in base 10 as string : "+temp);
		
		temp=Integer.toString(n,2);
		System.out.println(n+" in base 2 as string : "+temp);
	}
}
