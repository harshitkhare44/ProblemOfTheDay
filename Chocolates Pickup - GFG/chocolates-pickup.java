//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    public static void main(String args[]) throws IOException{
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int N=sc.nextInt();
            int M=sc.nextInt();
            
            int [][]grid=new int[N][M];
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    grid[i][j]=sc.nextInt();
                    
                }
            }
            
            Solution obj=new Solution();
            long res=obj.solve(N, M, grid);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public int solve(int n, int m, int grid[][]){
        // Code here
        int dp[][][]=new int[n][m][m];
        for(int arr[][]:dp){
            for(int row[]:arr){
                Arrays.fill(row,-1);
            }
        }
        
        return sol(grid,0,0,m-1,n-1,m-1,dp);
    }
    int sol(int[][]grid,int i,int j1,int j2,int n,int m,int[][][]dp){
        if(j1<0 || j2<0 || j1>m ||j2>m)return (int)-1e9;
        if(i==n){
            if(j1==j2){
                return grid[i][j1];
            }
            else{
                return grid[i][j1]+grid[i][j2];
            }
        }
        if(dp[i][j1][j2]!=-1)return dp[i][j1][j2];
        int maxi=Integer.MIN_VALUE;
        int del[]={-1,0,1};
        for(int d1=0;d1<3;d1++){
            for(int d2=0;d2<3;d2++){
                int value=0;
                if(j1==j2){
                    value=grid[i][j1];
                }
                else{
                    value=grid[i][j1]+grid[i][j2];
                }
                value+=sol(grid,i+1,j1+del[d1],j2+del[d2],n,m,dp);
                maxi=Math.max(value,maxi);
            }
        }
        return dp[i][j1][j2]=maxi;
    }
}