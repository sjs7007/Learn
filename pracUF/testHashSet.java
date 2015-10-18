// http://www.tutorialspoint.com/java/java_hashset_class.htm

import java.util.*;

class testHashSet
{
	public static void main(String args[])
	{
		HashSet x = new HashSet();
		add(1,x);
		add(2,x);
		add(3,x);
		add(1,x);
		add(2,x);
		System.out.println(x);
	}

	public static void add(int x,HashSet hs)
	{
		if(!hs.contains(x))
		{
			hs.add(x);
		}
		else
		{
			System.out.println(x+" is already present. Not adding.");
		}
	}
}