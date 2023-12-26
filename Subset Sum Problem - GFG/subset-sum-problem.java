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
     boolean prev[]=new boolean[10001];
     prev[0]=true;
     prev[arr[0]]=true;
     for(int i=1;i<N;i++){
         boolean temp[]=new boolean[10001];
         temp[0]=true;
         for(int j=1;j<=sum;j++){
             boolean nk=prev[j];
             boolean tk=false;
             if(arr[i]<=j)tk=prev[j-arr[i]];
             if(nk==true || tk==true)temp[j]=true;
             else temp[j]=false;
         }
         prev=temp;
     }
     return prev[sum];
    }
    
}