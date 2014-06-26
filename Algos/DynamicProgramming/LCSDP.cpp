//Longest Common Subsequence using Bottom UP DP 

#include<iostream>
using namespace std;
#include<stdio.h>

int getLCS(char *x,char *y,int m,int n);
int max(int x,int y);
int answers[1000][1000];

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
	for(int i=0;i<=m;i++)
	{
		for(int j=0;j<=n;j++)
		{
			if(i==0 | j==0)
			{
				answers[i][j]=0;
			}
			else if(x[i-1]==y[j-1])
			{
				answers[i][j]=answers[i-1][j-1]+1;
			}
			else
			{
				answers[i][j]=max(answers[i-1][j],answers[i][j-1]);
			}
		}
	}

	return answers[m][n];
}

int max(int x,int y)
{
	return ( x > y ? x : y);
}
