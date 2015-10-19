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

	void prepend(int x)
	{
		Node temp = new Node(x);
		temp.next=head;
		head=temp;
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

	static LinkedList addForward(LinkedList n1,LinkedList n2)
	{
		LinkedList ret = new LinkedList();
		//get length of n1 and n2 first
		int n1Count=0,n2Count=0;
		for(Node current=n1.head;current.next!=null;current=current.next)
		{
			n1Count++;
		}
		for(Node current=n2.head;current.next!=null;current=current.next)
		{
			n2Count++;
		}
		//add the smaller one with zeros 
		if(n1Count>n2Count)
		{
			for(int i=1;i<=n1Count-n2Count;i++)
			{
				n2.prepend(0);
			}
		}
		else
		{
			for(int i=1;i<=n2Count-n1Count;i++)
			{
				n1.prepend(0);
			}
		}
		//Display 
		System.out.println("After prepending  : ");
		n1.display();
		n2.display();

		int sum=0;


		sum = addDigits(n1.head,n2.head,ret);
		if(sum!=0)
		{
			ret.prepend(sum);
		}
		ret.display();
		return ret;
	}

	static int addDigits(Node x,Node y,LinkedList L)
	{
		int carry=0;
		if(x.next!=null)
		{
			carry = addDigits(x.next,y.next,L);
		}
		//System.out.print((x.data+y.data)+" ");
		int sum = carry + x.data+y.data;
		L.prepend(sum%10);
		return (sum/10);
	}

}

class CTCI_2_5_2
{
	public static void main(String args[])
	{
		LinkedList n1 = new LinkedList();
		n1.add(7);
		n1.add(1);
		n1.add(6);
		LinkedList n2 = new LinkedList();
		n2.add(5);
	//	n2.add(9);
		n2.add(9);
		n2.add(9);
		/*LinkedList n3 = LinkedList.addTwo(n1.head,n2.head);
		n1.reverseDisplay(n1.head);
		System.out.println();
		n2.reverseDisplay(n2.head);
		System.out.println();
		n3.reverseDisplay(n3.head);	
		System.out.println();*/
		LinkedList.addForward(n1,n2);

	}
}