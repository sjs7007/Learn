//Exercise 2-1 : Print ranges from headers and by computation
//http://www.cplusplus.com/reference/climits/


#include<stdio.h>
#include<limits.h> //for limits
#include<math.h> //for pow

int main()
{
	printf("char range is from %d to %d.\n",CHAR_MIN,CHAR_MAX);
	printf("short range is from %d to %d.\n",SHRT_MIN,SHRT_MAX);
	printf("int range is from %d to %d.\n",INT_MIN,INT_MAX);
	printf("long range is from %ld to %ld.\n",LONG_MIN,LONG_MAX);

	//using calculations
	int min,max;

	//char is of 8 bits, so for signed -2^7 to 2^7-1
	min=-pow(2,7);
	max=pow(2,7)-1;
	printf("Computed min and max for signed char are : %d & %d.\n",min,max);
}
