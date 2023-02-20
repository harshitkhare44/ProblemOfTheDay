//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution{
	public static int countPaths(int N){
		//code here
		if(N<2)return 0;
		long m=1000000007;
		long t=0L;
		int i=2;
		while(i<=N){
		    t=(t*3)%m;
		    if(i%2!=0)t-=3;
		    else t=(t+3)%m;
		    i++;
		}
		return (int)t;
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
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.countPaths(N));
        }
    }
}

// } Driver Code Ends