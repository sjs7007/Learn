# Heap 

1.Links
----
+ [MIT Video](http://ocw.mit.edu/courses/electrical-engineering-and-computer-science/6-006-introduction-to-algorithms-fall-2011/lecture-videos/lecture-4-heaps-and-heap-sort/)
+ [MIT Slides](http://ocw.mit.edu/courses/electrical-engineering-and-computer-science/6-006-introduction-to-algorithms-fall-2011/lecture-videos/MIT6_006F11_lec04.pdf)
+ Cormen, pg 151

2.Brief Description
--------
![Heap](Heap1.png)

3.Psuedo Codes
------

### 3.1 Max-Heapify(A,i)

+ Heap size : Although A[1..A.length] may contain numbers, only the elements in A[1...A.heap-size], where 0<=A.heap-size<=A.length are valid elements of the heap.

+ parent(i)=return i/2

+ left(i)=return 2i

+ right(i)=return 2i+1

+ **Assumption** : Left and right children are max heaps but A[i] maybe smaller than its children thus violating max heap property.

+ largest : index of largest value among left,right and parent.

Max-Heapify(A,i)   

```C
l=left(i)=2i // **NOTE**:For array starting from 0 index left=2i+1,right=2i+2 
r=right(i)=2i+1
if(l<=A.heap-size and A[l]>A[i]) //if right child is greater than root,set that index to largest else to parent
	largest=l
else  largest=i
if(r<=A.heap-size and A[r]>A[i]) 
	largest=r

if(largest!=i)
	A[i]<-->A[largest]
	Max-Heapify(A,largest)
```

### 3.2 Build-Max-Heap(A)

+ All the elements in the subarray A(floor(n/2)+1...n) are all leves of the tree and hence each is a 1-element heap to begin with.

+ Thus the Max-Heapify procedure can be used in a bottom-up manner to convert heap to max-heap.

Build-Max-Heap(A)
```
A.heap-size=A.length
for i = floor(A.length/2) down-to 1
	Max-Heapify(A,i)
```

4.Java Code
----
[Java Code Link](HeapCode.java)

**Code for max heapify,build max heap,heap sort**

```Java
class Heap
{
	int data[],heapSize;

	Heap(int x[])
	{
		data=x;
		heapSize=x.length;
	}

	void MaxHeapify(int i)
	{
		int l,r;
		l=2*i+1; // NOTE +1 because array starst with 0
		r=l+1;
		int largest=i;
		if(l<heapSize && data[l]>data[i])
		{
			largest=l;
		}
		if(r<heapSize && data[r]>data[largest])
		{
			largest=r;
		}
		if(largest!=i)
		{	
		//	System.out.println("Swapping "+data[i]+" and "+data[largest]+". "+largest);
			int temp=data[i];
			data[i]=data[largest];
			data[largest]=temp;	
			MaxHeapify(largest);
		}
	}

	void BuildMaxHeap()
	{
		heapSize=data.length;
		for(int i=data.length/2;i>=0;i--)
		{
			MaxHeapify(i);
		}
	}

	void HeapSort()
	{
		BuildMaxHeap();
		for(int i=data.length-1;i>=1;i--)
		{
			int temp=data[0];
			data[0]=data[i];
			data[i]=temp;
			heapSize--;
			MaxHeapify(0);
		//	System.out.println(heapSize);
		}
	}
}

class HeapCode
{
	public static void main(String args[])
	{
		int data[]={16,4,10,14,7,9,3,2,8,1};
		Heap H = new Heap(data); 
		//H.MaxHeapify(1);

	/*	H.BuildMaxHeap();
		System.out.print("After bulding max heap : ");
		for(int i=0;i<data.length;i++)
		{
			System.out.print(data[i]+" ");
		}
		System.out.println();
	*/

		H.HeapSort();
		System.out.print("After heap sort : ");
		for(int i=0;i<data.length;i++)
		{
			System.out.print(data[i]+" ");
		}
		System.out.println();
	}
}
```


