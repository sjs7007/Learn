# Binary Search Tree

1.Links
-------

+ [MIT Lecture](http://ocw.mit.edu/courses/electrical-engineering-and-computer-science/6-006-introduction-to-algorithms-fall-2011/lecture-videos/lecture-5-binary-search-trees-bst-sort/)
+ [MIT Recitation](http://ocw.mit.edu/courses/electrical-engineering-and-computer-science/6-006-introduction-to-algorithms-fall-2011/recitation-videos/recitation-5-recursion-trees-binary-search-trees)
+ [MIT Lecture Notes](http://ocw.mit.edu/courses/electrical-engineering-and-computer-science/6-006-introduction-to-algorithms-fall-2011/lecture-videos/MIT6_006F11_lec05.pdf)
+ Cormen, pg 286

2.Psuedo Code
------

+ **Binary Search Tree Property** : If x is a node in a BST and y is in left subtree of x, then y.key<=x.key. Similarly if y is in right subtree of x, then y.key>=x.key
+ Insertion in tree of height h takes order O(h) time. 


+ Inorder-Tree-Walk(x)   

	```
	if(x!=null)
		Inorder-Tree-Walk(x.left)
		print x.key
		Inorder-Tree-Walk(x.right)
	```

	+ Prints the keys of BST in sorted order.

	+ Similary preorder walk(VLR) and postorder walk(LRV).

+ Recursive-Tree-Search(x,k)   

	+ x = pointer to root of tree
	+ k = key value being searched
	
	```
	if(x==null || x.key==k)
		return x
	if(k<x.key)
		return Recursive-Tree-Search(x.left,k)
	else return Recursive-Tree-Search(x.right,k)
	```

+ Iterative-Tree-Search(x,k)  

	```
	while(x!=null and k!=x.key)
		if(k<x.key)
			x=x.left
		else x=x.right
	return x
	```
+ min : keep going left till left!=null

+ max : keep going right till right!=null

+ Successor 

	![Successor](BST1.png)	

	+ Case 1 : If there is right subtree then the min value in right subtree will be succ. Succ(15)--Min(18)=17
			

	+ Case 2 : If there is no right subtree, the succ will be the lowest ancestor of x whose left child is also an ancestor of x.
				Succ(13)--->7---->6--->15

	```
	if(x.right!=null)
		return min(x.right)
	y = x.p
	while(y!=null and x==y.right) //will continue till x is left child of y
		x=y 
		y=y.p
	return y
	```

+ Predecessor

	![Predecessor](BST1.png)

	+ Case 1 : If there is left subtree then the max value in left subtree will be pred. Pred(6)--max(3)=4

	+ Case 2 : If there is no left subtree, then the pred will be lowest ancestor of x whose right child is also an ancestor of x.
				Pred(9)--->13--->7

	```
	if(x.left!=null)
		return max(x.left)
	y=x.p
	while(y!=null and x==y.left) 
		=y
		y=y.p
	return y
	```




