//Quick Sort(uses Divide and Conquer),Cormen pg170

class QuickSort
{
	public static void main(String[] args) 
	{
		int numbers[]={2,8,7,1,3,5,6,4};
		System.out.print("Intial Array : ");
		for(int i : numbers)
		{
			System.out.print(i+" ");
		}	
		System.out.println();

		QSort(numbers,0,numbers.length-1);

		System.out.print("Sorted Array : ");
		for(int i : numbers)
		{
			System.out.print(i+" ");
		}	
		System.out.println();
	}

	public static void QSort(int numbers[],int p,int r)
	{
		if(p<r)
		{
			int q = Partition(numbers,p,r);
			QSort(numbers,p,q-1);
			QSort(numbers,q+1,r);
		}
	}

	public static int Partition(int numbers[],int p,int r)
	{
		int key = numbers[r];
		int i=p-1;
		for(int j=p;j<=r-1;j++)
		{
			if(numbers[j]<=key)
			{
				i=i+1;
				int temp=numbers[j];
				numbers[j]=numbers[i];
				numbers[i]=temp;
			}
		}
		int temp=numbers[i+1];
		numbers[i+1]=numbers[r];
		numbers[r]=temp;
		return i+1;
	}
}

/*
Intial Array : 2 8 7 1 3 5 6 4 
Sorted Array : 1 2 3 4 5 6 7 8 
*/