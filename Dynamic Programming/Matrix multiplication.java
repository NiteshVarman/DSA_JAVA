import java.util.*;

class Solution {
    public static int mcm(int[] arr, int i, int j, int[][] dp) {
        if (i == j) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int ans = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int cost1 = mcm(arr, i, k, dp); // a1....ak => a[i-1]*a[k]
            int cost2 = mcm(arr, k + 1, j, dp); // ai+1....aj => a[k]*a[j]
            int cost3 = arr[i - 1] * arr[k] * arr[j];
            int finalcost = cost1 + cost2 + cost3;
            ans = Math.min(ans, finalcost);
        }
        return dp[i][j] = ans;
    }

    public static void main(String args[]) {
        Solution s = new Solution();
        int arr[] = { 1, 2, 3, 4, 3 };
        int n = arr.length;
        int dp[][] = new int[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(mcm(arr, 1, n - 1, dp));
    }
}