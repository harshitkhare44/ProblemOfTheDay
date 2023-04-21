//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tc = scan.nextInt();

        while (tc-- > 0) {
            int N = scan.nextInt();
            int M = scan.nextInt();
            int E = scan.nextInt();

            boolean graph[][] = new boolean[N][N];

            for (int i = 0; i < E; i++) {
                int u = scan.nextInt() - 1;
                int v = scan.nextInt() - 1;
                graph[u][v] = true;
                graph[v][u] = true;
            }

            System.out.println(new solve().graphColoring(graph, M, N) ? 1 : 0);
        }
    }
}

// } Driver Code Ends


class solve {
    // Function to determine if graph can be coloured with at most M colours
    // such
    // that no two adjacent vertices of graph are coloured with same colour.
    public boolean graphColoring(boolean graph[][], int m, int n) {
        // Your code here
        int color[]=new int[n];
        Arrays.fill(color,-1);
        if(solve(0,color,graph,n,m)==true)return true;
        return false;
    }
    boolean solve(int node,int[]color,boolean[][]graph,int n,int m){
        if(node==n)return true;
        for(int i=1;i<=m;i++){
           if( isSafe(node,color,graph,n,i)){
                color[node]=i;
               if( solve(node+1,color,graph,n,m)==true)return true;
                color[node]=0;
            }
        }
        return false;
    }
    boolean isSafe(int node,int[]color,boolean [][]graph,int n,int col){
        for(int i=0;i<graph[node].length;i++){
          if(graph[node][i]==true){
              if(color[i]==col)return false;
          }
        }
        return true;
    }
}