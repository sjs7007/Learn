# Red Black Tree

1.Links
------

+ [MIT OCW Lecture](http://ocw.mit.edu/courses/electrical-engineering-and-computer-science/6-046j-introduction-to-algorithms-sma-5503-fall-2005/video-lectures/lecture-10-red-black-trees-rotations-insertions-deletions/)
+ [MIT Lecture Notes](http://ocw.mit.edu/courses/electrical-engineering-and-computer-science/6-046j-introduction-to-algorithms-sma-5503-fall-2005/video-lectures/lecture-10-red-black-trees-rotations-insertions-deletions/lec10.pdf)
+ [Other related stuff](http://ocw.mit.edu/courses/electrical-engineering-and-computer-science/6-046j-introduction-to-algorithms-sma-5503-fall-2005/video-lectures/lecture-10-red-black-trees-rotations-insertions-deletions/)
+ (Red notes double circle in vid,black single circle)

2.Balanced Search Trees
-----
+ Search tree structure maintaining dynamic set of n elements using tree of height O(lgn).
+ Need not be necessarily binary. 
+ Examples : AVL Tree, 2-3 trees,2-3-4 trees,B trees, red black trees(Binary Search tree).
+ Treaps??? 

3.Red Black Trees 
------
+ Always guaranteed to have height lgn.
+ Binary search tree with additional info, color field. Each node can be red or black colored. 

### 3.1 Red-black properties
+ Every node is either red or black. 
+ The root and the leaves(nils) are all black. 
+ Every red node has a black parent. 
+ All simple paths from a node x to a descendeant leaf of x have same number of black nodes on it = black-height(x).
black-height(x) does not include x itself.

+ Black-height(x) = no of black nodes in path from x to a descendant leaf excluding x itself. 
+ These properties force the tree to maintain a height of lgn.

PS : **Simple paths** are paths which dont repeat any vertices. 

### 3.2 Example 
+ Cormen, pg 310. Put image here later. 
+ ![ex](redblacktree.png)

### 3.3 Height of Red-black tree
+ Red black tree with n keys has height h <= 2lg(n+1) = O(lgn) [Proof by induction in CLRS]
+ Diagramatic/Intuition based proof(check lecture slides): 
    + Merge each red node with its black parent. 
    + 2-3-4 tree obtained. After merging all leaf nodes are at the same height.  
    
    2-3-4 Tree
    + Every internal node has between 2-4 children.
    + Every leaf has same depth, in this particular case, black-height(root)

+ General fact : No. of leaves = no. of internal nodes + 1. Proof is by induction. Holds only if every iternal node has branching factor of 2. 
+ Let h''=height of merged tree
+ h'' tree, number of leaf nodes belongs to [2^h'',4^h'']
+ # of leaves from earlier = n+1

+ n+1 belongs to [2^h'',4^h'']. Take lg to get h<=lg(n+1)
+ h'' >= h/2 from property 3(at most half of nodes on any root to leaf path are red).
+ So, h <= 2lg(n+1)
+ Since height h=O(lgn), queries on a red black tree will take O(lgn) time in a red black tree.

### 3.4 Operations
+ Queries : Search. O(lgn).
+ Updates : Insertion and Deletion. 

+ BST Operation
+ Color changes
+ restructuring of links via rotations


