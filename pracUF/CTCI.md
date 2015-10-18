# Chapter 1 : Arrays and Strings

##1.1

Using Data Structure 
+ Hashtable with hash key has char value and set to all false by default. If found in string, check first in hash table if already 
true, return duplicate present else set to true and continue. 
+ Complexity : O(n) assuming hash table has O(1) lookup.

No additional DS
+ Sort the entire array in O(n*logn) time using QuickSort. 
+ Check entries in O(n) time. If two conscecutive have same, return duplicate present else continue.
+ Return false

##1.2 

```
import java.util.*;

char s[] = "this is a string";
for(int i=s.length;i>=s.length/2;i--) {
	char temp = s[i];
	s[i]=s[s.length-1];
	s[s.length-i]=temp;
} 
System.out.println(Arrays.toString(s));
```

^ first attempt 

mistakes corrected : 

```
import java.util.*;

char s[] = "this is a string".toCharArray(); //1
for(int i=s.length-1;i>=s.length/2;i--) { //2
	char temp = s[i];
	s[i]=s[s.length-i-1]; //3
	s[s.length-i-1]=temp; //4
} 
System.out.println(Arrays.toString(s));
```

###1.3

Method 1 : Hashmap
Create 1 hashmap with range as that of ascii values all intialized to 0. Whenever char encountered in string 1, increment. Repeat for all chars in 1. Decrement whenever char encountered in string 2. Repeat for all chars in 2.

Complexity : O(n)

Method 2 : Sort both
Then compare. 
Complexity : O(n*lg(n)+n)=(n*lg(n))

###1.4

Method 1 : put %20 and move other chars each time space encountered 
Complexity : O(n^2)

move n-1 words,n-2,n-3,...1=O(n^2)

Method 2 : start from end. This way have to move only one word at a time.

Find last word : O(n)
Then spacing to %20 : O(n)

```
import java.util.*;

char ip[] = "Mr John Smith    ".toCharArray();
int len=13,nSpace=0;
for(int i=0;i<len;i++)
{
	if(ip[i]==' ')
	{
		nSpace++;
	}	
}
int copyIndex=ip.length-1;
for(int i=len;i>=0;i--) //#1 : should start from len-1
{
	if(ip[i]==' ')
	{
		ip[copyIndex]='0';
		ip[copyIndex-1]='2' //#2 : forgot semicolon
		ip[copyIndex-2]='%';
		copyIndex=copyIndex-3;
	}
	else 
	{
		ip[copyIndex]=ip[i];
		copyIndex--;
	}
}
System.out.println(Arrays.toString(ip));

```

##1.5

Method 1 : Generate compressed string. If < original, return compressed else original. 
Complexity : O(n)

^ WRONGGGGGGGGGGG Complexity
Complexity will be O(n+k^2) if normal string is used instead of stringbuffer since appending takes O(n^2) time in normal string.
k=number of character sequences. Hene use StringBuffer instead. 

Actually StringBuilder seems even better thhan using StringBuffer for non-syncronized code : http://stackoverflow.com/questions/2439243/what-is-the-difference-between-string-and-stringbuffer-in-java

Method 2 : Run through string and check beforehand if compressed string will be smaller than actual. If no, return original string.
Else :
Generate compressed String using StringBuilder and return.

##1.6 Rotate 2-D arrray

http://stackoverflow.com/questions/42519/how-do-you-rotate-a-two-dimensional-array

<COME-BACK-LATER>

##1.7 Set 0 entire row/column

Method 1 : Naive approach using additional matrix.
Time and space complexity both O(m*n).

Method 2 : Boolean flag matrix
O(m*n) time
O(m+n) space : two boolean array row[] col[] corresponding to row and column dimensions

Run through the matrix first and if 0 found in x[r][c], set
row[r] and col[c] to true.
Assume you have a method isSubstring which checks if one word is a substring of
another. Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using
only one call to isSubstring (i.e., “waterbottle” is a rotation of “erbottlewat”).

Then use the the two boolean array to set rows and columns to zeros.

Method 3 : O(1) space.
Use 1st row and column like the boolean arrays for all rows and columns except 1st. For the 1st we check in advance and use two separate variables.

##1.8 
Question : Assume you have a method isSubstring which checks if one word is a substring of
another. Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using
only one call to isSubstring (i.e., “waterbottle” is a rotation of “erbottlewat”).

waterbottle 
x: er
y : bottlewat
xyxy: erbottlewaterbottlewat

if given string is substring  of string+string, then rotation, else not.

Check book for better explanation. 

# Chapter 2 : Linked List

#2.1 : In notebook

#2.2
Question : kth to last element of singly linked list

Method 1 : Traverse till end of list to get n=count of elements in list. Then for kth to last just start traversing from begining with count=1, stop when count=n-k and return. 

Take care than k<=n.

Complexity : O(n)

-----
Textbook methods : 

#1 : Recursion with printing  
Traverse till end of list. Set counter to 0 when at end of list. start incrementing on return. When return value=k, print the element.

#2 : Recursion with node return
Use wrapper class to create new DS with both node and counter value.

#3 : Use two runners k distance apart. One will start at head, other at head+k. Increment both by 1 each time. When x+k=n, for pointer two, pointer 1 will be k distance away from n and hence that is the node to be returned.

#2.3 
Question : Delete node in middle of linked list given access to only that node. 

Method 1 :
c.data=c.next.data
c.next=c.next.next
//c=c.next : won't return the change hence won't work

Complexity : O(1)
