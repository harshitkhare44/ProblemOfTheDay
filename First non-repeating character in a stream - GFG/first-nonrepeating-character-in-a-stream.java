//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String A = br.readLine().trim();
            Solution ob = new Solution();
            String ans = ob.FirstNonRepeating(A);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution
{
    public String FirstNonRepeating(String A)
    {
        // code here
        StringBuilder result = new StringBuilder();
        HashMap<Character,Integer>map1=new LinkedHashMap<>();
        for(int i=0;i<A.length();i++){
            char ch=A.charAt(i);
            map1.put(ch,map1.getOrDefault(ch,0)+1);
            
            char s='#';
            for(Map.Entry<Character,Integer>y:map1.entrySet()){
                if(y.getValue()==1){
                    s=y.getKey();
                    break;
                }
            }
            result.append(s);
        }
        return result.toString();
    }
}