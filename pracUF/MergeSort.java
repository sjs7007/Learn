import java.util.*;

class MergeSort
{
	public static void main(String args[])
	{
		int x[]={12,12,4,5,20,3,11,23};
		x = mergeSort(x,0,x.length-1);
		System.out.println(Arrays.toString(x));
	}

	public static int[] merge(int x1[],int x2[])
	{
		int n1=x1.length,n2=x2.length;
		int x3[]=new int[n1+n2],i1=0,i2=0,i3=0;
		while(i1<n1 && i2<n2)
		{
			if(x1[i1] < x2[i2])
			{
				x3[i3]=x1[i1];
				i1++;
			}
			else
			{
				x3[i3]=x2[i2];
				i2++;
			}
			i3++;
		}
		while(i1<n1)
		{
			x3[i3]=x1[i1];
			i1++;
			i3++;
		}
		while(i2<n2)
		{
			x3[i3]=x2[i2];
			i2++;
			i3++;
		}
		return x3;
	}

	public static int[] mergeSort(int x[],int low,int high)
	{
		if(low==high)
		{
			int x3[]=new int[1];
			x3[0]=x[low];
			return x3;
		}
		else
		{
			int mid = low + (high-low)/2;
			int x1[] = mergeSort(x,low,mid);
			int x2[] = mergeSort(x,mid+1,high);
			int temp[] = merge(x1,x2);
			return temp;
		}
	}
}