//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution
{
	public static int addMinChar(String str){
		//code here
		int end=str.length()-1;
	
		while(end>=0){
		    if(isPal(str,end)){
		        return str.length()-1-end;
		    }
		    else end--;
		}
		return -1;
	}
	static boolean isPal(String s,int j){
	    int i=0;
	    while(i<=j){
	        if(s.charAt(i)!=s.charAt(j))return false;
	        i++;
	        j--;
	    }
	    return true;
	}
}

//{ Driver Code Starts.

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
        	String str = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.addMinChar(str));
        }
        
    }
}

// } Driver Code Ends