// Build Min Heap, Heapify, Heap Sort, Extract Min - Min Priority Queue

class Heap
{
	int data[],heapSize;

	Heap(int x[])
	{
		data=x;
		heapSize=x.length;
	}

	void MinHeapify(int i)
	{
		int l,r;
		l=2*i+1; // NOTE +1 because array starst with 0
		r=l+1;
		int smallest=i;
		if(l<heapSize && data[l]<data[i])
		{
			smallest=l;
		}
		if(r<heapSize && data[r]<data[smallest])
		{
			smallest=r;
		}
		if(smallest!=i)
		{	
		//	System.out.println("Swapping "+data[i]+" and "+data[smallest]+". "+smallest);
			int temp=data[i];
			data[i]=data[smallest];
			data[smallest]=temp;	
			MinHeapify(smallest);
		}
	}

	void BuildMinHeap()
	{
		heapSize=data.length;
		for(int i=data.length/2;i>=0;i--)
		{
			MinHeapify(i);
		}
	}

	void HeapSort()
	{
		BuildMinHeap();
		for(int i=data.length-1;i>=1;i--)
		{
			int temp=data[0];
			data[0]=data[i];
			data[i]=temp;
			heapSize--;
			MinHeapify(0);
		//	System.out.println(heapSize);
		}
	}

	int ExtractMin()
	{
		if(heapSize<0)
		{
			return -1; //heap underflow
		}
		int min=data[0];
		data[0]=data[heapSize-1];
		heapSize--;
		MinHeapify(0);
		return min;
	}
}

class HeapCodeMin
{
	public static void main(String args[])
	{
		int data[]={16,4,10,14,7,9,3,2,8,1};
		Heap H = new Heap(data); 
		//H.MinHeapify(1);

		H.BuildMinHeap();
		System.out.print("After bulding min heap : ");
		for(int i=0;i<data.length;i++)
		{
			System.out.print(data[i]+" ");
		}
		System.out.println();

		/*System.out.println("Min Value : "+H.ExtractMin());
		System.out.println("Min Value : "+H.ExtractMin());
		System.out.println("Min Value : "+H.ExtractMin());*/
	
		H.HeapSort();
		System.out.print("After heap sort in decreasing order : ");
		for(int i=0;i<data.length;i++)
		{
			System.out.print(data[i]+" ");
		}
		System.out.println();

		
	}
}
