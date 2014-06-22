//http://www.spoj.com/problems/KNAPSACK/

class KnapsackRecursive
{
	public static void main(String args[])
	{
		int n=5;
		int sizeKnapsack=4;
		//int size[]=new int[n+1];
		//int value[]=new int[n+1];
		int size[]={-1,1,2,3,2,2};
		int value[]={-1,8,4,0,5,3};

		System.out.println(getOptimal(size,value,sizeKnapsack,n));

	}

	public static int getOptimal(int size[],int value[],int currentCapacity,int n)
	{
		if(n==0 || currentCapacity==0)
		{
			return 0;
		}
		else if(currentCapacity<size[n])
		{
			return getOptimal(size,value,currentCapacity,n-1);
		}
		else
		{
			return max(getOptimal(size,value,currentCapacity,n-1),getOptimal(size,value,currentCapacity-size[n],n-1)+value[n]);
		}
	}

	public static int max(int x,int y)
	{
		if(x>y)
		{
			return x;
		}
		else
		{
			return y;
		}
	}
}
