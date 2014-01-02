//RadixSort, Cormen, pg198

class RadixSort
{
	public static void main(String[] args) 
	{
		int a[]={329,457,657,839,436,720,355};
		int d = 3 ; //if not given calculated as length of max number in array
		int n =a.length;
		System.out.print("Intial Array : ");
		for(int i : a)
		{
			System.out.print(i+" ");
		}	
		System.out.println();
		for(int k=1;k<=d;k++)
		{
			//use stable sort to sort array on digit i
			for(int i=1;i<n;i++)
			{
				int key = a[i];
				int j = i-1;
				while(j>=0 && nthDigit(key,k)<nthDigit(a[j],k)) //note : < and not <= else order is lost which leads to wrong answer
				{
					a[j+1]=a[j];
					j--;
				}
				a[j+1]=key;
			}
			System.out.print("After iteration  "+k+": ");
			for(int i : a)
			{
				System.out.print(i+" ");
			}	
			System.out.println();	
		}
		System.out.print("Sorted Array : ");
		for(int i : a)
		{
			System.out.print(i+" ");
		}	
		System.out.println();
	}

	public static int nthDigit(int number,int n) // starting from 1 at rightmost or unit
	{
		int digit=1;
		for(int i=1;i<=n;i++)
		{
			digit = number % 10;
			number = number / 10;
		}
		return digit;
	}
}