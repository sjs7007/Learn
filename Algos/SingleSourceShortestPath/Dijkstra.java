//Dijkstra implementation using Min. Heap as Min. PQ

class Node
{
	Vertex v;
	Node next; //next in linked list
	int weight; //store weight of edge

	Node(Vertex x,int w)
	{
		v=x;
		weight=w;
	}
}

class LList
{
	Node head,current;

	void add(Vertex x,int w)
	{
		if(head==null)
		{
			head=new Node(x,w);
			current=head;
		}
		else
		{
			Node newNode = new Node(x,w);
			current.next = newNode;
			current=newNode;
		}
	}

	void display()
	{
		System.out.print("[ ");
		for(Node i = head;i!=null;i=i.next)
		{
			System.out.print(i.v.vertexName+"("+i.weight+") ");
		}
		System.out.println("]");
	}
}

class Vertex
{
	char vertexName;
	Vertex parent;
	int d;

	LList neighbors=new LList();

	Vertex(char x)
	{
		vertexName=x;
	}
}

class PQ //min. priority queue
{
	Vertex data[];
	int heapSize,n;
	int infinity = 10000;

	PQ(int x)
	{
		n=x;
		data=new Vertex[n];
	}

	void MinHeapify(int i)
	{
		int l,r;
		l=2*i+1; // NOTE +1 because array starst with 0
		r=l+1;
		int smallest=i;
		if(l<heapSize && data[l].d<data[i].d)
		{
			smallest=l;
		}
		if(r<heapSize && data[r].d<data[smallest].d)
		{
			smallest=r;
		}
		if(smallest!=i)
		{	
		//	System.out.println("Swapping "+data[i]+" and "+data[smallest]+". "+smallest);
			Vertex temp=data[i];
			data[i]=data[smallest];
			data[smallest]=temp;	
			MinHeapify(smallest);
		}
	}

	Vertex ExtractMin()
	{
		if(heapSize<1)
		{
			return null; //heap underflow
		}
		Vertex min=data[0];
		data[0]=data[heapSize-1];
		heapSize--;
		MinHeapify(0);
		return min;
	}

	void DecreaseKey(int i,int key)
	{
		if(key>data[i].d)
		{
			System.out.println("New key is smaller than current key.");
		}
		data[i].d=key;
		while(i>0 && data[i/2].d>data[i].d)
		{
			Vertex temp=data[i];
			data[i]=data[i/2];
			data[i/2]=temp;
			i=i/2;
		}
	}

	void Insert(Vertex V)
	{
		heapSize++;
		int key=V.d;
		V.d = infinity;
		data[heapSize-1]=V;
		DecreaseKey(heapSize-1,key);
	}

	boolean isEmpty()
	{
		return heapSize==0;
	}
}



class Graph
{
	int nVertices;
	Vertex vertexList[];
	int time;

	void inputData()
	{
		//nVertices=4;
		nVertices=5;
		vertexList=new Vertex[nVertices];

		vertexList[0]=new Vertex('s');
		vertexList[1]=new Vertex('t');
		vertexList[2]=new Vertex('y');
		vertexList[3]=new Vertex('x');
		vertexList[4]=new Vertex('z');
	
		vertexList[0].neighbors.add(vertexList[1],10);
		vertexList[0].neighbors.add(vertexList[2],5);
		vertexList[1].neighbors.add(vertexList[3],1);
		vertexList[1].neighbors.add(vertexList[2],2);
		vertexList[2].neighbors.add(vertexList[1],3);
		vertexList[2].neighbors.add(vertexList[3],9);
		vertexList[2].neighbors.add(vertexList[4],2);
		vertexList[3].neighbors.add(vertexList[4],4);
		vertexList[4].neighbors.add(vertexList[0],7);
		vertexList[4].neighbors.add(vertexList[3],6);
	}

	void display()
	{
		System.out.println("Adjacency Lists:-");
		for(int i=0;i<vertexList.length;i++)
		{
			System.out.print(vertexList[i].vertexName+" : ");
			vertexList[i].neighbors.display();
		}
	}

	void initializeSS()
	{
		int infinity=10000;
		for(int i=1;i<vertexList.length;i++)
		{
			vertexList[i].d=infinity;
			vertexList[i].parent=null; //optional
		}
		vertexList[0].d=0; //optional
	}

	void relax(Vertex u,Vertex v,int weightUV)
	{
		if(v.d>u.d+weightUV)
		{
			v.d = u.d + weightUV;
			v.parent = u;
		}
	}

	void dijkstra()
	{
		initializeSS();
		PQ Q = new PQ(nVertices);
		
		for(int i=0;i<nVertices;i++)
		{
			Q.Insert(vertexList[i]);
		}

		//System.out.println(Q.ExtractMin().d);
		while(!Q.isEmpty())
		{
			Vertex u = Q.ExtractMin();
			for(Node i=u.neighbors.head;i!=null;i=i.next)
			{
				relax(u,i.v,i.weight);
			}
		}
	}

	void displayDijkstraDistances()
	{
		System.out.println("\nDijkstra Distances :-");
		for(int i=0;i<nVertices;i++)
		{
			System.out.println(vertexList[i].vertexName+" : "+vertexList[i].d);
		}
	}
}


class Dijkstra
{
	public static void main(String args[])
	{
		Graph G = new Graph();
		G.inputData();
		G.display();
		G.dijkstra();
		G.displayDijkstraDistances();
	}
}
