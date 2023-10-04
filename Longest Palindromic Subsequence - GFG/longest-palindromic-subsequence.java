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
    int dp[][];
    public int longestPalinSubseq(String S)
    {
        //code here
        StringBuilder sb=new StringBuilder();
        sb.append(S);
        return lcs(S,sb.reverse().toString());
    }
    int lcs(String s1,String s2){
        int n=s1.length();
        int m=s2.length();
        dp=new int[n][m];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return solve(s1,s2,n-1,m-1);
        
    }
    int solve(String s1,String s2,int i,int j){
        if(i<0 || j<0)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j)){
            return dp[i][j]=1+solve(s1,s2,i-1,j-1);
        }
        return dp[i][j]=Math.max(solve(s1,s2,i,j-1),solve(s1,s2,i-1,j));
    }
}