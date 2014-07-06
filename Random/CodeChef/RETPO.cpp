//http://www.codechef.com/JULY14/problems/RETPO

#include <iostream>
using namespace std;

#include <string.h>

string turnLeft(string current);
string turnRight(string current);
int getNewX(string direction,int currentX);
int getNewY(string direction,int currentY);
int getOptimal(int i,int j,int endX,int endY,string direction);

int DP[100][100];

int main()
{
	//cout<<turnLeft("x")<<endl;
	//cout<<turnRight("x")<<endl;
	memset(DP,-1,sizeof(DP));
	cout<<getOptimal(2,2,3,3,"x");
		/*int i=2,j=3;
		string direction="-y";	
		string direction1=turnRight(direction);
		int x1=getNewX(direction1,i);
		int y1=getNewY(direction1,j);	
		cout<<x1<<" "<<y1<<endl;*/
}

string turnRight(string current)
{
	if(current=="x")
	{
		return "y";
	}
	else if(current=="y")
	{
		return "-x";
	}
	else if(current=="-x")
	{
		return "-y";
	}
	else 
	{
		return "x";
	}
}

string turnLeft(string current)
{
	if(current=="x")
	{
		return "-y";
	}
	else if(current=="-y")
	{
		return "-x";
	}
	else if(current=="-x")
	{
		return "y";
	}
	else
	{
		return "x";
	}
}

int getNewX(string direction,int currentX)
{
	if(direction=="x")
	{
		return(currentX+1);
	}
	else if(direction=="-x")
	{
		return(currentX-1);
	}
	else
	{
		return(currentX);
	}
}

int getNewY(string direction,int currentY)
{
	if(direction=="y")
	{
		return(currentY+1);
	}
	else if(direction=="-y")
	{
		return(currentY-1);
	}
	else
	{
		return(currentY);	
	}
}

int getOptimal(int i,int j,int endX,int endY,string direction)
{
	cout<<i<<" "<<j<<endl;
	if(i<0 ||j<0)
	{
		return 10000;
	}
	else if(i>endX || j>endY)
	{
		return 1000;
	}	
	else if(i==endX && j==endY)
	{
		return 0;
	}
	else if(DP[i][j]>=0)
	{
		return DP[i][j];
	}
	else
	{
		string direction1=turnLeft(direction);
		int x1=getNewX(direction1,i);
		int y1=getNewY(direction1,j);	
		int temp1=1+getOptimal(x1,y1,endX,endY,direction1);

		string direction2=turnRight(direction);
		int x2=getNewX(direction2,i);
		int y2=getNewY(direction2,j);	
		int temp2=1+getOptimal(x2,y2,endX,endY,direction2);

		if(temp1<temp2)
		{
			DP[i][j]=temp1;
			return temp1;
		}
		else
		{
			DP[i][j]=temp2;
			return temp2;
		}
	}

}
