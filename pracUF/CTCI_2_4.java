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

	void partition(int x)
	{
		System.out.println("partition : "+x);
		Node current=head,nHead=null,temp=null,prev=null;
		while(current!=null)
		{
			if(current.data>=x)
			{
				if(nHead==null)
				{
					nHead=new Node(current.data);
					temp=nHead;
				}
				else
				{
					temp.next=new Node(current.data);
					temp=temp.next;
				}

				if(current.next==null)
				{
					//current.data=-1;
					//current.next=nHead;
					//current.next=nHead;
					//current.next.data=nHead.data;
					current.data=nHead.data;
					current.next=nHead.next;
					break;
				}
				else
				{
					current.data=current.next.data;
					current.next=current.next.next;
				}
				prev=current;
			}
			else 
			{
				
				if(current.next==null)
				{
					//current.data=-1;
					//current.next=nHead;
					//current.next=nHead;
					//current.next.data=nHead.data;
				//	current.data=nHead.data;
					current.next=nHead;
					break;
				}

				prev=current;
				current=current.next;
			}
		}
		display();
		/*for(current=nHead;current!=null;current=current.next)
		{
			System.out.print(current.data+" ");
		}*/
	}

}

class CTCI_2_4
{
	public static void main(String args[])
	{
		//HashSet x = new HashSet();
		LinkedList L = new LinkedList();
		/*L.add(1);
		L.add(2);
		L.add(3);
		L.display();
		L.delete(2);
		L.display();
		L.add*/
		Random r = new Random();
		for(int i=0;i<10;i++)
		{
			L.add(r.nextInt(3));
		}
		/*L.display();
		L.removeDuplicates();
		L.display();*/
		for(int i=0;i<10;i++)
		{
			L.add(r.nextInt(10));
			//L.add(i);
			//L.add(10-i);
		}
		L.display();
		//L.deleteNode(L.findNode(2));
		//L.printReverse(L.head);
		//System.out.println();
		L.partition(3);
	}
}