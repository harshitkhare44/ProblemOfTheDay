//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int n = sc.nextInt();
            String[] arr = new String[n];
            for(int i=0;i<n;i++)
            {
                arr[i] = sc.next();
            }
            
            int k = Integer.parseInt(sc.next());
            
            String str = sc.next();
            
            Solution obj = new Solution();
            int ans = obj.klengthpref(arr,n,k,str);
            System.out.println(ans);
            
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
   public int klengthpref(String[] a, int n, int k, String str)
    {
        int c=0;
        
        for(int i=0;i<n;i++)
        {
            
            
            for(int j=0;j<k;j++)
            {
                if(k>a[i].length()||k>str.length())
                {
                    break;
                }
                if(a[i].charAt(j)==str.charAt(j))
                {
                    if(j==k-1)
                    {
                        c++;
                    }
                    
                }else
                {
                    break;
                }
            }
        }
        
       
       return c;
       
       }
}