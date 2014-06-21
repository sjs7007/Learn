//Rod cutting probelm using top-down DP approach with memoization

import java.util.Random;

class CutRodDP1
{
	public static void main(String[] args) 
	{
		Random randomGenerator = new Random();
		int p[]=new int[100];
		for(int i=0;i<p.length;i++)
		{
			p[i] = randomGenerator.nextInt(100);
		}
		int r[]=new int[p.length],infinity=10000;
		for(int i=0;i<r.length;i++)
		{
			r[i]=-infinity;
		}
		System.out.println(CutRod(p,90,r));
	}

	public static int CutRod(int p[],int n,int r[])
	{
		if(r[n]>=0)
		{
			return r[n];
		}
		else if(n==0)
		{
			return 0;
		}
		else
		{
			int infinity=10000;
			int q=-infinity;
			for(int i=1;i<=n;i++)
			{
				q=max(q,p[i-1]+CutRod(p,n-i,r));
			}
			r[n]=q;
			return q;
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
