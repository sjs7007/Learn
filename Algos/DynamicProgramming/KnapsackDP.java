//http://www.spoj.com/problems/KNAPSACK/

import java.util.*;

class KnapsackDP
{
	public static void main(String args[])
	{
		/*int n=5;
		int sizeKnapsack=4;
		//int size[]=new int[n+1];
		//int value[]=new int[n+1];
		int size[]={1,2,3,2,2};
		int value[]={8,4,0,5,3};
		int answer[][]=new int[n+1][sizeKnapsack+1];
		System.out.println(getOptimal(size,value,sizeKnapsack,n,answer));
		*/

		Scanner ip = new Scanner(System.in);
		int sizeKnapsack=ip.nextInt();	
		int n=ip.nextInt();
		int size[]=new int[n],value[]=new int[n];
		for(int i=0;i<n;i++)
		{
			size[i]=ip.nextInt();
			value[i]=ip.nextInt();
		}
		int answer[][]=new int[n+1][sizeKnapsack+1];
		System.out.println(getOptimal(size,value,sizeKnapsack,n,answer));

	}

	public static int getOptimal(int size[],int value[],int currentCapacity,int n,int answer[][])
	{
		for(int i=0;i<=n;i++)
		{
			for(int j=0;j<=currentCapacity;j++)
			{
				if(i==0 || j==0)
				{
					answer[i][j]=0;
				}
				else if(size[i-1]>j)
				{
					answer[i][j]=answer[i-1][j];
				}
				else
				{
					answer[i][j]=max(answer[i-1][j],answer[i-1][j-size[i-1]]+value[i-1]);
				}
			}
		}

		return answer[n][currentCapacity];
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
