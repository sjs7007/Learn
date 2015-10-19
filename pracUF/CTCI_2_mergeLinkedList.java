//merge two linked lists

import java.util.*;

class Node
{
	int data;
	Node next;

	Node(int x)
	{
		data=x;
	}
}

class LinkedList
{
	Node head=null;
	
	void add(int x)
	{
		if(head==null)
		{
			head=new Node(x);
		}
		else
		{
			Node current=head;
			while(current.next!=null)
			{
				current=current.next;
			}
			current.next = new Node(x);
		}
	}

	void display()
	{
		for(Node current=head;current!=null;current=current.next)
		{
			System.out.print(current.data+" ");
		}
		System.out.println();
	}

	int delete(int x)
	{
		Node prev=head;
		int ret=-1;
		
		if(head.data==x)
		{
			head=head.next;
			ret=1;
			return ret;
		}

		for(Node current=head.next;current.next!=null;current=current.next)
		{
			if(current.data==x)
			{
				prev.next=current.next;
				ret=1;
				break;
			}
			prev=current;
		}
		return ret;
	}

	void mergeLists(LinkedList L1,LinkedList L2)
	{
		Node x=L1.head,y=L2.head;
		while(x.next!=null && y!=null)
		{
			Node yNext = y.next;
			y.next = x.next;
			x.next = y;

			x=x.next.next;
			y=yNext;
		}
	}
}

class CTCI_2_mergeLinkedList
{
	public static void main(String args[])
	{
		//HashSet x = new HashSet();
		LinkedList L1 = new LinkedList();
		LinkedList L2 = new LinkedList();
		for(int i=0;i<10;i++)
		{
			L1.add(i);
			L2.add(10+i);
		}
		L1.display();
		//L.actualReverse();
		L2.display();
		L1.mergeLists(L1,L2);
		L1.display();
	}
}