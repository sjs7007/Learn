//Merge Sort

class MergeSort
{
	public static void main(String[] args) 
	{
		int numbers[]={3,44,231,23,14,23,45};
		numbers=MSort(numbers);
		System.out.print("Sorted Array : ");
		for(int i : numbers)
		{
			System.out.print(i+" ");
		}
		System.out.println();
	}

	public static int[] MSort(int n[])
	{
		if(n.length==1)
		{
			return n;
		}
		else
		{
			int n1=n.length-(n.length/2);
			int n2=n.length-n1;
			int b[]=new int[n1];
			int c[]=new int[n2];
			for(int i=0;i<n1;i++)
			{
				b[i]=n[i];
			}
			for(int i=0;i<n2;i++)
			{
				c[i]=n[n1+i];
			}
			b=MSort(b);
			c=MSort(c);
			n=Merge(b,c);
			return n;
		}
	}

	public static int[] Merge(int b[],int c[])
	{
		int n=b.length+c.length;
		int numbers[]=new int[n];
		int j=0,k=0;
		for(int i=0;i<n;i++)
		{
			if(j<b.length && k<c.length)
			{
				if(b[j]<=c[k])
				{
					numbers[i]=b[j];
					j++;
				}
				else
				{
					numbers[i]=c[k];
					k++;
				}
			}
			else if(j>=b.length)
			{
				numbers[i]=c[k];
				k++;
			}
			else
			{
				numbers[i]=b[j];
				j++;
			}
		}
		return numbers;
	}
}