//http://www.spoj.com/problems/AE00/
//ACCEPTED!

#include<iostream>
using namespace std;
#include<string.h> //FOR memset
#include<math.h>

long int DP[10001];
long int getAnswer(long int n);

int main()
{
	memset(DP,-1,sizeof(DP)); //SET all values of DP to -1
	/*for(long int i=0;i<100;i++)
	{
		cout<<DP[i]<<" ";
	}*/
	long int n;
	cin >>n;
	cout<<getAnswer(n)<<endl;
	//cout<<getAnswer(n)<<endl;
}

long int getAnswer(long int n)
{
	if(n==0)
	{
		return 0;
	}
	else if(n==1)
	{
		return 1;
	}
	else if(DP[n]>0)
	{
	//	cout<<"Free Call!"<<endl;
		return DP[n];
	}
	else
	{
		long int temp=getAnswer(n-1);
		for(long int i=1;i<=sqrt(n);i++)
		{
			if(n%i==0)
			{
				temp++;
			}
		}
	//	cout<<"Stored for n = "<<n<<endl;
		DP[n]=temp;
		return temp;
	}
}
