//Rod Cutting using DP - memoization

class RodCutting2
{
	public static void main(String args[])
	{
		int price[]={0,1,5,8,9,10,17,17,20,24,30};
		int profit[]=new int[11];
		for(int i=0;i<11;i++)
		{
			profit[i]=-1;
		}
		for(int i=1;i<=10;i++)
		{
			int maxProfit = memoizedCutRod(price,i,profit);
			System.out.println("maxProfit for length "+i+" : "+maxProfit+"\n");
		}
	}

	public static int memoizedCutRod(int price[],int totalLength,int profit[])
	{
		int maxProfit=-1;
		
		if(totalLength==0)
		{
			maxProfit=0;
		}
		else if(profit[totalLength]>=0)
		{
			//System.out.println("Memoized call for length :"+totalLength+".");
			return profit[totalLength];
		}
		else
		{
			for(int i=1;i<=totalLength;i++)
			{
				maxProfit = max(maxProfit,price[i]+memoizedCutRod(price,totalLength-i,profit));
			}
		}
		profit[totalLength]=maxProfit;
		return maxProfit;
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

/*

maxProfit for length 1 : 1
maxProfit for length 2 : 5
maxProfit for length 3 : 8
maxProfit for length 4 : 10
maxProfit for length 5 : 13
maxProfit for length 6 : 17
maxProfit for length 7 : 18
maxProfit for length 8 : 22
maxProfit for length 9 : 25
maxProfit for length 10 : 30

*/
