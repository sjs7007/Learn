// Binary Search Tree, Cormen,pg286

import java.util.*;

class Node
{
	Node left,right,p,succ;
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
        Node newPred = x;
        Node newSucc = x;

		while(x!=null)
		{
			y = x;


//          System.out.println(" z - x.key , z - newSucc.key x.key z "+ (z - x.key)+" "+(z-newSucc.key)+" "+x.key+" "+z);

            System.out.println(x.key+" "+newSucc.key+" "+z);
            if(  (x.key-z)<=(newSucc.key-z) && x.key >=z)
         //   if(x.key>=newSuc.)
            {
           //     System.out.println(x.key+" replacing "+newSucc.key);
                newSucc = x;
            }
            if(x.key<=z && x.key>=newPred.key)
            {
                newPred=x;
            }
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

        if(newPred!=null)
        {
          newPred.succ = x;
        }
        newNode.succ = newSucc;

    //    if(newSucc!=null)
      //      System.out.println(newSucc.key);

    //    System.out.println("Successor is : "+newSucc.key);
     //   System.out.println("Predecessor is : "+newPred.key);


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
		int leftMost=-1;
		int cl=-1;
		while(!Q.isEmpty())
		{
			Node u = Q.poll(); //dequeue	
	
			if(u.level!=cl)
			{
				cl=u.level;
				System.out.println();
				leftMost=u.spaceCount;
				for(int i=0;i<leftMost;i++)
				{
					System.out.print("\t");
				}
			}

			for(int i=0;i<u.spaceCount-leftMost;i++)
			{
				System.out.print("\t");
			}

			System.out.print(u.key+" ");
			
			if(u.left!=null)
			{
				Q.add(u.left);
				u.left.spaceCount=u.spaceCount-1;
				u.left.level=u.level+1;
			}
			if(u.right!=null)
			{
				Q.add(u.right);
				u.right.spaceCount=u.spaceCount+1;
				u.right.level=u.level+1;
			}
		}
	}


}

class BinarySearchTreeMod
{
	public static void main(String[] args) 
	{
		BST B = new BST();

        /*
		B.insert(1);
		B.insert(13);	
		B.insert(43);
		B.insert(43);
		B.insert(13);
		B.insert(3);
		B.insert(144);

		B.insert(20);
		B.insert(40);
		B.insert(30);
		B.insert(50);

        B.insert(70);
        */
        //int A[]={1,13,43,43,13,3,144,20,40,30,50,70};
        
       int A[]={13,5,4,3,2,1,8,7,6};

        for(int i=0;i<A.length;i++)
        {
            B.insert(A[i]);
        }

		System.out.print("Inorder Traversal : ");
		B.inorderTraversal(B.root);
		System.out.println();
        
		int k=70;
		/*Node find = B.recSearch(B.root,k);
		if(find==null)
		{
			System.out.println("No node with key "+k+".");
		}
		else
		{
			System.out.println("Node with key "+k+" found.");
		}
        */
		System.out.println("Min. Value : "+B.iterativeMin(B.root).key);

        for(int i=1;i<A.length;i++)
        {
            k=A[i];
            Node temp = B.recSearch(B.root,k).succ;
            if(temp!=null)
		        System.out.println("Successor of "+k+" : "+temp.key);
            else
                System.out.println("Key "+k+" has no sucessor.");
         //   System.out.println("Predecessor of "+k+" : "+B.predecessor(B.recSearch(B.root,k)).key);
        }
                

        //	B.visualizeTree();
	    
    }
}
