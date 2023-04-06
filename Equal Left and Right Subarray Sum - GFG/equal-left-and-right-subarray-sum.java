//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			int N = Integer.parseInt(br.readLine());
			int [] A = new int[N];
			String [] str = br.readLine().trim().split(" ");
			for(int i = 0; i < N; i++)
				A[i] = Integer.parseInt(str[i]);
			Solution ob = new Solution();
			System.out.println(ob.equalSum(A, N));
		}
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
	int equalSum(int [] A, int N) {
		//Write your code here
		if(N==1)return 1;
		int ind=0;
	
		int sum=0;
		for(int i=0;i<N;i++)sum+=A[i];
			int left=0;
		int right=sum-left;
	 for(int i=0;i<N;i++){
	     if(left==right-A[i])return i+1;
	     left+=A[i];
	     right=sum-left;
	 }
	   
	   //while(i<=j){
	       
	   //    if(left==right)return i+1;
	   //    if(left<right){
	   //        left+=A[i];
	   //        i++;
	   //    }
	   //    else if(right<left){
	   //       right+=A[j];
	   //        j--;
	   //    }
	    
	   //}
	   //if(left==right)return i+1;
		return -1;
	}
	
}