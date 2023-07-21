class Solution {
    private record Pair(int length, int count) {}
    private int n;
    private Pair[][] dp;

    public int findNumberOfLIS(int[] nums) {
        n = nums.length;
        dp = new Pair[n][n+1];
        return solve(0, -1, nums).count();
    }

    private Pair solve(int idx, int prev, int[] nums) {
        if(idx == n) return new Pair(0, 1);
        if(dp[idx][prev + 1] != null) return dp[idx][prev + 1];
        Pair notPick = solve(idx + 1, prev, nums);
        int notPickLen = notPick.length();
        int notPickCount = notPick.count();
        int pickLen = 0;
        int pickCount = 0;
        if(prev == -1 || nums[idx] > nums[prev]) {
            Pair pick = solve(idx + 1, idx, nums);
            pickLen = pick.length() + 1;
            pickCount = pick.count();
        }
        Pair res = null;
        if(pickLen == notPickLen) {
            res = new Pair(pickLen, pickCount + notPickCount);
        }
        else if(pickLen > notPickLen) {
            res = new Pair(pickLen, pickCount);
        }
        else {
            res = new Pair(notPickLen, notPickCount);
        }
        return dp[idx][prev + 1] = res;
    }
}