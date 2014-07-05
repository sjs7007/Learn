#include<iostream>
using namespace std;

int main()
{
	int t;
	cin >>t;
	for(int x=0;x<t;x++)
	{
	//	int t2;
	//	cin>>t2;

		string input;
		cin >>input;
		int count=0;
		
		int oneCount=0;

		for(int i=0;i<input.length();i++)
		{
			if(input[i]=='1')
			{
				oneCount++;
			}

			for(int j=i;j<input.length();j++)
			{
				if(input[i]=='1' && input[j]=='1')
				{
					count++;
				}
			}
		}

		int ans = oneCount* (oneCount+1)/2;

		cout<<count<<" "<<ans<<endl;

	}
	//cout<<"Count : "<<count<<endl;
	//	cout<<input.substr(0,1);
}
