//http://stackoverflow.com/questions/2490178/how-to-use-java-set

import java.util.*;

class javaSets
{
	public static void main(String args[])
	{
		TreeSet<Integer> numbers = new TreeSet<Integer>();

		numbers.add(5);
		numbers.add(4);

		System.out.println(numbers);
		System.out.println(numbers.add(5));

		TreeSet<Integer> numbers2  = new TreeSet<Integer>();
		numbers2.add(5);
		numbers2.add(6);
		numbers2.add(7);
		
		TreeSet<Integer> numbers23  = new TreeSet<Integer>();
		numbers23.add(5);
		numbers23.add(6);

		System.out.print(numbers2.containsAll(Arrays.asList(numbers23.toArray())));
		//use above to checki if subset

		System.out.println(numbers2);

		TreeSet<Integer> numbers3 = new TreeSet<Integer>(); //stpre union later

		numbers3.addAll(numbers);
		numbers3.addAll(numbers2);

		System.out.println(numbers3);

		//union of set arrays
		System.out.println("Unions");

		ArrayList<TreeSet<Integer>> setList = new ArrayList<TreeSet<Integer>>();
		setList.add(new TreeSet<Integer>(Arrays.asList(1,2)));
		setList.add(new TreeSet<Integer>(Arrays.asList(2,3)));
		setList.add(new TreeSet<Integer>(Arrays.asList(2,5)));
		setList.add(new TreeSet<Integer>(Arrays.asList(3,5)));

		ArrayList<TreeSet<Integer>> setSet = new ArrayList<TreeSet<Integer>>();
	//	setSet.add(numbers);
	//	setSet.add(numbers2);
		for(int i=0;i<4;i++)
		{
			for(int j=i+1;j<4;j++)
			{
				TreeSet<Integer> temp = new TreeSet<Integer>();
				temp.addAll(setList.get(i));
				temp.addAll(setList.get(j));
				if(temp.size()==3)
				{
					System.out.println(temp);
				//	setSet.add(temp);
					if(!setSet.contains(temp))
					{
						setSet.add(temp);
					}
				}
			}
		}
		System.out.println(setSet);
	}
}

/* Output : 

[4, 5]
false
true[5, 6, 7]
[4, 5, 6, 7]
Unions
[1, 2, 3]
[1, 2, 5]
[2, 3, 5]
[2, 3, 5]
[2, 3, 5]
[[1, 2, 3], [1, 2, 5], [2, 3, 5]]

 */
