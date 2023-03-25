//{ Driver Code Starts
//Initial Template for Java

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
            String S[] = read.readLine().split(" ");
            int R = Integer.parseInt(S[0]);
            int C = Integer.parseInt(S[1]);
            int matrix[][] = new int[R][C];
            int c = 0;
            for(int i = 0; i < R; i++){
                String line[]=read.readLine().trim().split(" ");
                for(int j = 0; j < C; j++){
                    matrix[i][j] = Integer.parseInt(line[j]);
                }
            }
            Solution ob = new Solution();
            int ans = ob.median(matrix, R, C);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    int median(int matrix[][], int R, int C) {
        // code here      
        int low=0;
        int high=Integer.MAX_VALUE;
        int n=matrix.length;
        int m=matrix[0].length;
        while(low<=high){
            int mid=(low+high)>>1;
            int cnt=0;
            for(int i=0;i<n;i++){
                cnt+=countSmallerThanMid(matrix[i],mid);
            }
            if(cnt<=(n*m)/2)low=mid+1;
            else high=mid-1;
            
        }
        return low;
    }
    int countSmallerThanMid(int a[],int mid){
        int l=0;
        int h=a.length-1;
        while(l<=h){
          int md=(l+h)>>1;
            if(a[md]<=mid){
                l=md+1;
            }
            else h=md-1;
        }
        return l;
    }
}