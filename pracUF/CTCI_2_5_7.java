//check if palindrome

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

class superNode
{
	Node sNode;
	boolean shouldBreak;

	superNode(Node x,boolean y)
	{
		sNode=x;
		shouldBreak=y;
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

	superNode checkPalindrome(Node x)
	{
		superNode temp = null;
		if(x.next!=null) 
		{
			temp = checkPalindrome(x.next);
			if(temp.shouldBreak)
			{
				return temp;
			}
		}
		if(temp==null)
		{
			temp=new superNode(head,false);
		}
		boolean shouldBreak=false;
		if(x.data!=temp.sNode.data)
		{
			shouldBreak=true;
		}
		temp.sNode=temp.sNode.next;
		return (new superNode(temp.sNode,shouldBreak));
	}


}

class CTCI_2_5_7{
	public static void main(String args[])
	{
		LinkedList L = new LinkedList();
		L.add(1);
		L.add(2);
		L.add(3);
		L.add(2);
		L.add(1);
		L.display();
		System.out.println("Is not a palindrome :  "+L.checkPalindrome(L.head).shouldBreak);

	}
}
