import java.util.*;

class largestNum {
    public static void main(String args[]) {
        int x[]={3,30,34,5,9};
        x = genSort(x);
        System.out.println(Arrays.toString(x));
        System.out.println(Arrays.toString(newSort(x)));
    }

    public static int[] genSort(int x[]) {
        for(int i=0;i<x.length;i++) {
            for(int j=i+1;j<x.length;j++) {
                if(x[i]>x[j]) {
                    int temp = x[i];
                    x[i]=x[j];
                    x[j]=temp;
                }
            }
        }
        return x;
    }

    public static int[] newSort(int x[]) {
        for(int i=0;i<x.length;i++) {
            for(int j=i+1;j<x.length;j++) {
                if(shouldSwap(x[i],x[j])) {
                    int temp = x[i];
                    x[i]=x[j];
                    x[j]=temp;
                }
            }
        }
        return x;
    }

    public static boolean shouldSwap(int x,int y) {
        //if x < y swap
        boolean ret=true;
        String tx=Integer.toString(x);
        String ty=Integer.toString(y);

        for(int i=0;i<tx.length() && i<ty.length();i++) {
            if(tx.charAt(i)>ty.charAt(i)) {
                ret=false;
                break;           
            } 
            else if(tx.charAt(i)==ty.charAt(i)) {
                if(tx.length()<ty.length()) {
                  ret=false;
                  break;
                } 
                else if(tx.length()>ty.length()) {
                    ret=true;
                    break;
                }
            }
            else {
           //     ret=true;
                break;
            }
        }

        return ret;
    }

}
