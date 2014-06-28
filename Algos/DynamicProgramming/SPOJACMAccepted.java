// http://www.spoj.com/problems/ACMAKER/
//Accepted!

import java.util.*;
import java.io.*;

class SPOJACMAccepted
{
	public static int DPAnswer[][][]=new int[50][50][50];
	
	public static void main(String args[]) throws IOException
	{
		Scanner ip = new Scanner(System.in);
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


		while(true)
		{
			//char abr[]={'a','c','m'};
			
			ip = new Scanner(System.in);
			int t=Integer.parseInt(reader.readLine());
		//	System.out.println("Here1");
			if(t==0)
			{
				break;
			}
			String insig[]=new String[t];
			ip=new Scanner(System.in);
		//		System.out.println("Here2");
			for(int i=0;i<t;i++)
			{
				ip=new Scanner(System.in);
				insig[i]=reader.readLine();
				//System.out.println(insig[i]);
			}
			//	System.out.println("Here3");

			while(true)
			{
				ip=new Scanner(System.in);
				String temp =reader.readLine();
				//	System.out.println("Here4");
				String breakS = new String("LAST CASE");
				if(temp.equals(breakS))
				{
					break;
				}
				String tempArray[]=temp.split(" ");

				char abr[]=tempArray[0].toLowerCase().toCharArray();

				temp = new String();
				for(int i=1;i<tempArray.length;i++)
				{
					int flag=1;
					for(int j=0;j<t;j++)
					{
						if(tempArray[i].equals(insig[j]))
						{
							flag=-1;
							break;
						}
					}
					if(flag>0)
					{
						temp = temp + tempArray[i]+" ";
					}
				}

				//String exp[]={"academy","computer","makers"};
				//String temp = ip.nextLine();
				
				String exp[]=temp.split(" ");

				//System.out.println(tempArray[0].toLowerCase()+" "+temp);

				for(int i=0;i<50;i++)
				{
					for(int j=0;j<50;j++)
					{
						for(int k=0;k<50;k++)
						{
							DPAnswer[i][j][k]=-1;
						}
					}
				}

				int answer = DP(0,0,abr,exp,0);
				if(answer>0)
				{
					System.out.println(tempArray[0]+" can be formed in "+answer+" ways");
				}
				else
				{
					System.out.println(tempArray[0]+" is not a valid abbreviation");
				}
			}
		}
	}

	public static int DP(int i,int j,char abr[],String exp[],int currentPInWord)
	{
		int originalCurrentPInWord = currentPInWord;
		if(i==abr.length && j==exp.length)
		{
			return 1;
		}
		else if(i==abr.length || j==exp.length)
		{
			return 0;
		}
		else if(DPAnswer[i][j][originalCurrentPInWord]>=0)
		{
			//System.out.println("Free Call for "+i+" "+j+" "+currentPInWord+", returning "+DPAnswer[i][j][originalCurrentPInWord]+".");
			return DPAnswer[i][j][currentPInWord];
		}
		else
		{
			int temp=0;
			for(int k=currentPInWord;k<exp[j].length();k++)
			{
				if(abr[i]==exp[j].charAt(k))
				{
					//System.out.println(abr[i]);
					currentPInWord=k+1;
					temp+=DP(i,j,abr,exp,currentPInWord);
					if(((abr.length-(i+1))-(exp.length-(j+1)))>0)
					{
						temp+=DP(i+1,j,abr,exp,currentPInWord);
					}
					temp+=DP(i+1,j+1,abr,exp,0); 

					/*System.out.println(i+" "+j+" "+currentPInWord);
					if(((abr.length-(i+1))-(exp.length-(j+1)))>0)
						System.out.println((i+1)+" "+j+" "+currentPInWord);

					System.out.println((i+1)+" "+(j+1)+"0"); */
					break;
				}
			}
			DPAnswer[i][j][originalCurrentPInWord]=temp;
		//	System.out.println(i+" "+j+" "+currentPInWord+" stored with value : "+DPAnswer[i][j][originalCurrentPInWord]+".");
			return temp;
		}
	}
}

