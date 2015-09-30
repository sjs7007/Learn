# Dynamic Programming

1.Links
------

+ Lecture 1
	
	+ [Fibonacci, Shortest Paths](http://ocw.mit.edu/courses/electrical-engineering-and-computer-science/6-006-introduction-to-algorithms-fall-2011/lecture-videos/lecture-19-dynamic-programming-i-fibonacci-shortest-paths/)

	+ [Typed Notes](http://ocw.mit.edu/courses/electrical-engineering-and-computer-science/6-006-introduction-to-algorithms-fall-2011/lecture-videos/MIT6_006F11_lec19.pdf)
	
	+ [Handwritten Notes](http://ocw.mit.edu/courses/electrical-engineering-and-computer-science/6-006-introduction-to-algorithms-fall-2011/lecture-videos/MIT6_006F11_lec19_orig.pdf)

+ Lecture 2

	+ [Text Justification, Blackjack](http://ocw.mit.edu/courses/electrical-engineering-and-computer-science/6-006-introduction-to-algorithms-fall-2011/lecture-videos/lecture-20-dynamic-programming-ii-text-justification-blackjack/)

	+ [Typed Notes](http://ocw.mit.edu/courses/electrical-engineering-and-computer-science/6-006-introduction-to-algorithms-fall-2011/lecture-videos/MIT6_006F11_lec20.pdf)

	+ [Handwritten Notes](http://ocw.mit.edu/courses/electrical-engineering-and-computer-science/6-006-introduction-to-algorithms-fall-2011/lecture-videos/MIT6_006F11_lec20_orig.pdf)

+ Lecture 1 from CLRS Author 

    + [LCS problem](http://ocw.mit.edu/courses/electrical-engineering-a-computer-science/6-046j-introduction-to-algorithms-sma-5503-fall-2005/video-lectures/lecture-15-dynamic-programming-longest-common-subsequence/)
    + [Slides](http://ocw.mit.edu/courses/electrical-engineering-and-computer-science/6-046j-introduction-to-algorithms-sma-5503-fall-2005/video-lectures/lecture-15-dynamic-programming-longest-common-subsequence/lec15.pdf)
    + [Other links](http://ocw.mit.edu/courses/electrical-engineering-and-computer-science/6-046j-introduction-to-algorithms-sma-5503-fall-2005/video-lectures/lecture-15-dynamic-programming-longest-common-subsequence/)
+ Cormen, pg 359

2.General Structure
-------

+ Characterize the structure of an optimal solution.

+ Recursively define the value of an optimal solution.

+ Compute the value of an optimal solution, typically in a bottom-up fashion.

+ Construct an optimal solution from computed information.

3.Problems
-------

### 3.1 Rod Cutting Problem

+ Naive Recursive Solution

	**Cut-Rod(p,n)**   
	```
	if(n==0)
		return 0
	q=-1
	for i=1 to n
		q=max(q,p[i]+Cut-Rod(p,n-i))
	return q
	```

+ Memoized Version

	Store intermediate results in array.   

	**Memoized-Cut-Rod(p,n,r)**
	```
	if(r[n]>=0)
		return r[n]
	if(n==0)
		q=0
	else q=-1
		for i=1 to n
			q=max(q,p[i]+Memoized-Cut-Rod(p,n-i,r))
	r[n]=q
	return q
			q
	```

+ Bottom up version.

	Solve subproblems in topological order.   

	**Bottom-Up-Cut-Rod(p,n)**
	```
	r[0..n] array of profits
	r[0]=0
	for j=1 to n
		q=-1
		for i=1 to j
			q=max(q,p[i]+r[j-i])
			r[j]=q
	return r[n]
	```

+ Java Codes : [Recusive Solution](https://github.com/sjs7007/Learn/tree/master/Algos/DynamicProgramming/RodCutting1.java), [Memoized Solution](https://github.com/sjs7007/Learn/tree/master/Algos/DynamicProgramming/RodCutting2.java), [Bottom Up Solution](https://github.com/sjs7007/Learn/tree/master/Algos/DynamicProgramming/RodCutting3.java)

### 3.2 Mario - Problem on Hacker Earth

+ [Link](http://www.hackerearth.com/problem/algorithm/roy-and-little-mario-4/)

+ Solution 

	+ ans(1)=1,ans(2)=2,ans(3)=4

	+ ans(n>3) = keep 1 block separate and ans(n-1) + keep 2 blocks separate and ans(n-2) + keep 3 blocks separate and ans(n-3)

	![paper solution](he43Notes.jpg)

+ [Java Code Link using Bottom Up Approach](https://github.com/sjs7007/Learn/tree/master/Algos/DynamicProgramming/he43.java)

### 3.3 Knapsack Problem - Spoj

+ [Link](http://www.spoj.com/problems/KNAPSACK/)

+ Solution

	+ Recursive Solution : ans(currentCapacity,n)=max(ans(currentCapacity-size of nth item,n-1)+profit of nth item, ans(currentCapacity,n-1))

	+ i.e. return max. of [subproblem for n-1 with new capacity+ profit of nth item] and [subproblem for n-1 with old capacity]

	+ Bottom up solution

		getOptimal(size[],value[],currentCapacity,nItems,answer[][])
		```
		for i in range [0,nItems]
			for j in range [0,currentCapacity]
				if(i or j ==0)
					answer[i][j]=0
				else if(size[i-1]>j)
					answer[i][j]=answer[i-1][j]
				else
					answer[i][j]=ma(answer[i-1][j],answer[i-1][j-size[i-1]]+value[i-1])
		```

+ Java Codes : [Recursive Solution](https://github.com/sjs7007/Learn/tree/master/Algos/DynamicProgramming/KnapsackRecursive.java), [Bottom Up DP solution](https://github.com/sjs7007/Learn/tree/master/Algos/DynamicProgramming/KnapsackDP.java)

### 3.4 Martian - SPOJ

+ [Link](http://www.spoj.com/problems/MARTIAN/)

+ Solution 

	+ Recursive Solution 

		getOptimal(row,column) = max(ySum+getOptimal(b,y,row-1,column,answer),bSum+getOptimal(b,y,row,column-1,answer));

	+ i.e. return max of [including all y in this row + subproblem for (row-1,column)] and [including all b in this column + subproblem for (row,column-1)]

	+ Basic idea is start from corner end and decide whether to go left or up. If left, include all in left(y) or else all in up(b).

+ C++ Code : [Martian Memoized](https://github.com/sjs7007/Learn/tree/master/Algos/DynamicProgramming/MartianDP.cpp)  

**NOTE** : Java is too slow for this problem.

### 3.5 Mixtures - SPOJ

+ [Link](http://www.spoj.com/problems/MIXTURES/)

+ Solution

	+ Fill later

+ Paper solution :

![Mixtures1](Mixtures1.jpg)
![Mixtures2](Mixtures2.jpg)
    
+ C++ Code : [Mixtures Memoized](https://github.com/sjs7007/Learn/tree/master/Algos/DynamicProgramming/MixturesDP.cpp)

### 3.6 Max Product Cutting : GeeksForGeeks

+ [Link](http://www.geeksforgeeks.org/dynamic-programming-set-36-cut-a-rope-to-maximize-product/)

+ Solution

	+ maxProd(n)=for k in range[1,n-1], max of [k(n-k),k maxProd(n-k),maxProd(k) (n-k),maxProd(k) maxProd(n-k)]

	+ in geeks for geeks maxProd(k) * maxProd(n-k) is not considered. **WHY?** Figure out.

+ C++ Code : [Max Product Cutting](https://github.com/sjs7007/Learn/blob/master/Algos/DynamicProgramming/MaxProdCutting.cpp)

### 3.7 Min Cost Path : GeeksForGeeks

+ [Link](http://www.geeksforgeeks.org/dynamic-programming-set-6-min-cost-path/)

+ Solution

	+ DP[i][j]=cost[i][j]+min(cost[i-1][j],cost[i][j-1],cost[i-1][j-1])

	+ if(i==0 && j==0), return cost[i][j]

	+ if(i<0 or j<0), then it is not reachable and hence infinity should be returned

+ C++ Code : [Min Cost Path](https://github.com/sjs7007/Learn/blob/master/Algos/DynamicProgramming/MCP.cpp)

### 3.8 Longest Common Subsequence : GeeksForGeeks

+ [Link](http://www.geeksforgeeks.org/dynamic-programming-set-4-longest-common-subsequence/)

+ Solution

```
1) Optimal Substructure: 
Let the input sequences be X[0..m-1] and Y[0..n-1] of lengths m and n respectively. And let L(X[0..m-1], Y[0..n-1]) be the length of LCS of the two sequences X and Y. Following is the recursive definition of L(X[0..m-1], Y[0..n-1]).

If last characters of both sequences match (or X[m-1] == Y[n-1]) then
L(X[0..m-1], Y[0..n-1]) = 1 + L(X[0..m-2], Y[0..n-2])

If last characters of both sequences do not match (or X[m-1] != Y[n-1]) then
L(X[0..m-1], Y[0..n-1]) = MAX ( L(X[0..m-2], Y[0..n-1]), L(X[0..m-1], Y[0..n-2])

Examples:
1) Consider the input strings “AGGTAB” and “GXTXAYB”. Last characters match for the strings. So length of LCS can be written as:
L(“AGGTAB”, “GXTXAYB”) = 1 + L(“AGGTA”, “GXTXAY”)

2) Consider the input strings “ABCDGH” and “AEDFHR. Last characters do not match for the strings. So length of LCS can be written as:
L(“ABCDGH”, “AEDFHR”) = MAX ( L(“ABCDG”, “AEDFHR”), L(“ABCDGH”, “AEDFH”) )

So the LCS problem has optimal substructure property as the main problem can be solved using solutions to subproblems.
```

+ C++ Code : [LCS](https://github.com/sjs7007/Learn/blob/master/Algos/DynamicProgramming/LCSDP.cpp)

OR
X=[x1,x2,...,xm]
Y=[y1,y2,...,yn]
Let DP(i,j)=Length of LCS of subsequence x1,x2,..,xi and y1,y2,..,yj

```
DP(i,j)= 0 if i==0 or j==0
DP(i,j)=DP(i-1,j-1)+1 if xi=yj and i,j>0
DP(i,j)=max(DP(i-1,j),DP(i,j-1)) if i,j>0 and xi!=yj
```
### 3.9 Longest Increasing Subsequence

+ [Link](http://www.geeksforgeeks.org/dynamic-programming-set-3-longest-increasing-subsequence/)

+ Solution

	+ Each DP[i] stores length of max increasing sequence which includes data[i]

	+ DP[i] = 1 + max(DP[j]) where j<i and data[i]>data[j]

+ C++ Code : [Longest Increasing Subsequence](https://github.com/sjs7007/Learn/blob/master/Algos/DynamicProgramming/LongestIncreasingSeq.cpp)

### 3.10 ACMaker - SPOJ

+ [Link](http://www.spoj.com/problems/ACMAKER/)

+ Solution

	+ Each DP[i][j][k] stores solution for acronym char starting from i,words starting from j and k is current position inside word

	+ DP[i][j][k] 

	        = DP[i][j][newK] --> The case where you look for more no. of same character in the same word 

			+

		 DP[i+1][j][newK] --> The case where you start to look for the next characters in same word

		 	+

		 DP[i+1][j+1][0] --> The case where you look for next characters in next word

+ Java Code : [ACMAKER](https://github.com/sjs7007/Learn/blob/master/Algos/DynamicProgramming/SPOJACMAccepted.java)

### 3.11 COINS - SPOJ

+ [Link](http://www.spoj.com/problems/COINS/)

+ Solution

	+ Array size too large to store DP hence use STL maps. [Example](https://github.com/sjs7007/Learn/blob/master/DataStructures/mapTest.cpp)

	+ DP[n] = max(n,DP[n/2]+DP[n/3]+DP[n/4])

+ C++ Code : [COINS](https://github.com/sjs7007/Learn/blob/master/Algos/DynamicProgramming/COINSMap.cpp)

### 3.12 LISA - SPOJ

+ [Link](http://www.spoj.com/problems/LISA/)

+ Solution

	+ DP[i,j]=max for all k=i+1 to j-1, where j=last index in array is [DP[i,k-1] kth operation DP[k+1,j]]

+ NOTE : free call case being given as >0 instead of correct >=0 was causing TLE.

+ C++ Code : [LISA](https://github.com/sjs7007/Learn/blob/master/Algos/DynamicProgramming/LISASubmit.cpp)

### 3.13 Coin Change Problem : 
+ Making Change. You are given n types of coin denominations of values v(1) < v(2) < ... < v(n) (all integers). Assume v(1) = 1, so you can always make change for any amount of money C. Give an algorithm which makes change for an amount of money C with as few coins as possible. [on problem set 4]
+ [Solution Video](dp_2.swf)
+ Select a coin with value v_i, coin count increment by 1 and then solve subproblem for C-selected coin vale add add to coin count.
+ DP(i)=1+min(DP(C-v_i)).
+ Running Time : C subproblems, each requiring minimization over n different terms. Hence O(nC).

### 3.14 Maximum Value Contiguous Subsequence. 
+ Given a sequence of n real numbers A(1) ... A(n), determine a contiguous subsequence A(i) ... A(j) for which the sum of elements in the subsequence is maximized.
+ [Solution Video](dp_1.swf)
+ Let DP(i) be the subsequence which ends at i and includes element i. 
```
DP(i) = 0 if i==0
      = max(DP(i-1)+A[i],A[i]) else
```
+ The solution implies that for each ith position either you select the ith element and add it list or start a new window here. 
+ Example <10,3,4,-18,100>, DP(3) will be 10+3+4 = 17. For DP(4) either we can include A[4] with solution of DP(3) or start a new list here. First one will result in -1 vs other in -18, hence we pick 1st option and DP(4)=-1 and includes <10,3,4,-18>. For DP(5) we can make it <10,3,4,-18> or <100>. Since later has a higher sum, we select that. 
+ Running time : n subproblems, each takes O(1) time. Hence in O(n) time.
+ Ans will be in max of all DP(i)s. 

### 3.15 Longest Increasing Subsequence 
+  Given a sequence of n real numbers A(1) ... A(n), determine a subsequence (not necessarily contiguous) of maximum length in which the values in the subsequence form a strictly increasing sequence. [on problem set 4]
+  [Solution Video](dp_2.swf)
+  Let DP(i) be the longest increasing subsequence which ends at i and includes element i.
+  For ith element you have 2 choices then : Either extend list if possible or start new list here.
```
DP(j)=1+max(DP(i)), i<j,A[i]<A[j]. If no such element found, only jth element is added. 
```
+  Running time : n subproblems, O(n) subproblems, each takes O(n) time. So O(n^2) time.
+  Ans will be in max of all DP(j)s.

### 3.16 Optimal Strategy of a game 
+ Consider a row of n coins of values v(1) ... v(n), where n is even. We play a game against an opponent by alternating turns. In each turn, a player selects either the first or last coin from the row, removes it from the row permanently, and receives the value of the coin. Determine the maximum possible amount of money we can definitely win if we move first.
+ [Solution Video](dp_10.swf)
+ Let DP(i,j)=solution of subproblem for array of size A(i,j).
+ Opponent is as smart as us so we assume he will use the same strategy as us. 
```
DP(i,j)=max(A[i]+DP(min(DP(i+2,j),DP(i+1,j-1))),A[j]+DP(min(DP(i+1,j-1),DP(i,j-2)))

j-i >=2
```
+ Running Time : O(n^2) subproblem.... why? O(n^2) substrings. O(1) choice. O(n^2) hence. 
+ ![paper solution](OptimalStrategy.jpg)

### 3.17 Counting Boolean Parenthesizations 
+ You are given a boolean expression consisting of a string of the symbols 'true', 'false', 'and', 'or', and 'xor'. Count the number of ways to parenthesize the expression such that it will evaluate to true. For example, there are 2 ways to parenthesize 'true and false xor true' such that it evaluates to true.
+ [Solution Video](dp_9.swf)
+ Let the input be in an array of A[1..n]
+ Let DP(i,j) = ans for substring i,j.
+ Let F(i,j) = number of ways to parenthesize such that always false.
```
DP(i,j)= sum of all such k betwen (i,j) = DP(i,k-1) * DP(k+1,j) if A[k]=and
	= DP(i,k-1) * DP(k+1,j) + DP(i,k-1) * F(k+1,j) + F(i,k-1) * DP(k+1,j) if A[k]=or
	= DP(i,k-1) * F(k+1,j) + F(i,k-1) * DP(k+1,j) if A[k]=or 
```
+ Running time : O(n^2) subproblems... n things to sum up?
+ My approach... close but wrong.
+ ![paper solution](CountBoolean.jpg)
+ 

### 3.18 Company Party : CLRS
+ [Link](http://mypathtothe4.blogspot.com/2013/03/dynamic-programming-company-party.html)
```
DP(Node N)
{
	if(N has no children) //base case
	{  
		return(max(0,N.convRating);
	}
	else
	{
		//either you can take node at current level and grandchildren or 
		//node at children level
		return(max(summation of DP(Ci) where i is ith child of N for all i,
		N.convRating+summation of DP(i) where i is ith grandchild of N for all i)))
	}
}
```

### 3.19 Longest Palindromic Substring 
+ [Link](http://articles.leetcode.com/2011/11/longest-palindromic-substring-part-i.html)
```
Let table[i][j]=true if substring(i,j) is a palindrome. Then,

Base Case :
//strings of length 1
table[i][i]=true

//strings of length 2
table[i][i+1=true if char[i]==char[i+1]

table[i][j]=true if char[i]==char[j] and table[i+1][j-1]==true.
```

+ code from leet code : 

```
string longestPalindromeDP(string s) {
  int n = s.length();
  int longestBegin = 0;
  int maxLen = 1;
  bool table[1000][1000] = {false};
  for (int i = 0; i < n; i++) {
    table[i][i] = true;
  }
  for (int i = 0; i < n-1; i++) {
    if (s[i] == s[i+1]) {
      table[i][i+1] = true;
      longestBegin = i;
      maxLen = 2;
    }
  }
  for (int len = 3; len <= n; len++) {
    for (int i = 0; i < n-len+1; i++) {
      int j = i+len-1;
      if (s[i] == s[j] && table[i+1][j-1]) {
        table[i][j] = true;
        longestBegin = i;
        maxLen = len;
      }
    }
  }
  return s.substr(longestBegin, maxLen);
}
```

### 3.20 Palindromic Subsequence 
+ [Link to geeks for geeks](http://www.geeksforgeeks.org/dynamic-programming-set-12-longest-palindromic-subsequence/)
+ Let DP(i,j) return the length of longest possible palindromic subsequnce for substring(i,j)
```
Base Case : 
DP(i,i)=1
DP(i,i+1)=1 if char[i]==char[i+1]

if(char[i]==char[j])
	DP(i,j)=2+DP(i+1,j-1)
else 
	DP(i,j)=max(DP(i+1,j),DP(i,j-1))
```


4.Notes from CLRS - Lowest Common Subsequence
--------

Dynamic Programming
-----
+ Design technique like Divide and Conquer. 

1.LCS Problem
-----
+ Given two seq x[1..m] and y[1..n], find a longest seq common to both. 
+ Skipping characters allowed, order should be maintained. 
+ Example X : [a,b,c,b,d,a,b] and Y : [b,d,c,a,b,a] have bdab,bcab etc has common. 
+ Common Subsequence = LCS(X,Y). Functional notation, but not function ? 

### 1.1 Brute Force Algorithm
------
+ Check every subsequence of X[1..m] to see if it is a subsequence of Y[1..n] as well. 
+ No. of subsequences of x = 2^m. Select or reject each element from X. Each bit vector of length m can correspond to a subseq.
+ Complexity = O(n*2^m). Exponential time. 

### 1.2 Simplification.
-----
+ Consider first length of LCS(X,Y) and later extend the algo to find the LCS. 

### 1.3 Normal Algo with memoization.
-------
+ Strategy : Consider prefixes of X and Y. 
+ Define C[i,j]=|LCS(x[1..i],y[1..j])|. Then C[m,n]=|LCS(x,y)|
+ **Theorem** : 
    C[i,j] = c[i-1,j-1]+1 if x[i]==y[j] 
           = max{c[i,j-1],c[i-1,j]} else
+ **Proof:**

**Case 1:** x[i]==y[j]
Let Z[1..k]= LCS(X[1..i],Y[1...j]) where C[i,j]=k. 
Then, Z[k]=X[i]=Y[j] else Z could be extended. Thus Z[1,..,k-1] is common sequence of x[1..i-1] and y[1..j-1].

**Claim:** Z[1,..,k-1] is LCS of X[1,..,i-1] and Y[1,..,j-1]. 

Suppose W is a longer CS, that is 
|W| > k-1
Cut and paste argument : W.append(Z[k]) is a CS of X[1..i] and Y[1...j] with length >k. Contradiction. 

Thus, C[i-1,j-1]=k-1. Hence, C[i][j]=C[i-1,j-1]+1 in this case. 

Other cases can be done similarly.

Apply overlapping subproblems here. LCS consists of mn distinct subproblems. (i goes from 1 to m and j goes from 1 to n. So m*n.)

**DP Change:**
+ Use a memo table to store entries for c[i][j]. If c[i][j]!=null calculate and store else just return c[i][j] value.

Running Time : Theta(mn) because only mn calls are recursive and rest are memoized calls. 
Space Complexity : Theta(mn).

### 1.4 DP using bottom up
+ Time : Theta(mn)
+ Space : Theta(mn) or min(m,n)+theta(1)

### 1.5 Dynamic Programming Hallmarks
+ **Optimal Substructure Property:** An optimal solution to a problem(instance) contains optimal solution to subproblems. 
Example : In the context of LCS,  if z=LCS(X,Y) then any prefix of z is a LCS of a prefix of x and a prefix of y. 
+ **Overlapping Subproblems:**  A recursive solution contains a small number of distinct subproblems repeated many times. 
