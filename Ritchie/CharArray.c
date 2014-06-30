//Character Array - null character

#include<stdio.h>
int main()
{
	char test[100];
	int i=0;
	for(i=0;i<5;i++)
	{
		test[i]=getchar();
	}
	printf("Without null character : %s.\n",test);
	test[5]='\0';
	printf("With null character : %s.\n",test);
}
