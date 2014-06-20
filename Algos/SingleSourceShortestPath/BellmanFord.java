//BellmanFord implementation 

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

	boolean bellmanFord()
	{
		initializeSS();

		for(int i=1;i<=nVertices-1;i++)
		{
			for(int j=0;j<nVertices;j++)
			{
				for(Node k=vertexList[j].neighbors.head;k!=null;k=k.next)
				{
					relax(vertexList[j],k.v,k.weight);
				}
			}
		}

		for(int j=0;j<nVertices;j++)
		{
			for(Node i=vertexList[j].neighbors.head;i!=null;i=i.next)
			{
				if(i.v.d > vertexList[j].d + i.weight)
				{
					System.out.println("Negative weight cycle present in graph.");
					return false;
				}
			}
		}

		return true;
	}

	void displayBellmanFordDistances()
	{
		System.out.println("\nBellmanFord Distances :-");
		for(int i=0;i<nVertices;i++)
		{
			System.out.println(vertexList[i].vertexName+" : "+vertexList[i].d);
		}
	}
}


class BellmanFord
{
	public static void main(String args[])
	{
		Graph G = new Graph();
		G.inputData();
		G.display();
		G.bellmanFord();
		G.displayBellmanFordDistances();
	}
}
