package com.support;

public class StringTest {

	 public static int longestPalindrome(int n, String s) {
		    // Write your code here
		       int max1 = 0;
		        int max2 = 0;
		        String a = new String (s);
		        String b = new String (s);;
		        for(int i=0;i<a.length();i++){
		        	 
		            a = a.substring(1);
		            if(max1 == 0)
			            max1 = checkPali(a);
		           
		        }
		        for(int i=0;i<b.length();i++){
		        	if(max2 == 0)
			            max2 = checkPali(b);
		            b = b.substring(i,b.length()-1);
		            
		        }
		        if(max1>max2)
		            return max1;
		        else return max2;

		    }
		    
		    public static int checkPali(String s){
		        StringBuilder sb = new StringBuilder(s);
		        if(s.equals(sb.reverse().toString())){
		            return s.length();
		        }
		        return 0;
		    }
		    
		    public static void main(String[] args) {
				System.out.println(longestPalindrome(7,"bandana"));
			}
}
