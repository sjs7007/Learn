//http://www.spoj.com/problems/COINS/

//Recursive Solution. Array for memoization not possible since array size becomes too large. look at some other DS?
//trying using maps

#include<iostream>
using namespace std;
#include<math.h> //for floor
#include <map> //for map ds from STL

unsigned long int getOptimal(unsigned long int n);
unsigned long int max(unsigned long int x,unsigned long int y);
//unsigned long int DP[100000000];
map <unsigned long int,unsigned long int> DP;

int main()
{
	//unsigned long int t = floor(4.7);
	//cout<<t;
	//cout<<getOptimal(12);
	unsigned long int n;
	while(cin>>n)
	{
		cout<<getOptimal(n)<<endl;
	}
}

unsigned long int getOptimal(unsigned long int n)
{
	if(n==0)
	{
		return 0;
	}
	else if(DP.count(n)>0)
	{
		//cout<<"Free Call!"<<endl;
		return DP[n];
	}
	else
	{
		//unsigned long int x = floor(n/2);
		//unsigned long int y = floor(n/3);
		//unsigned long int z = floor(n/4);
		unsigned long int x = n/2;
		unsigned long int y = n/3;
		unsigned long int z = n/4;

		x = max(x,getOptimal(x));
		y = max(y,getOptimal(y));
		z = max(z,getOptimal(z));

		unsigned long int temp = max(n,x+y+z);
		DP[n] = temp;
		return temp;
	}
}

unsigned long int max(unsigned long int x,unsigned long int y)
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

