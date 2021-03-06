//http://www.spoj.com/problems/EDIST/
//13:51 start - 


#include<iostream>
using namespace std;

#include<string.h> //for memset
#include<stdlib.h> //for abs

int DP[2001][2001];
int getOptimal(string x,string y,int i,int j);
int min(int x,int y,int z);

int main()
{
	string x,y;
	cin>>x;
	cin>>y;

	memset(DP,-1,sizeof(DP));
	cout<<getOptimal(x,y,0,0);
}

int getOptimal(string x,string y,int i,int j)
{
	if(i==x.length() && j==y.length())
	{
		return 0;
	}
	else if(i==x.length() ||j==y.length())
	{
		//cout<<"here? "<<(abs(j-i)+1)<<endl;
		return (1+abs(j-i));
	}
	if(DP[i][j]>-1)
	{
		//cout<<"Free Call!"<<endl;
		return DP[i][j];
	}
	else if(x[i]==y[j])
	{
		DP[i][j]=DP[i-1][j-1];
		return (getOptimal(x,y,i+1,j+1));
	}
	else
	{
		int temp1 = 1 + getOptimal(x,y,i+1,j+1); //case where first char in x is replaced by first char in j
		int temp2 = 1 + getOptimal(x,y,i,j+1);
		int temp3 = 1 + getOptimal(x,y,i+1,j);

		int temp4 = min(temp1,temp2,temp3);
		DP[i][j] = temp4;
		return temp4;
	}
}

int min(int x,int y,int z)
{
	if(x<y && x<z)
	{
		return x;
	}
	else if(y<x && y<z)
	{
		return y;
	}
	else
	{
		return z;
	}
}
