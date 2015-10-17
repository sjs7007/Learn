import java.util.*;

class CTCI_1_2 {
	public static void main(String args[]) {
		char s[] = "this is a string".toCharArray();
		for(int i=s.length-1;i>=s.length/2;i--) {
			char temp = s[i];
			s[i]=s[s.length-i-1];
			s[s.length-i-1]=temp;
		} 
		System.out.println(Arrays.toString(s));
	}	
}
