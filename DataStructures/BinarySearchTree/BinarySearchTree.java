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
		while(!Q.isEmpty())
		{
			Node u = Q.poll(); //dequeue

			for(int i=0;i<u.spaceCount;i++)
			{
				System.out.print("\t");
			}

			System.out.print(u.key+" ");
			count--;
			if(count==0)
			{
				System.out.println();
			}
			if(u.left!=null)
			{
				count++;
				Q.add(u.left);
				if(u.spaceCount==2)
				{
					u.spaceCount=u.p.spaceCount;
					if(u==u.p.left)
					{
						u.spaceCount--;
					}
					else
					{
						u.spaceCount++;
					}
				}
				u.left.spaceCount=u.spaceCount-1;
			}
			if(u.right!=null)
			{
				count++;
				Q.add(u.right);
				if(u.spaceCount==2)
				{
					u.spaceCount=u.p.spaceCount;
					if(u==u.p.left)
					{
						u.spaceCount--;
					}
					else
					{
						u.spaceCount++;
					}
				}
				u.right.spaceCount=u.spaceCount+1;
				if(u.left!=null)
				{
					u.right.spaceCount = 2;
				}
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
