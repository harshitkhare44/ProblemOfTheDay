//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int A[]= new int[N];
            for(int i = 0; i < N; i++)
                A[i] = Integer.parseInt(input_line[i]);

            Solution ob = new Solution();
            long ans = ob.minDifference(N, A); 
            System.out.println(ans);
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    int binarySearch(long arr[],int low,int high,long sum,long temp){
        int mid,index=-1;
        long diff=Integer.MAX_VALUE;
        while(low<=high){
            mid=(low+high)/2;
            long first=arr[mid]-temp;
            long second=sum-arr[mid];
            if(Math.abs(first-second)<diff){
                diff=Math.abs(first-second);
                index=mid;
            }
            if(first<second){
                low=mid+1;
            }
            else high=mid-1;
            }
            return index;
    }
    long minDifference(int N, int A[]) 
    { 
        // code here
        long arr[]=new long[N];
        arr[0]=A[0];
        for(int i=1;i<N;i++){
            arr[i]=arr[i-1]+A[i];
        }
        long ans=Integer.MAX_VALUE;
        long w,x,y,z;
        for(int i=2;i<N-1;i++){
            int index=binarySearch(arr,0,i-1,arr[i-1],0);
            w=arr[index];
            x=arr[i-1]-w;
            index=binarySearch(arr,i,N-1,arr[N-1],arr[i-1]);
            y=arr[index]-arr[i-1];
            z=arr[N-1]-arr[index];
            ans=Math.min(ans,Math.max(Math.max(w,x),Math.max(y,z))-Math.min(Math.min(w,x),Math.min(y,z)));
        }
       return ans; 
    }
} 