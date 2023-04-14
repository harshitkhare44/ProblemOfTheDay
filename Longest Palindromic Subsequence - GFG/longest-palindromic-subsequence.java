//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Solution obj = new Solution();
                    System.out.println(obj.longestPalinSubseq(s));
                }
                
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int longestPalinSubseq(String S)
    {
        //code here
        StringBuilder sb=new StringBuilder(S);
        int n=S.length();
        int dp[][]=new int[n][n];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        sb.reverse();
        return solve(n-1,n-1,S,sb.toString(),dp);
    }
    int solve(int i,int j,String s,String t,int[][]dp){
        if(i<0 || j<0 )return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        if(s.charAt(i)==t.charAt(j)){
            return dp[i][j]=1+solve(i-1,j-1,s,t,dp);
        }
        return dp[i][j]=Math.max(solve(i,j-1,s,t,dp),solve(i-1,j,s,t,dp));
    }
}