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
char nChar=13;
int nSpace = ip.length-nChar,lastEnd=-1,lastStart=-1;
for(int i=ip.length-1;i>=0;i--) {
	if(ip[i]!=' ') {
		lastEnd=i;
		for(int j=i-1;j>=0;j--) {
			if(ip[j]==' ') {
				lastStart=i-1;
				break;
			}
		}
	}
	break;	
}
//find nSpaces before last word
int nBefore=0;
for(int i=lastStart-1;i>=0;i--) {
	if(ip[i]==' ') {
		nBefore++;
	}
}
int nAfter=(nSpace-nBefore*3)/3; //no of %20 after last word 
```