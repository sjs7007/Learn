// Binary Search Tree, Cormen,pg286

import java.util.*;

class Node
{
	Node left,right,p;
	int key;
	int spaceCount; //for visualization

	Node(int x)
	{
		key=x;
	}
}

class BST
{
	Node root;

	void insert(int z)
	{
		Node y = null;
		Node x = root;

		while(x!=null)
		{
			y = x;
			if(z<x.key)
			{
				x=x.left;
			}
			else
			{
				x=x.right;
			}
		}
		
		Node newNode = new Node(z);
		newNode.p=y;

		if(y==null) //empty Tree
		{
			root = newNode;
		}
		else if(newNode.key<y.key)
		{
			y.left = newNode;
		}
		else
		{
			y.right = newNode;
		}
	}

	void inorderTraversal(Node x) //pass root node
	{
		if(x!=null)
		{
			inorderTraversal(x.left);
			System.out.print(x.key+" ");
			inorderTraversal(x.right);
		}
	}

	Node recSearch(Node x,int k) //recursive Search
	{
		if(x==null  || k==x.key)
		{
			return x;
		}
		else
		{
			if(k<x.key)
			{
				return(recSearch(x.left,k));
			}
			else
			{
				return(recSearch(x.right,k));
			}
		}
	}

	Node iterativeMin(Node x)
	{
		while(x.left!=null)
		{
			x=x.left;
		}
		return x;
	}

	Node iterativeMax(Node x)
	{
		while(x.right!=null)
		{
			x=x.right;
		}
		return x;
	}

	Node successor(Node x)
	{
		if(x.right!=null)
		{
			return iterativeMin(x.right);
		}
		else
		{
			Node y=x.p;
			while(y!=null && x==y.right)
			{
				x=y;
				y=y.p;
			}
			return y;
		}
	}

	Node predecessor(Node x)
	{
		if(x.left!=null)
		{
			return iterativeMax(x.left);
		}
		else
		{
			Node y=x.p;
			while(y!=null && x==y.left)
			{
				x=y;
				y=y.p;
			}
			return y;
		}
	}

	void visualizeTree() //Seems to work
	{
		Queue<Node> Q = new LinkedList<Node>();
		Q.add(root);
		root.spaceCount=7;
		int count=1; //to keep track of new line
		int leftMost=-1;
		for(int i=0;i<root.spaceCount;i++)
		{
			System.out.print("\t");
		}
		if(root.left!=null)
		{
			leftMost = root.spaceCount-1;
		}
		else
		{
			leftMost=root.spaceCount+1;
		}
		while(!Q.isEmpty())
		{
			Node u = Q.poll(); //dequeue

			/*for(int i=0;i<u.spaceCount;i++)
			{
				System.out.print("\t");
			}*/

	//		System.out.print(u.key+"-->"+u.spaceCount+" ");
			for(int i=0;i<u.spaceCount-leftMost;i++)
			{
				System.out.print("\t");
			}
			System.out.print(u.key+"("+u.spaceCount+","+leftMost+")");
			count--;
			if(count==0)
			{
				System.out.println();
				//				System.out.print("Printed "+leftMost+" tabs.");
			}
			if(u.left!=null)
			{
				Q.add(u.left);
				u.left.spaceCount=u.spaceCount-1;
//				System.out.println("["+u.left.spaceCount+"]");
				if(count==0)
				{
					leftMost=u.left.spaceCount;
//					System.out.print("leftmost = "+leftMost);
					for(int i=0;i<leftMost;i++)
					{
						System.out.print("\t");
					}
				}
				count++;
			}
			if(u.right!=null)
			{
				Q.add(u.right);
				u.right.spaceCount=u.spaceCount+1;
//				System.out.println("["+u.right.spaceCount+"]");

				if(count==0)
				{
					leftMost=u.right.spaceCount;
//					System.out.print("leftmost = "+leftMost);
					for(int i=0;i<leftMost;i++)
					{
						System.out.print("\t");
					}
				}
				count++;
			}
			
		}
	}


}

class BinarySearchTree
{
	public static void main(String[] args) 
	{
		BST B = new BST();
		B.insert(1);
		B.insert(13);	
		B.insert(43);
		B.insert(43);
		B.insert(13);
		B.insert(3);
		B.insert(144);

		System.out.print("Inorder Traversal : ");
		B.inorderTraversal(B.root);
		System.out.println();

		int k=13;
		Node find = B.recSearch(B.root,k);
		if(find==null)
		{
			System.out.println("No node with key "+k+".");
		}
		else
		{
			System.out.println("Node with key "+k+" found.");
		}

		System.out.println("Min. Value : "+B.iterativeMin(B.root).key);
		System.out.println("Successor of "+k+" : "+B.successor(B.recSearch(B.root,k)).key);
		System.out.println("Predecessor of "+k+" : "+B.predecessor(B.recSearch(B.root,k)).key);
		B.visualizeTree();
	}
}
