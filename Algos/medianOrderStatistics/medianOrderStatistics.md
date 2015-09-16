# Median Order Statistics 

1.Links
------
+ [MIT Video](http://ocw.mit.edu/courses/electrical-engineering-and-computer-science/6-046j-introduction-to-algorithms-sma-5503-fall-2005/video-lectures/lecture-6-order-statistics-median/)
+ [MIT Slides](http://ocw.mit.edu/courses/electrical-engineering-and-computer-science/6-046j-introduction-to-algorithms-sma-5503-fall-2005/video-lectures/lecture-6-order-statistics-median/lec6.pdf)
+ [Other links](http://ocw.mit.edu/courses/electrical-engineering-and-computer-science/6-046j-introduction-to-algorithms-sma-5503-fall-2005/video-lectures/lecture-6-order-statistics-median/)

2.Order Statistics
-----
+ Given n elements in an array, find the kth smallest element(element of rank k).
+ Naive algo : sort and return kth element. Heap sort, merge sort take nlgn time. Goal is to therefore get it in lesser time. 
+ k=1, minimum. k=2, maximum. Both can be done in linear time by simple scan. 
+ Median : k=floor[(n+1)/2] and ceil[(n+1)/2]

3.Randomized Divide and Conquer
------

### 3.1 

Partition array recursively till the partition position==rank.

```
Rand-Select(A,p,q,i):
    //return ith smallest in A[p..q] 
	if(p==q), then return A[p]
	r = randPartition(A,p,q)
	k = r-p+1 //k=rank(A[r])
    if(i==k) then return A[r]
    else if(i<k)
        return Rand-Select(A,p,r-1,i)
    else
        return Rand-Select(A,r+1,q,i-k) //i-k because left k elements discarded
```

**Analysis:**

Assumption : all elements are distinct. 

Lucky case example : 1:9, ideal 1:1. Similar to quicksort. 
