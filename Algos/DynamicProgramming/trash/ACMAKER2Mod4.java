// http://www.spoj.com/problems/ACMAKER/

import java.util.*;

class ACMAKER2Mod4
{
	public static int DPAnswer[][][]=new int[100][100][100];
	
	public static void main(String args[])
	{
		Scanner ip = new Scanner(System.in);

		while(true)
		{
			//char abr[]={'a','c','m'};
			
			int t=ip.nextInt();
			if(t==0)
			{
				break;
			}
			String insig[]=new String[t];
			ip=new Scanner(System.in);
			for(int i=0;i<t;i++)
			{
				insig[i]=ip.nextLine();
				//System.out.println(insig[i]);
			}

			while(true)
			{
				String temp = ip.nextLine();
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

				for(int i=0;i<100;i++)
				{
					for(int j=0;j<100;j++)
					{
						for(int k=0;k<100;k++)
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
		if(i==abr.length)
		{
			return 1;
		}
		else if(j==exp.length)
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

/*

if(i==abr.length && j==exp.length-1)
		{
			//System.out.println(i+" "+j);
			//count[i]++;
			return 1;
		}
		else if(j==exp.length)
		{
		//	count=count;
			return 0;
		}
		else if(DPAnswer[i][j]>0)
		{
		//	System.out.println("free call!");
			return DPAnswer[i][j];
		}
		else
		{
			//int currentPInWord=0;

			int temp=0;
			for(int k=currentPInWord;k<exp[j].length();k++)
			{
				if(abr[i]==exp[j].charAt(k))
				{
					currentPInWord=k+1;
					temp+=DP(i,j,abr,exp,currentPInWord); // look for same char of abbr in word again with new pointer

					//if more than one char of abbr can be selected, look for next char in same word
					//  if(abbr.length-exp.length-i)>=0, then go ahead  
				//	if(abr.length-exp.length-(i+1)>=0)
					{
						//System.out.println("here2");
						temp+=DP(i+1,j,abr,exp,currentPInWord);
					}
			//		else	
					{
						//System.out.println("here3 "+currentPInWord);
						temp+=DP(i+1,j+1,abr,exp,0);
					}
					break;
				}
			}
			DPAnswer[i][j]=temp;
			return temp;
		}

		*/
