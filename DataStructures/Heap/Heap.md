# Heap 

1.Links
----
+ [MIT Video](http://ocw.mit.edu/courses/electrical-engineering-and-computer-science/6-006-introduction-to-algorithms-fall-2011/lecture-videos/lecture-4-heaps-and-heap-sort/)
+ [MIT Slides](http://ocw.mit.edu/courses/electrical-engineering-and-computer-science/6-006-introduction-to-algorithms-fall-2011/lecture-videos/MIT6_006F11_lec04.pdf)
+ Cormen, pg 151

2.Brief Description
--------
![Heap](Heap1.png)

3.Psuedo Codes
------

### 3.1 Max-Heapify(A,i)

+ Heap size : Although A[1..A.length] may contain numbers, only the elements in A[1...A.heap-size], where 0<=A.heap-size<=A.length are valid elements of the heap.

+ parent(i)=return i/2

+ left(i)=return 2i

+ right(i)=return 2i+1

+ **Assumption** : Left and right children are max heaps but A[i] maybe smaller than its children thus violating max heap property.

+ largest : index of largest value among left,right and parent.

Max-Heapify(A,i)
```C
l=left(i)=2i
r=right(i)=2i+1
if(l<=A.heap-size and A[l]>A[i]) //if right child is greater than root,set that index to largest else to parent
	largest=l
else  largest=i
if(r<=A.heap-size and A[r]>A[i]) 
	largest=r

if(largest!=i)
	A[i]<-->A[largest]
	Max-Heapify(A,largest)
```



