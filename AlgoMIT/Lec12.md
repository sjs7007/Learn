# Lecture 1 Notes : Sorting

1.Insertion Sort
--------

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

1.4.1 Theta notation  

Drop lower order terms ignoring constants.

2.Merge Sort
------

2.1 Psuedo Code  

```
MergeSortA(1..n)
	1.If n=1, done
	2.Recursively sort A[1.... ceil(n/2)] and A[ceil(n/2)+1....n]
	3.Merge 2 sorted lists
```

**Merge function logic** : The smallest element is always at the head of either of the two sorted lists.

2.2 Java Code

[Merge Sort](../Algos/MergeSort/MergeSort.java)

```Java
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
```

2.3 Analysis : In handwritten notes.
