// Build Max Heap, Heapify, Heap Sort 

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
