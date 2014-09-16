//EOF example. Copies input to output.

#include<stdio.h>

int main()
{
	int c; //int because should be large enough to hold the value of EOF
	printf("The value of EOF here is : %d.\n",EOF);

	while((c=getchar())!=EOF)
	{
		putchar(c);
	}
}


