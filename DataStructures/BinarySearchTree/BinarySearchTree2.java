// Binary Search Tree, Cormen,pg286

import java.util.*;

class Node
{
	Node left,right,p,pred,succ;
	int key;
	int spaceCount; //for visualization
	int level=0;

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
        Node pred = null,succ=null;

		while(x!=null)
		{
			y = x;
			if(z<x.key)
			{
				succ = x;
                x=x.left;
			}
			else
			{
				pred = x;
                x=x.right;
			}
		}
		
		Node newNode = new Node(z);
		newNode.p=y;
        newNode.pred = pred;
        newNode.succ = succ;

        if(pred!=null)
            pred.succ = newNode;

        if(succ!=null)
            succ.pred = newNode;

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

	void successor(Node x)
	{
		/*if(x.right!=null)
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
		}*/
        if(x.succ!=null)
        {
            System.out.println("Sucessor of "+x.key+" is : "+x.succ.key+".");
        }
        else
        {
            System.out.println(x.key+" has no sucessor.");
        }
	}

	void predecessor(Node x)
	{
		/*if(x.left!=null)
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
		}*/
        if(x.pred!=null)
        {
            System.out.println("Prdeceessor of "+x.key+" is : "+x.pred.key+".");
        }
        else
        {
            System.out.println(x.key+" has no predecessor.");
        }

	}
}

class BinarySearchTree2
{
	public static void main(String[] args) 
	{
		BST B = new BST();
		/*B.insert(1);
		B.insert(13);	
		B.insert(43);
		B.insert(43);
		B.insert(13);
		B.insert(3);
		B.insert(144);

		B.insert(20);
		B.insert(40);
		B.insert(30);
		B.insert(50);*/
        int A[] = {7,1,2,3,5,4,6};
        
        for(int i=0;i<A.length;i++)
        {
            B.insert(A[i]);
        }

        
	    System.out.print("Inorder Traversal : ");
		B.inorderTraversal(B.root);
		System.out.println();

		/*int k=13;
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
		B.visualizeTree();*/

        for(int i=0;i<A.length;i++)
        {
           B.successor(B.recSearch(B.root,A[i]));
           B.predecessor(B.recSearch(B.root,A[i]));
        }
	}
}
