//Longest Common Subsequence Recursive

#include<iostream>
using namespace std;
#include<stdio.h>

int getLCS(char *x,char *y,int m,int n);
int max(int x,int y);

int main()
{
	char x[] = "AGGTAB";
	char y[] = "GXTXAYB";

	int m=sizeof(x)/sizeof(char)-1; //includes extra /0 at end hence -1
	int n=sizeof(y)/sizeof(char)-1; 
	//cout<<m<<" "<<n<<endl;
	cout<<getLCS(x,y,m,n)<<endl;
}

int getLCS(char *x,char *y,int m,int n)
{
	if(m==0 || n==0)
	{
		return 0;
	}
	else
	{
		if(x[m-1]==y[n-1])
		{
			return (1+getLCS(x,y,m-1,n-1));
		}
		else 
		{
			return (max(getLCS(x,y,m-1,n),getLCS(x,y,m,n-1)));
		}
	}
}

int max(int x,int y)
{
	return ( x > y ? x : y);
}
