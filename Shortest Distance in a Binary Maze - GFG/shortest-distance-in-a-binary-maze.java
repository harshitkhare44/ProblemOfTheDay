//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }
            int[] source = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                source[i] = x;
            }
            int[] dest = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                dest[i] = x;
            }
            Solution ob = new Solution();
            int ans = ob.shortestPath(grid, source, dest);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int shortestPath(int[][] grid, int[] source, int[] destination) {

        // Your code here
        int f1=source[0];
        int f2=source[1];
        if(grid[f1][f2]==0)return -1;
        Queue<int[]>q=new LinkedList<>();
        q.add(new int[]{f1,f2,0});
        grid[f1][f2]=0;
        int [][]dir={{0,1},{1,0},{-1,0},{0,-1}};
        while(!q.isEmpty()){
            int size=q.size();
            
            while(size-->0){
                int[]point=q.poll();
                if(point[0]==destination[0] && point[1]==destination[1])return point[2];
                for(int [] d:dir){
                    int r=point[0]+d[0];
                    int c=point[1]+d[1];
                    if(r>=0 && c>=0 && r<grid.length && c<grid[0].length && grid[r][c]==1){
                        q.add(new int[]{r,c,point[2]+1});
                        grid[r][c]=0;
                    }
                }
            }
            
        }
        return -1;
    }
}
