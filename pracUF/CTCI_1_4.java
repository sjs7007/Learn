import java.util.*;

class CTCI_1_4 
{
	public static void main(String args[])
	{
		char ip[] = "Mr John Smith    ".toCharArray();
		int len=13,nSpace=0;
		for(int i=0;i<len;i++)
		{
			if(ip[i]==' ')
			{
				nSpace++;
			}	
		}
		int copyIndex=ip.length-1;
		for(int i=len-1;i>=0;i--)
		{
			if(ip[i]==' ')
			{
				ip[copyIndex]='0';
				ip[copyIndex-1]='2';
				ip[copyIndex-2]='%';
				copyIndex=copyIndex-3;
			}
			else 
			{
				ip[copyIndex]=ip[i];
				copyIndex--;
			}
					//System.out.println(Arrays.toString(ip));

		}
		System.out.println(Arrays.toString(ip));
	}
}

