/*
 Linked List Basics : http://cslibrary.stanford.edu/103/ , http://www.cs.bu.edu/fac/snyder/cs112/CourseMaterials/LinkedListNotes.html
 Linked List Problems : http://cslibrary.stanford.edu/105/
 https://www.youtube.com/watch?v=K7VIKlUdo20
*/

class Node
{
	int data;
	Node next;

	Node(int x)
	{
		data=x;
	}

	void display()
	{
		System.out.print(data+"-->");
	}
}

class LinkedList
{
	Node head;

	void insertFirst(int x)
	{
		Node newNode = new Node(x);
		newNode.next = head;
		head = newNode;
	}

	void insertLast(int x)
	{
		if(head==null)
		{
			insertFirst(x);
		}
		else
		{
			Node newNode = new Node(x);
			Node current = head;
			while(current.next!=null)
			{
				current = current.next;
			}
			current.next = newNode;
		}
	}

	Node deleteFirst()
	{
		if(head==null)
		{
			System.out.println("List is empty, no elements to delete.");
			return null;
		}
		else
		{
			Node temp = head;
			head=head.next;
			System.out.println("Deleted "+temp.data+".");
			return temp;
		}
	}

	Node deleteLast()
	{
		if(head==null)
		{
			System.out.println("List is empty, no elements to delete.");
			return null;
		}
		else if(head.next==null)
		{
			Node temp=head;
			deleteFirst();
			return temp;
		}
		else
		{
			Node temp1=head,temp2=null;
			while(temp1.next!=null)
			{
				temp2 = temp1;
				temp1 = temp1.next;
			}
			temp2.next = null;
			System.out.println("Deleted "+temp2.data+".");
			return temp2;
		}	
	}

	void displayAll()
	{
		Node current=head;
		if(current==null)
		{
			System.out.println("Empty list.");
		}
		else
		{
			while(current.next!=null)
			{
				current.display();
				current=current.next;
			}
			System.out.println(current.data);
		}
	}
}

class BasicLinkedList
{
	public static void main(String[] args) 
	{
		LinkedList L = new LinkedList();
		System.out.print("Insert first to 1,2,3,4 : ");
		L.insertFirst(1);
		L.insertFirst(2);
		L.insertFirst(3);
		L.insertFirst(4);
		L.displayAll();

		System.out.print("Insert last to 4,3,2,1 : ");
		L.insertLast(4);
		L.insertLast(3);
		L.insertLast(2);
		L.insertLast(1);
		L.displayAll();

		System.out.println("Remove first 7 times : ");
		L.deleteFirst();
		L.deleteFirst();
		L.deleteFirst();
		L.deleteFirst();
		L.deleteFirst();
		L.deleteFirst();
		L.deleteFirst();
	
		System.out.print("LinkedList : ");
		L.displayAll();

		System.out.println("Remove last 3 times : ");
		L.deleteLast();
		L.deleteLast();
		L.deleteLast();
		System.out.print("LinkedList : ");
		L.displayAll();

	}
}

/*Ouput 1

Insert first to 1,2,3,4 : 4-->3-->2-->1
Insert last to 4,3,2,1 : 4-->3-->2-->1-->4-->3-->2-->1
Remove first 7 times : 
Deleted 4.
Deleted 3.
Deleted 2.
Deleted 1.
Deleted 4.
Deleted 3.
Deleted 2.
LinkedList : 1
Remove last 3 times : 
Deleted 1.
List is empty, no elements to delete.
List is empty, no elements to delete.
LinkedList : Empty list.

*/
