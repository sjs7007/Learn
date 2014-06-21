//Rod Cutting using naive recursive algo

class RodCutting1
{
	public static void main(String args[])
	{
		int price[]={0,1,5,8,9,10,17,17,20,24,30};
		for(int i=1;i<=10;i++)
		{
			int maxProfit = recursiveCutRod(price,i);
			System.out.println("maxProfit for length "+i+" : "+maxProfit);
		}
	}

	public static int recursiveCutRod(int price[],int totalLength)
	{
		int maxProfit=-1;
		
		if(totalLength==0)
		{
			maxProfit=0;
		}
		else
		{
			for(int i=1;i<=totalLength;i++)
			{
				maxProfit = max(maxProfit,price[i]+recursiveCutRod(price,totalLength-i));
			}
		}
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