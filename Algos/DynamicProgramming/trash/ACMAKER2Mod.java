// http://www.spoj.com/problems/ACMAKER/

class ACMAKER2Mod
{
	public static int DPAnswer[][][]=new int[100][100][100];
	
	public static void main(String args[])
	{
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

		char abr[]={'a','c','m'};
		String exp[]={"academy","computer","makers"};
		//char abr[]={'r','a','d','r','a','n'};
		//String exp[]={"radio","detection","ranging"};
		//char abr[]={'d','o','d','g','i','n','g'};
		//String exp[]={"radio","detection","ranging"};
		
		//char abr[]={'a','c','m','i'};
		//String exp[]={"academy","ccomiputer","iakers"};
		System.out.println(DP(0,0,abr,exp,0));
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
