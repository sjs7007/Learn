public class lastWord {
	public static int lengthOfLastWord(final String a) {
	     int count=0;
	    boolean flip=false;
	    if(a.length()==0) {
	        return 0;
	    }
	    else {
	        for(int i=0;i<a.length();i++) {
	           //loop until space
	           for(int j=i;j<a.length();j++)
	           {
	              // System.out.println("here1");
	               if(a.charAt(j)==' ') {
	                   j++;
	               } 
	               else
	               {
	                   count=0;
	                   i=j;
	                   break;
	               }
	               i=j;
	           }
	           //loop till next space 
	           for(int j=i;j<a.length();j++) {
	           		            //   System.out.println("here2");

	               if(a.charAt(j)!=' ') {
	                   count++;
	               } else {
	               	//	System.out.println(i);
	               		i=j-1;
	               		break;
	               }
	               //else {
	              //     i=j-1;
	               //    break;
	              // }
	               i=j;
	           }


	        }
	    }
	    return count;
	}

	public static void main(String args[])
	{
		System.out.println(lengthOfLastWord("Word1    "));
	}
}
