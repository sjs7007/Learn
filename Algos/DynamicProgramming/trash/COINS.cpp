//http://www.spoj.com/problems/COINS/

//Recursive Solution. Array for memoization not possible since array size becomes too large. look at some other DS?

#include<iostream>
using namespace std;
#include<math.h>

int getOptimal(int n);
int max(int x,int y);
//int DP[100000000];

int main()
{
	//int t = floor(4.7);
	//cout<<t;
	cout<<getOptimal(3);
}

int getOptimal(int n)
{
	if(n==0)
	{
		return 0;
	}
	else
	{
		int x = floor(n/2);
		int y = floor(n/3);
		int z = floor(n/4);

		x = max(x,getOptimal(x));
		y = max(y,getOptimal(y));
		z = max(z,getOptimal(z));

		return max(n,x+y+z);
	}
}

int max(int x,int y)
{
	if(x>y)
	{
		return x;
	}
	else
	{
		return y;
	}
}

