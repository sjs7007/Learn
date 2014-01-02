// http://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle
// http://www.quora.com/Algorithms/What-are-some-good-ways-to-randomize-a-set-of-a

import java.util.Random;

class Shuffle
{
	public static void main(String[] args) 
	{
		int a[]={1,2,3,4,5,6,7,8};
		System.out.print("Intial Array : ");
		for(int i : a)
		{
			System.out.print(i+" ");
		}	
		System.out.println();

		Random randomGenerator = new Random();
		for(int i=a.length-1;i>=0;i--)
		{
			int j=randomGenerator.nextInt(a.length);
			int temp=a[j];
			a[j]=a[i];
			a[i]=temp;
		}	

		System.out.print("Shuffled Array : ");
		for(int i : a)
		{
			System.out.print(i+" ");
		}	
		System.out.println();
	}
}

/*
Intial Array : 1 2 3 4 5 6 7 8 
Shuffled Array : 2 7 1 3 8 6 5 4 
*/

/*
Intial Array : 1 2 3 4 5 6 7 8 
Shuffled Array : 2 5 7 4 3 1 8 6 
*/

/*
Intial Array : 1 2 3 4 5 6 7 8 
Shuffled Array : 7 3 6 8 2 5 4 1 
*/

