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
     int prev[][]=new int[m][m];
     for(int j1=0;j1<m;j1++){
         for(int j2=0;j2<m;j2++){
             if(j1==j2)
             prev[j1][j2]=grid[n-1][j1];
             else
             prev[j1][j2]=grid[n-1][j1]+grid[n-1][j2];
         }
     }
     for(int i=n-2;i>=0;i--){
         int temp[][]=new int[m][m];
         for(int j1=0;j1<m;j1++){
             for(int j2=0; j2<m;j2++){
                 int del[]={-1,0,1};
                 int maxi=(int)-1e9;
                 for(int d1=0;d1<3;d1++){
                     for(int d2=0;d2<3;d2++){
                         int value=0;
                         if(j1==j2){
                             value+=grid[i][j1];
                         }
                         else value+=grid[i][j1]+grid[i][j2];
                         if(j1+del[d1]>=0 && j1+del[d1]<m && j2+del[d2]>=0 && j2+del[d2]<m){
                             value+=prev[j1+del[d1]][j2+del[d2]];
                         }
                         else value=(int)-1e9;
                         maxi=Math.max(value,maxi);
                        
                     }
                 }
                 temp[j1][j2]=maxi;
             }
         }
         prev=temp;
     }
     return prev[0][m-1];
    }
}
