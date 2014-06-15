// Breadth First Search

class Node
{
	Vertex v;
	Node next; //next in linked list

	Node(Vertex x)
	{
		v=x;
	}
}

class LinkedList
{
	Node head,current;

	/*LinkedList(Node x)
	{
		head=x;
		current=head;
	}*/

	void add(Vertex x)
	{
		if(head==null)
		{
			head=new Node(x);
			current=head;
		}
		else
		{
			//current.next=x;
			Node newNode = new Node(x);
			current.next = newNode;
			current=newNode;
		}
	}

	void display()
	{
		System.out.print("[ ");
		for(Node i = head;i!=null;i=i.next)
		{
			System.out.print(i.v.vertexName+" ");
		}
		System.out.println("]");
	}
}

class Vertex
{
	char vertexName;
	Vertex parent;
	int distance;

	LinkedList neighbors=new LinkedList();

	Vertex(char x)
	{
		vertexName=x;
	}
}

class Graph
{
	int nVertices;
	Vertex vertexList[];

	void inputData()
	{
		nVertices=4;
		vertexList=new Vertex[nVertices];

		vertexList[0]=new Vertex('s');
		vertexList[1]=new Vertex('w');
		vertexList[2]=new Vertex('t');
		vertexList[3]=new Vertex('x');

		vertexList[0].neighbors.add(vertexList[1]);
		vertexList[1].neighbors.add(vertexList[2]);
		vertexList[1].neighbors.add(vertexList[3]);
		vertexList[2].neighbors.add(vertexList[1]);
		vertexList[2].neighbors.add(vertexList[3]);
		vertexList[3].neighbors.add(vertexList[1]);
		vertexList[3].neighbors.add(vertexList[2]);
	}

	void display()
	{
		for(int i=0;i<vertexList.length;i++)
		{
			vertexList[i].neighbors.display();
		}
	}
}

class BFS
{
	public static void main(String args[])
	{
		Graph G = new Graph();
		G.inputData();
		G.display();
	}
}
