import java.util.*; 

class Solution {
    /*public ArrayList<Integer> primesum(int a) {
    }*/
    
    public static boolean isPrime(int a) {
        if(a==1)
        {
            return false;
        }
        for(int i=2;i<=(int)(Math.sqrt(a));i++) {
            if(a%i==0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[])
    {
     /*   for(int i=1;i<=20;i++)
        {
            if(isPrime(i))
                System.out.println(i);
        }*/
       // System.out.println((int)'A'-65+1);
      /*  System.out.println(titleToNumber("AAA"));
        System.out.println(isPalindrome(2147447412));
        isPalindrome(404);
        isPalindrome(3003);
        isPalindrome(3);

        ArrayList<Integer> x = new ArrayList<Integer>();
        x.add(4);
        x.add(0);
        x.add(2);
        x.add(1);
        x.add(3);
        arrange3(x);

        reverse(-1);
        reverse( -1146467285);
        reverse(-35488693);

        convertToTitle(980089);*/
        //getRow(3);
        generateMatrix(5);
    }

        public static int titleToNumber(String a) {
        int sum=0;
        for(int i=0;i<a.length();i++) {
           // System.out.println(a.charAt(i));
            //System.out.println(((int)a.charAt(i)-65+1 ) *(int)Math.pow(26,a.length()-i-1));
            sum = sum + ((int)a.charAt(i)-65+1 ) *(int)Math.pow(26,a.length()-i-1);
        }
        return sum;
    
    }

    public static boolean isPalindrome(int a) {
        int reverse=0,length=0;

            int temp=a;
        while(temp>0)
        {   
            length++;
            temp=temp/10;
        }

        temp=a;

        for(int i=0;temp>0;i++) {
            reverse = reverse + (int) ( (temp %10)*Math.pow(10,length-i-1));
            temp=temp/10; 
        }    
        System.out.println(reverse);
        return (a==reverse);
    }

  /*  public boolean isPalindrome(int a) {
        int reverse=0,temp=a;
        while(temp>0){
            reverse = reverse * 10 + temp%10;
            temp = temp/10;
        }
        return(a==reverse);
    }*/

  /*  public static void arrange(ArrayList<Integer> a) {
        for(int i=0;i<a.size();i++)
        {
            for(int j=i+1;j<a.size();j++)
            {
                if(a.get(j)>a.get(i)) 
                {
                    int temp = a.get(j);
                    a.set(j,i);
                    a.set(i,temp);
                }
            }
        }
        return a;
    }*/

    /* public static void arrange2(ArrayList<Integer> a) {
        int temp=a[0];
        int indexSearch=0;
        for(int i=1;i<=a.size();i++)
        {
            for(int j=0;j<a.size();j++)
            {
                if(a.get(j)==indexSearch)
                {
                    int temp2 = a.get(j); 
                    a.set(j,temp);
                    temp = temp2;
                    indexSearch=j;
                }
            }  
        }
    }*/

    public static void arrange3(ArrayList<Integer> a) {
           int temp=a.get(0);
           //System.out.println(a.get(a.get(0)));
           a.set(0,a.get(a.get(0)));
        int indexSearch=0;
        for(int i=1;i<a.size();i++)
        {
            for(int j=0;j<a.size();j++)
            {
                if(a.get(j)==indexSearch)
                {
                    int temp2 = a.get(j); 
                    a.set(j,temp);
                    temp = temp2;
                    indexSearch=j;
                   System.out.println(temp+" "+indexSearch );
                   break;
                   // System.out.println(temp+" "+indexSearch );
                }
            }  
        }
    }

    public static int reverse(int x)
    {
        int temp=x;
        if(x<0)
        {
            temp=-x;
        }
        int rev=0;
        while(temp>0)
        {
            if(rev>0 && 10>(Integer.MAX_VALUE/rev))
            {
                rev=0;
                break;
            }
            rev = rev * 10 + temp %10;
            temp = temp/10;
        }

        if(x<0)
        {
            rev=-rev;
        }
        System.out.println(rev);
        return rev;
    }

    public static String convertToTitle(int x) 
    {
        //x=x-1;
        String b26="";
        while(x>=26)
        {
            x=x-1;
            int temp = x % 26;
            x= x/26;
            b26 = Character.toString((char)(65+temp)) + b26;
          //  System.out.println(x+" "+temp+" "+b26);
        }
        if(x>0)
        {
             b26 = Character.toString((char)(64+x)) + b26;
        }
       System.out.print(b26);
        return b26;
    }

    //uses too much space 
    /*
    public ArrayList<Integer> getRow(int a) {
        ArrayList<Integer> temp = new ArrayList<Integer>();
        int x[][]=new int[a+2][a+2];
        if(a==0)
        {
            temp.add(1);
            return (temp);
        }
        x[0][1]=1;
        for(int i=1;i<=a;i++)
        {
            for(int j=1;j<=i+1;j++)
            {
                x[i][j]=x[i-1][j-1]+x[i-1][j];
             //   System.out.print(x[i][j]+" ");
                if(i==a)
                {
                    temp.add(x[i][j]);
                }
            }
          //  System.out.println();
        }
        return temp;
    }*/

    //use O(k) space
     public static ArrayList<Integer> getRow(int a) {
        ArrayList<Integer> temp1 = new ArrayList<Integer>();
        ArrayList<Integer> temp2 = new ArrayList<Integer>();
       
        if(a==0)
        {
            temp1.add(1);
            return temp1;
        }
        else
        {
            temp1.add(1);
            //temp2.add(1);
            for(int i=1;i<=a;i++)
            {
                temp2.add(1);
                for(int j=1;j<i;j++)
                {
                    //temp2.add(-1);
                 //   System.out.println(temp2.size()+" "+(j-1)+" "+j);
                    temp2.add(temp1.get(j-1)+temp1.get(j));
                }
                temp2.add(temp1.get(i-1));
                temp1=temp2;
               // System.out.println("ds");
                temp2=new ArrayList<Integer>();
            }
        }
        System.out.println(temp1);
        return temp1;
    }

        public static void generateMatrix(int n) {
         int r=1,c=0,count=1;
            int rightMax=n,bottomMax=n,leftMin=1,topMin=2;
            int x[][]=new int[n+1][n+1];

 for(int i=1;i<=n;i++)
        {
          //  temp = new ArrayList<Integer>();
            for(int j=1;j<=n;j++)
            {
                System.out.print(x[i][j]+" ");
              //  temp.add(x[i][j]);
            }
            System.out.println();
        }

        while(count<=n*n)
        {
            while(count<=n*n)
            {
                c++;
                if(c>rightMax)
                {
                     c--;
                     rightMax=rightMax-1;
                    break;
                }
                x[r][c]=count;

               // c++;
                count++;
                //System.out.println("aa count : "+count);
            }
           

 for(int i=1;i<=n;i++)
        {
         //   temp = new ArrayList<Integer>();
            for(int j=1;j<=n;j++)
            {
                System.out.print(x[i][j]+" ");
                //temp.add(x[i][j]);
            }
            System.out.println();
        }

            while(count<=n*n)
            {
                r++;
                if(r>bottomMax)
                {
                    bottomMax=bottomMax-1;
                    r--;
                    break;
                }
                x[r][c]=count;
                              //  System.out.println(r+" "+c+" "+count);

                count++;
            }
         
 for(int i=1;i<=n;i++)
        {
          //  temp = new ArrayList<Integer>();
            for(int j=1;j<=n;j++)
            {
                System.out.print(x[i][j]+" ");
               // temp.add(x[i][j]);
            }
            System.out.println();
        }

            while(count<=n*n)
            {
                c--;
                if(c<leftMin)
                {
                     leftMin=leftMin+1;
            c++;
                    break;
                }
                x[r][c]=count;
                count++;

               // System.out.println("cc count : "+count);
            }
           
           /* while(r>=topMin)
            {
                x[r][c]=count;
                r--;
                count++;
            }*/

 for(int i=1;i<=n;i++)
        {
          //  temp = new ArrayList<Integer>();
            for(int j=1;j<=n;j++)
            {
                System.out.print(x[i][j]+" ");
                //temp.add(x[i][j]);
            }
            System.out.println();
        //    ret.add(temp);
        }

            while(count<=n*n)
            {
                r--;
                if(r<topMin)
                {
                     topMin=topMin+1;
            r++;
                    break;
                }
                x[r][c]=count;
                              //  System.out.println(r+" "+c+" "+count);

                count++;
                //System.out.println("dd count : "+count);
            }
           


        }
        ArrayList<Integer> temp = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        for(int i=1;i<=n;i++)
        {
            temp = new ArrayList<Integer>();
            for(int j=1;j<=n;j++)
            {
                System.out.print(x[i][j]+" ");
                temp.add(x[i][j]);
            }
            System.out.println();
            ret.add(temp);
        }
        //System.out.println(ret);
    }
}
