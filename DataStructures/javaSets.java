//http://stackoverflow.com/questions/2490178/how-to-use-java-set

import java.util.*;

class javaSets
{
	public static void main(String args[])
	{
		Set<Integer> numbers = new TreeSet<Integer>();

		numbers.add(5);
		numbers.add(4);

		System.out.println(numbers);
		System.out.println(numbers.add(5));

		Set<Integer> numbers2  = new TreeSet<Integer>();
		numbers2.add(5);
		numbers2.add(6);
		numbers2.add(7);
		
		System.out.println(numbers2);

		Set<Integer> numbers3 = new TreeSet<Integer>(); //stpre union later

		numbers3.addAll(numbers);
		numbers3.addAll(numbers2);

		System.out.println(numbers3);
	}
}

/* Output : 

   [4, 5]
   false
   [5, 6, 7]
   [4, 5, 6, 7]

 */ 
