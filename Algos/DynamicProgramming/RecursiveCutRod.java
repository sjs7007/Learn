//Rod cutting probelm using recursion without DP

import java.util.Random;

class RecursiveCutRod
{
	public static void main(String[] args) 
	{
		Random randomGenerator = new Random();
		int p[]=new int[100];
		for(int i=0;i<p.length;i++)
		{
			p[i] = randomGenerator.nextInt(100);
		}
		System.out.println(CutRod(p,30));
	}

	public static int CutRod(int p[],int n)
	{
		if(n==0)
		{
			return 0;
		}
		int infinity=10000;
		int q=-infinity;
		for(int i=1;i<=n;i++)
		{
			q=max(q,p[i-1]+CutRod(p,n-i));
		}
		return q;
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