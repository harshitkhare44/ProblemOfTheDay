//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            char [][] board = new char[n][m];
            for(int i = 0; i < n; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    board[i][j] = s[j].charAt(0);
                }
            }
            String word = br.readLine().trim();
            Solution obj = new Solution();
            boolean ans = obj.isWordExist(board, word);
            if(ans)
                System.out.println("1");
            else
                System.out.println("0");
       }
    }
}
// } Driver Code Ends


class Solution
{
    public boolean isWordExist(char[][] board, String word)
    {
        // Code here
        int n=board.length;
        int m=board[0].length;
  for(int i=0;i<board.length;i++){
      for(int j=0;j<board[0].length;j++){
          if(board[i][j]==word.charAt(0)){
              if(solve(i,j,n,m,board,word,0))return true;
          }
      }
  }
  return false;
    }
    boolean solve(int i,int j,int n,int m,char[][]board,String word,int k){
        if(k>=word.length())return true;
        if(i<0 || j<0 || i>=n || j>=m || board[i][j]!=word.charAt(k))return false;
        int di[]={1,0,0,-1};
        int dj[]={0,-1,1,0};
        board[i][j]='*';
        boolean temp=false;
        for(int ind=0;ind<4;ind++){
            int nexti=i+di[ind];
            int nextj=j+dj[ind];
     if(solve(nexti,nextj,n,m,board,word,k+1)==true)return true;
        
        }
        board[i][j]=word.charAt(k);
        return false;
    }
}