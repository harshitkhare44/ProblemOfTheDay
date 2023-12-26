//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if(ob.isSubsetSum(N, arr, sum))
            System.out.println(1);
            else
            System.out.println(0);

            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{


    static Boolean isSubsetSum(int N, int arr[], int sum){
        // code here
        int dp[][]=new int[N+1][sum+1];
        for(int row[]:dp)Arrays.fill(row,-1);
        return solve(arr,N-1,sum,dp);
    }
    static boolean solve(int[]arr,int i,int sum,int[][]dp){
        if(sum==0)return true;
        if(i==0) return (arr[0]==sum);
        if(dp[i][sum]!=-1)return dp[i][sum]==0?false:true;
        boolean  nt=solve(arr,i-1,sum,dp);
        boolean  tk=false;
        if(sum>=arr[i])tk=solve(arr,i-1,sum-arr[i],dp);
        if(nt==true || tk==true) dp[i][sum]=1;
        else dp[i][sum]=0;
        return nt|tk;
    }
}