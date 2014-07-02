//Example 5 : Strings

class Example5
{
	public static void main(String args[])
	{
		String test = "hello";
		System.out.println(test.toUpperCase());
		System.out.println(test.toLowerCase());
		System.out.println("Replace all e with u : "+test.replace('e','u'));
		System.out.println("substring : "+test.substring(0,3));
	}
}
