Lecture 1 Notes : Sorting
-------

1.Insertion Sort

1.1 Psuedo Code

```
InsertionSort(A,n)
for j=2 to n
	do key=a[j]
		i=j-1
		while i>0 and A[i]>key
			do A[i+1]=a[i]
				i=i-1
		A[i+1]=key
```

1.2 Java Code

[InsertionSort](Lec1InsertionSort.java)

```Java
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
```

1.3 Running Time

+ Based on Input Data  
	
	+ Best Case  
	Already Sorted.Only 1 comparision needed in each loop.
 
	+ Worst Case  
	Reverse Sorted.

1.4 Asymptotic Analysis

**1.4.1 Theta notation**
	
Drop lower order terms ignoring constants.
		


