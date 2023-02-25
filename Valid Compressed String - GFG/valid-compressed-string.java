//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            String T = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.checkCompressed(S,T));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int checkCompressed(String S, String T) {
        // code here
        int i=0,j=0;
        while(i<S.length() && j<T.length()){
            if(S.charAt(i)==T.charAt(j)){
                i++;
                j++;
            }
            else{
                int cnt=0;
                if(Character.isDigit(T.charAt(j))){
                    while(j<T.length()&& Character.isDigit(T.charAt(j))){
                        cnt=cnt*10+T.charAt(j)-'0';
                        j++;
                    }
                    i+=cnt;
                }
                else{
                    return 0;
                }
            }
        }
        if(i==S.length() && j==T.length())return 1;
        return 0;
    }
}