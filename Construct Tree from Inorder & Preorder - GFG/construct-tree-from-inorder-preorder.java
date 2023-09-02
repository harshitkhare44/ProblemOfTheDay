//{ Driver Code Starts
import java.util.*;
import java.io.*;
class Node
{
    int data; 
    Node left, right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}

class GFG
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node root = null;
            int inorder[] = new int[n];
            int preorder[] = new int[n];
            for(int i = 0; i < n; i++)
              inorder[i] = sc.nextInt();
              
            for(int i = 0; i < n; i++)
              preorder[i] = sc.nextInt();
              
            Solution ob = new Solution();
            root = ob.buildTree(inorder, preorder, n);
            postOrdrer(root);
            System.out.println();
        }
    }
    
    public static void postOrdrer(Node root)
    {
        if(root == null)
          return;
          
        postOrdrer(root.left);
        postOrdrer(root.right);
        System.out.print(root.data + " ");
    }
}
// } Driver Code Ends


class Solution
{   
    public static Node buildTreeHelper(int inorder[], int preorder[], int siPre, int eiPre, int siIn, int eiIn){
        if(siPre > eiPre){
            return null;
        }
        
        int rootData = preorder[siPre];
        Node root = new Node(rootData);
        int rootIndex = -1;
        for(int i=siIn; i<=eiIn; i++){
            if(inorder[i] == rootData){
                rootIndex = i;
                break;
            }
        }
        
        int siPreLeft = siPre + 1;
        int siInLeft = siIn;
        int eiInLeft = rootIndex -1;
        int siInRight  = rootIndex + 1;
        int eiPreRight = eiPre;
        int eiInRight = eiIn;
        
        int leftSubtreeLength = eiInLeft - siInLeft + 1;
        
        int eiPreLeft = siPreLeft + leftSubtreeLength - 1;
        int siPreRight = eiPreLeft + 1;
        
        Node left = buildTreeHelper(inorder, preorder, siPreLeft, eiPreLeft, siInLeft, eiInLeft);
        Node right = buildTreeHelper(inorder, preorder, siPreRight, eiPreRight, siInRight, eiInRight);
        root.left = left;
        root.right = right;
        return root;
    }
    public static Node buildTree(int inorder[], int preorder[], int n)
    {
        Node root = buildTreeHelper(inorder, preorder, 0, preorder.length -1, 0, inorder.length -1);     
        return root;
    }
}