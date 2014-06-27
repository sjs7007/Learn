// http://www.spoj.com/problems/ACMAKER/


import java.util.*;

class ACMAKER21
{
	public static int DPAnswer[][]=new int[150][150];
	
	public static void main(String args[])
	{
		Scanner ip = new Scanner(System.in);
		while(true)
		{
			
			int t=ip.nextInt();
			if(t<=0)
			{
				break;
			}

			String insig[] = new String[t];
		
			for(int i=0;i<t;i++)
			{
				insig[i]=ip.next();
			}

			String temp="";
			
			//System.out.println("ded");
			String temp2=ip.nextLine();
			temp2=ip.nextLine();

			
			String temp3[]=temp2.split(" ");
			for(int i=0;i<temp3.length;i++)
			{
				int flag=1;
				for(int j=0;j<t;j++)
				{
					if(temp3[i].equals(insig[j]))
					{
						flag=-1;
						break;
					}					
				}
				if(flag==1)
				{
					temp=temp+temp3[i]+" ";
				}
			}

			
			String tempArray[]=temp.split(" ");

			char abr[]=tempArray[0].toLowerCase().toCharArray();
			int n=tempArray.length-1;

			String exp[]=new String[n];
			for(int i=0;i<n;i++)
			{
				exp[i]=tempArray[i+1];
			}

			for(int i=0;i<abr.length;i++)
			{
				for(int j=0;j<exp.length;j++)
				{
					DPAnswer[i][j]=-1;
				}
			}

			System.out.println(tempArray[0].toLowerCase());
			for(int i=0;i<exp.length;i++)
			{
				System.out.println(exp[i]);	
			}

			char abr2[]={'a','c','m'};
			String exp2[]={"academy","computer","makers"};

			System.out.println(DP(0,0,abr2,exp2,0));
		}

	}

	public static int DP(int i,int j,char abr[],String exp[],int currentPInWord)
	{
		if(i==abr.length && j==exp.length-1)
		{
			return 1;
		}
		else if(j==exp.length)
		{
			return 0;
		}
		else if(DPAnswer[i][j]>0)
		{
			System.out.println("free call!");
			return DPAnswer[i][j];
		}
		else
		{
			int temp=0;
			for(int k=currentPInWord;k<exp[j].length();k++)
			{
				if(abr[i]==exp[j].charAt(k))
				{
					currentPInWord=k+1;
					temp=DP(i,j,abr,exp,currentPInWord)+DP(i+1,j,abr,exp,currentPInWord)+DP(i+1,j+1,abr,exp,0); 
					break;
				}
			}
			DPAnswer[i][j]=temp;
			return temp;
		}
	}
}
