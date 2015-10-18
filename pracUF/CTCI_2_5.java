//print reverse 

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

	void reverseDisplay(Node x)
	{
		if(x.next!=null)
		{
			reverseDisplay(x.next);
		}
		System.out.print(x.data);
	}

	static LinkedList addTwo(Node x,Node y)
	{
		LinkedList ret = new LinkedList();
		int sum=0;
		while(x!=null & y!=null)
		{
			sum=sum+x.data+y.data;
			ret.add(sum%10);
			sum=sum/10;
			x=x.next;
			y=y.next;
		}
		while(x!=null)
		{
			sum=sum+x.data;
			ret.add(sum%10);
			sum=sum/10;
			x=x.next;
		}
		while(y!=null)
		{
			sum=sum+y.data;
			ret.add(sum%10);
			sum=sum/10;
			y=y.next;
		}
		if(sum!=0)
		{
			ret.add(sum);
		}
		return ret;
	}

}

class CTCI_2_5
{
	public static void main(String args[])
	{
		LinkedList n1 = new LinkedList();
		n1.add(7);
		n1.add(1);
		//n1.add(6);
		LinkedList n2 = new LinkedList();
	//	n2.add(5);
	//	n2.add(9);
		n2.add(9);
		n2.add(9);
		LinkedList n3 = LinkedList.addTwo(n1.head,n2.head);
		n1.reverseDisplay(n1.head);
		System.out.println();
		n2.reverseDisplay(n2.head);
		System.out.println();
		n3.reverseDisplay(n3.head);	
		System.out.println();

	}
}