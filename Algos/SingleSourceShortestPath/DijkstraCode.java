//Dijkstra implementation using Min. Heap as Min. PQ

class PQ
{
	int data[],heapSize,n;
	int infinity = 10000;

	PQ(int x)
	{
		n=x;
		data=new int[n];
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

	int ExtractMin()
	{
		if(heapSize<1)
		{
			return -1; //heap underflow
		}
		int min=data[0];
		data[0]=data[heapSize-1];
		heapSize--;
		MinHeapify(0);
		return min;
	}

	void DecreaseKey(int i,int key)
	{
		if(key>data[i])
		{
			System.out.println("New key is smaller than current key.");
		}
		data[i]=key;
		while(i>0 && data[i/2]>data[i])
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
		data[heapSize-1]=infinity;
		DecreaseKey(heapSize-1,key);
	}
}

class DijkstraCode
{
	public static void main(String args[])
	{

	}
}