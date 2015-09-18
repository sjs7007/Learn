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

### 3.1 Rand Select 

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

Lucky case example : 1:9, ideal 1:1 split. 
T(n)<=T(9n/10)+Theta(1) => T(n)=Theta(n) (Use Master Method)

Unlucky Case : T(n)=T(n-1)+Theta(n)=Theta(n^2)

**Formal Analysis: **
+ 21m 33s or look at [slides](lec6.pdf). Expected time calculation using indicator random variable. 
+ Similar to quicksort except only 1 branch is taken here while in quicksort both branches are recursively called. 
+ Expected : Theta(n), worst case: Theta(n^2)

### 3.2 Worst Case Linear Time Order Statistics
+ Split input into floor(n/5) groups of 5 and 1 group of n%5 elements left. Find median of each group using insertion sort. 
+ Find median of ceil(n/5) medians using deterministic select.
+ Use the median as pivot. Check slides/nb for analysis. Slides have floor analysis, textbook ceil. Textbook simpler. 
+ Worst case running time : O(n). But the constant factor involved is large and hence this algorithm is practically not used. 
