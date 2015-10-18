//Rotate 2D array

import java.util.*;

class CTCI_1_6
{
	public static void main(String args[]) {
		int x1[][]={{1,2,3},{4,5,6},{7,8,9}};
		int x2[][]={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		System.out.println(Arrays.deepToString(rotateEasiest(x1)));
	}

	public static int[][] rotateEasiest(int x[][]) //not in place, works for any size matrix
	{
		int rMax=x.length;
		int cMax=x[0].length;
		int ret[][]=new int[cMax][rMax];
		for(int i=0;i<rMax;i++)
		{
			for(int j=0;j<cMax;j++)
			{
				ret[j][rMax-i-1]=x[i][j];
			}
		}
		return ret;
	} 
}