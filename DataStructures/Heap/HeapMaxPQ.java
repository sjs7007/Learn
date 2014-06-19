//Heap based Max. priority Queue

class PQ
{
	int data[],heapSize,n;
	int infinity = 10000;

	PQ(int x)
	{
		n=x;
		data=new int[n];
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

	int ExtractMax()
	{
		if(heapSize<1)
		{
			return -1; //heap underflow
		}
		int max=data[0];
		data[0]=data[heapSize-1];
		heapSize--;
		MaxHeapify(0);
		return max;
	}

	void IncreaseKey(int i,int key)
	{
		if(key<data[i])
		{
			System.out.println("New key is smaller than current key.");
		}
		data[i]=key;
		while(i>0 && data[i/2]<data[i])
		{
			int temp=data[i];
			data[i]=data[i/2];
			data[i/2]=temp;
			i=i/2;
		}
	}

	void Insert(int key)
	{
		heapSize++;
		data[heapSize-1]=-infinity;
		IncreaseKey(heapSize-1,key);
	}
}

class HeapMaxPQ
{
	public static void main(String args[])
	{
		PQ P = new PQ(10);
		P.Insert(1);
		P.Insert(2);
		P.Insert(500);
		P.Insert(3);
		P.Insert(4);
		System.out.println("Max :"+P.ExtractMax());
		
	}
}
