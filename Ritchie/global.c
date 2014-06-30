//global variables

#include<stdio.h>

int testG=10;

int main()
{
	extern int testG; //actually works without this also! How? 
	printf("Value from global variable : %d",testG);
}
