//Find max sub array using Divide and Conquer - Cormen, pg 71

class Sub 
{
	int start,end,sum;

	Sub(int x,int y,int z)
	{
		start=x;
		end=y;
		sum=z;
	}
}

class MaxSubArray
{
	public static void main(String[] args) 
	{
		int numbers[]={13,-3,-25,5000,-3,-16,-23,18,20,-7,12,-5,-2200,1500,-4,7};
		Sub ans = FindMaxSub(numbers,0,numbers.length);
		System.out.print("Input : ");
		for(int i:numbers)
		{
			System.out.print(i+" ");
		}
		System.out.println();

		System.out.println("Numbers from "+ans.start+" to "+ans.end+",sum = "+ans.sum);
		System.out.print("Numbers : ");
		for(int i=ans.start;i<=ans.end;i++)
		{
			System.out.print(numbers[i]+" ");
		}
		System.out.println();
	}

	public static Sub FindCrossingSub(int numbers[],int low,int mid,int high) //find max subArray that has parts on both left and right side
	{
		int negInfinity = -10000;
		int tempSum=0;
		int leftSum=negInfinity,leftIndex=0;
		for(int i=mid;i>=low;i--)
		{
			tempSum=tempSum+numbers[i];
			if(tempSum>leftSum)
			{
				leftSum=tempSum;
				leftIndex=i;
			}
		}

		tempSum=0;
		int rightSum=negInfinity,rightIndex=0;
		for(int i=mid+1;i<high;i++)
		{
			tempSum=tempSum+numbers[i];
			if(tempSum>rightSum)
			{
				rightSum=tempSum;
				rightIndex=i;
			}
		}

		Sub cross = new Sub(leftIndex,rightIndex,leftSum+rightSum);
		return cross;
	}

	public static Sub FindMaxSub(int numbers[],int low,int high)
	{
		if(low==high)
		{
			int temp=high;
			if(high==numbers.length)
			{
				temp=high-1;
			}
			Sub max = new Sub(low,high,temp);
			return max;
		}	
		else
		{
			int mid = (low+high)/2;
			Sub left = FindMaxSub(numbers,low,mid);
			Sub right = FindMaxSub(numbers,mid+1,high);
			Sub crossing = FindCrossingSub(numbers,low,mid,high);

			if(left.sum>=right.sum && left.sum>=crossing.sum)
			{
				return left;
			}
			else if(right.sum>=left.sum && right.sum>=crossing.sum)
			{
				return right;
			}
			else
			{
				return crossing;
			}
		}
	}
}

/*
Input : 13 -3 -25 20 -3 -16 -23 18 20 -7 12 -5 -22 15 -4 7 
Numbers from 7 to 10,sum = 43
Numbers : 18 20 -7 12 
*/

/*
Input : 13 -3 -25 20 -3 -16 -23 18 20 -7 12 -5 -2200 1500 -4 7 
Numbers from 13 to 15,sum = 1503
Numbers : 1500 -4 7 
*/

/*
Input : 13 -3 -25 5000 -3 -16 -23 18 20 -7 12 -5 -2200 1500 -4 7 
Numbers from 3 to 10,sum = 5001
Numbers : 5000 -3 -16 -23 18 20 -7 12 
*/