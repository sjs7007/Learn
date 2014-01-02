//Counting Sort, Cormen pg 194

class CountingSort
{
	public static void main(String args[])
	{
		int A[]={2,5,3,0,2,3,0,3};
		int rangeMax=5; //given?
		int C[]=new int[rangeMax+1];
		int B[]=new int[A.length];
		
		System.out.print("Initial Array : ");
		for(int i: A)
		{
			System.out.print(i+" ");
		}
		System.out.println();

		for(int i=0;i<A.length;i++)
		{
			C[A[i]]=C[A[i]]+1;
		}
		System.out.println("Number of occurances : ");
		for(int i=0;i<C.length;i++)
		{
			System.out.println(i+" : "+C[i]);
		}
		System.out.println();

	
		for(int i=1;i<C.length;i++)
		{
			C[i]=C[i]+C[i-1];
		}
		for(int i=0;i<C.length;i++)
		{
			System.out.println("Number of values less than "+i+" : "+C[i]);
		}
		System.out.println();

		for(int i=A.length-1;i>=0;i--)
		{
			B[C[A[i]]-1]=A[i];
			C[A[i]]--;
		}

		System.out.print("Sorted Array : ");
		for(int i: B)
		{
			System.out.print(i+" ");
		}
		System.out.println();

	}
}

/*
Initial Array : 0 3 3 1 4 4 1 
Number of occurances : 
0 : 1
1 : 2
2 : 0
3 : 2
4 : 2

Number of values less than 0 : 1
Number of values less than 1 : 3
Number of values less than 2 : 3
Number of values less than 3 : 5
Number of values less than 4 : 7

Sorted Array : 0 1 1 3 3 4 4 
*/

/*
Initial Array : 2 5 3 0 2 3 0 3 
Number of occurances : 
0 : 2
1 : 0
2 : 2
3 : 3
4 : 0
5 : 1

Number of values less than 0 : 2
Number of values less than 1 : 2
Number of values less than 2 : 4
Number of values less than 3 : 7
Number of values less than 4 : 7
Number of values less than 5 : 8

Sorted Array : 0 0 2 2 3 3 3 5 
*/