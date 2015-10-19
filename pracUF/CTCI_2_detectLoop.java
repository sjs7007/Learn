//print reverse 
//actual reverse

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
		int count=0;
		for(Node current=head;current!=null;current=current.next)
		{
			if(count>10)
			{
				break;
			}
			count++;
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

	void removeDuplicates()
	{
		System.out.println("Remove duplicates called.");
		HashSet x = new HashSet();
		Node prev=null;
		for(Node current=head;current!=null;current=current.next)
		{
			//System.out.println(x);
			if(x.contains(current.data))
			{
				//System.out.println("delte : " +current.data);
				prev.next=current.next;
			}
			else 
			{
			//	System.out.println("no : "+current.data);
				x.add(current.data);
				prev=current;
			}
			//display();
		}
		System.out.println("Duplicates removed.");
		display();
	}

	Node findNode(int x)
	{
		Node ret=null;
		for(Node current=head;current!=null;current=current.next)
		{
			if(current.data==x)
			{
				ret=current;
				break;
			}
		}
		return ret;
	}

	void deleteNode(Node x)
	{
		if(x==null)
		{
			System.out.println("No such node.");
		}
		else
		{
			System.out.println("After Delting Node : "+x.data);
			//x=x.next;
			x.data=x.next.data;
			x.next=x.next.next;
			//x=x.next;
			display();	
		}	
	}

	void printReverse(Node x)
	{
		if(x.next!=null)
		{
			printReverse(x.next);
		}
		System.out.print(x.data+" ");
	}

	void actualReverse()
	{
		Node temp=null,prev=null,current=head;
		while(current!=null)
		{
			temp=current.next;
			current.next=prev;
			prev=current;
			current=temp;
		}
		head=prev;
		System.out.println("Linkedlist reversed :");
		display();
	}

	void addLoop()
	{
		System.out.println(head.next.next.next.data+"->"+head.next.data);
		head.next.next.next.next=head.next;

	}

	void removeLoop()
	{
		Node slow=head,fast=head.next;
		while(slow!=fast)
		{
				//		System.out.println(slow+" "+fast);

		//	System.out.println(slow.data+" "+fast.data);
			slow=slow.next;
			fast=fast.next.next;
		//	System.out.println(slow.data+" "+fast.data);
		//	System.out.println(slow+" "+fast);
		}
		//			System.out.println(slow.data+" "+fast.data);

		System.out.println("Cycle found.");
		slow=head;
		while(slow!=fast.next)
		{
						System.out.println(slow.data+" "+fast.data);

			slow=slow.next;
			fast=fast.next;
		}
		System.out.println("Meet again at : "+slow.data);
		fast.next=null;
	}
}

class CTCI_2_detectLoop
{
	public static void main(String args[])
	{
		//HashSet x = new HashSet();
		LinkedList L = new LinkedList();
		for(int i=0;i<4;i++)
		{
			L.add(i);
		}
		L.display();
	//	L.actualReverse();
		//L.display();
		L.addLoop();
		L.display();
		L.removeLoop();
		L.display();
	}
}