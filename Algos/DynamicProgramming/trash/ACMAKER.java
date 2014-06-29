// http://www.spoj.com/problems/ACMAKER/

class ACMAKER
{
	public static int count[]=new int[100];
	
	public static void main(String args[])
	{
		char abr[]={'r','a','d','r','a','n'};
		String exp[]={"radio","ddetection","ranginng"};
		System.out.println(DP(0,0,abr,exp,0));
	}

	public static int DP(int i,int j,char abr[],String exp[],int currentPInWord)
	{
		if(i==abr.length && j==exp.length-1)
		{
			//System.out.println(i+" "+j);
			//count[i]++;
			System.out.println("here");
			return 1;
		}
		else if(j==exp.length)
		{
		//	count=count;
			return 0;
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
					//	System.out.println("Looking for : "+abr[i+1]);
						temp+=DP(i+1,j,abr,exp,currentPInWord);
					}
				
					{
						//System.out.println("here3 "+currentPInWord);
						temp+=DP(i+1,j+1,abr,exp,0);
					}
					break;
				}
			}
			return temp;
		}
	}
}
