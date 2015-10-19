import java.util.*;

class QuickSort
{
	public static void main(String args[])
	{
		int a[]={10,2,33,23,212,3,9,10,2};
		quickSort(a,0,a.length-1);
		System.out.println(Arrays.toString(a));
	}

	public static void quickSort(int a[],int low,int high)
	{
		if(low<high)
		{
			int q = partition(a,low,high);
			quickSort(a,low,q-1);
			quickSort(a,q+1,high);
		}
	}

	public static int partition(int a[],int p,int r)
	{
		int x=a[r]; //pivot
		int i=p-1;
		for(int j=p;j<=r-1;j++)
		{
			if(a[j]<=x)
			{
				i=i+1;
				int temp=a[i];
				a[i]=a[j];
				a[j]=temp;
			}
		}
		int temp=a[i+1];
		a[i+1]=a[r];
		a[r]=temp;
		return i+1;
	}
}