// Breadth First Search

//http://stackoverflow.com/questions/10213707/fifo-based-queue-implementations

import java.util.*;

class Node
{
	Vertex v;
	Node next; //next in linked list

	Node(Vertex x)
	{
		v=x;
	}
}

class LList
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
	String color;

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

	void BFS()
	{
		int infinity=10000; //infinity value
		Queue<Vertex> Q =new LinkedList<Vertex>();

		for(int i=1;i<vertexList.length;i++) 
		{
			vertexList[i].color="white";
			vertexList[i].distance=infinity;
			vertexList[i].parent=null; //optional, by default null
		}

		vertexList[0].color="gray";
		vertexList[0].distance=0;
		vertexList[0].parent=null; //optional

		Q.add(vertexList[0]);
		//System.out.println(Q.isEmpty());
		while(!Q.isEmpty())
		{
			Vertex u = Q.poll(); //retrieve and remove first element

			for(Node i=u.neighbors.head;i!=null;i=i.next)
			{
				if(i.v.color=="white")
				{
					i.v.color="gray";
					i.v.distance=u.distance+1;
					i.v.parent=u;
					Q.add(i.v);
				}
			}
			u.color="black";
		}
	}

	void displayDistances()
	{
		for(int i=0;i<vertexList.length;i++)
		{
			System.out.println(vertexList[i].vertexName+" : "+vertexList[i].distance);
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
		G.BFS();
		G.displayDistances();
	}
}
