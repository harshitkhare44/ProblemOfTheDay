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
            
            
            int[] S = IntArray.input(br, N);
            
            
            int[] F = IntArray.input(br, N);
            
            Solution obj = new Solution();
            ArrayList<Integer> res = obj.maxMeetings(N, S, F);
            
            IntArray.print(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
      static class meeting{
        int start;
        int end;
        int pos;
        public meeting(int start,int end,int pos){
            this.start=start;
            this.end=end;
            this.pos=pos;
        }
    }
   static class meetingComparator implements Comparator<meeting>
    {
        @Override
        public int compare(meeting o1,meeting o2){
            if(o1.end<o2.end)
            return -1;
            else if(o1.end>o2.end){
                return 1;
            }
            else if(o1.pos<o2.pos){
                return -1;
            }
            return 1;
        }
    }
    public static ArrayList<Integer> maxMeetings(int n, int[] start, int[] end) {
        // code here
         ArrayList<meeting>meet=new ArrayList<>();
        for(int i=0;i<start.length;i++){
            meet.add(new meeting(start[i],end[i],i+1));
        }
        meetingComparator mc=new meetingComparator();
        Collections.sort(meet,mc);
        ArrayList<Integer>ans=new ArrayList<>();
        ans.add(meet.get(0).pos);
      int limit=(meet.get(0).end);
      for(int i=1;i<start.length;i++){
          if(meet.get(i).start>limit){
              limit=meet.get(i).end;
              ans.add(meet.get(i).pos);
          }
      }
      Collections.sort(ans);
      return ans;
    }
    
}
        
