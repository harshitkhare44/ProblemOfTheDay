//{ Driver Code Starts
//Initial Template for Java

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
            int n = Integer.parseInt(br.readLine().trim());
            String[] S = br.readLine().split(" ");
            int[] nums = new int[n];
            for(int i = 0; i < n; i++)
                nums[i] = Integer.parseInt(S[i]);
            Solution ob = new Solution();
            int ans = ob.ZigZagMaxLength(nums);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int ZigZagMaxLength(int[] nums)
    {
      
        	if (nums.length == 0 || nums.length == 1) {
			return nums.length;
		}
		int k = 0;
		while (k < nums.length - 1 && nums[k] == nums[k + 1]) {  
			k++;
		}
		if (k == nums.length - 1) {
			return 1;
		}
		int result = 2;   
		boolean smallReq = nums[k] < nums[k + 1];      
		for (int i = k + 1; i < nums.length - 1; i++) {
			if (smallReq && nums[i + 1] < nums[i]) {
				nums[result] = nums[i + 1];
				result++;
				smallReq = !smallReq;    //Toggle the requirement from small to big number
			} else {
				if (!smallReq && nums[i + 1] > nums[i]) {
					nums[result] = nums[i + 1];
					result++;
					smallReq = !smallReq;    //Toggle the requirement from big to small number
				}
			}
		}
		return result;
    }
}