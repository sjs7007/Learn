class Lec1InsertionSort
{
	public static void main(String args[])
	{
		int data[]={8,2,4,9,3,6};
		int n=data.length;
		for(int i=1;i<n;i++)
		{
			int key=data[i];
			int j=i-1;
			while(j>=0 && data[j]>key)
			{
				data[j+1]=data[j];
				j--;
			}
			data[j+1]=key;
		}
		System.out.print("Sorted Array : ");
		for(int i=0;i<n;i++)
		{
			System.out.print(data[i]+" ");
		}
	}
}

/*

Psuedo Code 

InsertionSort(A,n)
	for j=2 to n
		do key=a[j]
			i=j-1
			while i>0 and A[i]>key
				do A[i+1]=a[i]
					i=i-1
			A[i+1]=key
*/
