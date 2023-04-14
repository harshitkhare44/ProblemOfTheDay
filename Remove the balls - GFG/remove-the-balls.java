//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int N;
            N = Integer.parseInt(br.readLine());
            
            
            int[] color = IntArray.input(br, N);
            
            
            int[] radius = IntArray.input(br, N);
            
            Solution obj = new Solution();
            int res = obj.finLength(N, color, radius);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    static class Pair{
        int first;
        int second;
        public Pair(int first,int second){
            this.first=first;
            this.second=second;
        }
    }
    static class comp implements Comparator<Pair>{
        @Override
        public int compare(Pair o1,Pair o2){
            if(o1.first<o2.first)return -1;
            else if(o1.first>o2.first)return 1;
            return 1;
        }
    }
    public static int finLength(int N, int[] color, int[] radius) {
        // code here
        Stack<Pair>st=new Stack<>();
        List<Pair>arr=new ArrayList<>();

        
        for(int i=0;i<N;i++){
            arr.add(new Pair(color[i],radius[i]));
        }
        // comp mc=new comp();
        // Collections.sort(arr,mc);
      
        for(int i=0;i<N;i++){
            if(st.size()>0 &&(st.peek().first==arr.get(i).first  && st.peek().second==arr.get(i).second)){
                st.pop();
            }
            else
            st.push(arr.get(i));
        }
        return st.size();
        
    }
}
        
