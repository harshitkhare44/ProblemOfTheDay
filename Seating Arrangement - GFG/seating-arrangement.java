//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int test = Integer.parseInt(in.readLine().trim());
        while(test-- > 0){
            int n = Integer.parseInt(in.readLine().trim());
            int m = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            int [] seats = new int[m];
            for(int i = 0; i < m; i++){
                seats[i] = Integer.parseInt(s[i]);
            }
            Solution obj = new Solution();
            boolean res = obj.is_possible_to_get_seats(n, m, seats);
            
            String _result_val = (res) ? "Yes" : "No";
            out.println(_result_val);
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution {
    public static boolean is_possible_to_get_seats(int n, int m, int[] seats) {
        // code here
        if(n==0)return true;
        if(m==0)return false;
        int cnt=n;
        if(n==1 && m==1){
            if(seats[0]==0)
            return true;
        }
        boolean check=false;
        for(int i=0;i<m;i++){
            if(i==0){
                  if(seats[0]==0 && seats[1]==0){
            seats[0]=1;
            cnt--;
        }
            }
            else if(i==m-1){
                    if(seats[m-1]==0 && seats[m-2]==0){
           
                  seats[m-1]=1;
            cnt--;
                 }
            }
            else{
            if(seats[i]==0){
                if(seats[i-1]!=1 && seats[i+1]!=1){
                    seats[i]=1;
                    cnt--;
                }
               
            }
            }
             if(cnt<=0)return true;
        }
      
     
                     if(cnt<=0)return true;
    
    return false;
}
}
