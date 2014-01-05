// Binary Search Tree, Cormen,pg286

class Node
{
	Node left,right,p;
	int key;

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
		Node newNode = new Node(z);
		Node y = null;
		Node x = root;

		while(x!=null)
		{
			y = x;
			if(newNode.key<x.key)
			{
				x=x.left;
			}
			else
			{
				x=x.right;
			}
		}

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

	void iterativeMin()
	{
		Node x = root;
		if(x==null)
		{
			System.out.println("No min. value,empty tree.");
		}
		else
		{
			while(x.left!=null)
			{
				x=x.left;
			}
			System.out.println("Min. value : "+x.key);
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

		int k=14;
		Node find = B.recSearch(B.root,k);
		if(find==null)
		{
			System.out.println("No node with key "+k+".");
		}
		else
		{
			System.out.println("Node found.");
		}

		B.iterativeMin();
	}
}