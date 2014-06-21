//http://www.hackerearth.com/problem/algorithm/roy-and-little-mario-4/

//Accepted with 100/100 score!

import java.util.*;
import java.math.*;

class he43
{
	public static void main(String args[])
	{
		BigInteger ansHeight[]=new BigInteger[100001];
		ansHeight[1]=BigInteger.valueOf(1);
		ansHeight[2]=BigInteger.valueOf(2);
		ansHeight[3]=BigInteger.valueOf(4);

		Scanner ip = new Scanner(System.in);

		int t = ip.nextInt();

		for(int i=1;i<=t;i++)
		{
			int n = ip.nextInt();
			BigInteger ans = getAnswer(n,ansHeight);
			//System.out.print(ans+" ");
			//ans = ans.mod(BigInteger.valueOf(1000000007));
			System.out.println(ans);
		}	
	}

	public static BigInteger getAnswer(int nBricks,BigInteger ansHeight[])
	{
		if(ansHeight[nBricks]==null)
		{
			for(int i=4;i<=nBricks;i++)
			{
				ansHeight[i]=ansHeight[i-1].add(ansHeight[i-2]).add(ansHeight[i-3]).mod(BigInteger.valueOf(1000000007));
			}
		}
		return ansHeight[nBricks];
	}
}
