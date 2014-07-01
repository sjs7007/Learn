//http://www.spoj.com/problems/LISA/
// 18:48 - 19:26 max done,memoize it - 19:31 memoized done,work for min function next
//19:36 - All done for min! Submit.
//19:48 correction made on second memset! submission version in LISASubmit
//NOTE : free call case being given as >0 instead of correct >=0 was causing TLE.
//Accepted

#include<iostream>
using namespace std;
#include<string.h> //forstrcpy

int getOptimalMax(char inputArray[],int i,int j);
int getOptimalMin(char inputArray[],int i,int j);
int DPMax[100][100];
int DPMin[100][100];

int main()
{
	string input;
	cin >>input;
	char inputArray[input.length()+1];
	strcpy(inputArray,input.c_str());

	memset(DPMax,-1,sizeof(DPMax));
	memset(DPMin,-1,sizeof(DPMin));

	//cout<<getOptimalMax(inputArray,0,input.length()-1);
	cout<<getOptimalMax(inputArray,0,input.length()-1)<<" "<<getOptimalMin(inputArray,0,input.length()-1);
}

int getOptimalMax(char inputArray[],int i,int j)
{
	if(i==j)
	{
		int temp = inputArray[i]-'0';
		return temp;
	}
	else if(DPMax[i][j]>=0)
	{
		//cout<<"Free Call!"<<endl;
		return DPMax[i][j];
	}
	else
	{
		int max = -1;

		for(int k=i+1;k<=j-1;k=k+2)
		{	
			
		//	cout<<"Calling "<<i<<" "<<(k-1)<<" and "<<(k+1)<<" "<<j<<endl;
			int temp1 = getOptimalMax(inputArray,i,k-1);
			int temp2 = getOptimalMax(inputArray,k+1,j);
			int temp3=-1;
			
		//	int temp1=2,temp2=4,temp3;
			if(inputArray[k]=='+')
			{
				temp3 = temp1+temp2;
			}
			else if(inputArray[k]=='*')
			{
				temp3 = temp1*temp2;
			}

			if(temp3>max)
			{
				max=temp3;
			}
			//cout<<"test";
		}
		DPMax[i][j]=max;
		return max;
	}
}

int getOptimalMin(char inputArray[],int i,int j)
{
	if(i==j)
	{
		int temp = inputArray[i]-'0';
		return temp;
	}
	else if(DPMin[i][j]>=0)
	{
		//cout<<"Free Call!"<<endl;
		return DPMin[i][j];
	}
	else
	{
		int min = -1;

		for(int k=i+1;k<=j-1;k=k+2)
		{	
			
		//	cout<<"Calling "<<i<<" "<<(k-1)<<" and "<<(k+1)<<" "<<j<<endl;
			int temp1 = getOptimalMin(inputArray,i,k-1);
			int temp2 = getOptimalMin(inputArray,k+1,j);
			int temp3=-1;
			
		//	int temp1=2,temp2=4,temp3;
			if(inputArray[k]=='+')
			{
				temp3 = temp1+temp2;
			}
			else if(inputArray[k]=='*')
			{
				temp3 = temp1*temp2;
			}

			if(temp3<min ||min==-1)
			{
				min=temp3;
			}
			//cout<<"test";
		}
		DPMin[i][j]=min;
		return min;
	}
}
