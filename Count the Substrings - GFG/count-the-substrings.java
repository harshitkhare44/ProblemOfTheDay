//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String S = read.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.countSubstring(S);
            System.out.println(ans);
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    int countSubstring(String S) 
    { 
        // code here
        int ans=0;
        int low=0;
        int up=0;
        for(int i=0;i<S.length();i++){
            low=0;
            up=0;
            char ch=S.charAt(i);
            if(Character.isLowerCase(ch)){
                low++;
            }
            else up++;
            for(int j=i+1;j<S.length();j++){
                char k=S.charAt(j);
                   if(Character.isLowerCase(k)){
                low++;
            }
            else up++;
            if(low==up)ans++;
            }
        }
        return ans;
    }
} 
