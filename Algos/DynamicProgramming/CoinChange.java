//Coin Change Problem using Dynamic Programming : https://www.youtube.com/watch?v=GafjS0FfAC0

// minCount(sum)=minCount(sum-(ith coin value))+1  <-- for all i coins

class CoinChange
{
	public static void main(String[] args) 
	{
		int coins[]={1,2,3}; //in increasing order
		int coinsUsed[]=new int[coins.length+1];
		int sum=5;
		int minCount[]=new int[sum+1]; //minCount for sum 0 =0 
		System.out.print("Coins Available : ");
		for(int i : coins)
		{
			System.out.print(i+" ");
		}
		System.out.println();
		System.out.println("Min. coins required for sum="+sum+" is : "+calcMinCount(coins,sum,minCount));
	}

	public static int calcMinCount(int coins[],int sum,int minCount[])
	{
		if(minCount[sum]>0)
		{
			return minCount[sum];
		}
		else if(sum==0)
		{
			return 0;
		}
		else
		{
			int infinity=10000;
			int temp = infinity;
			for(int i=0;i<coins.length && coins[i]<=sum;i++)
			{
				temp = min(temp,calcMinCount(coins,sum-coins[i],minCount)+1);
			}
			return temp;
		}
	}

	public static int min(int x,int y)
	{
		if(x>y)
		{
			return y;
		}
		else
		{
			return x;
		}
	}
}

/*
Output

Coins Available : 1 2 3 11 4 
Min. coins required for sum=18 is : 3

Coins Available : 1 2 3 
Min. coins required for sum=5 is : 2

*/