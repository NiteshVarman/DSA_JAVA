class Solution {
    public static int coinchange(int[] coins, int sum) {
        int n = coins.length;
        int dp[][] = new int[n + 1][sum + 1];

        // Initialize memoization table with -1 (indicating uncalculated states)
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                dp[i][j] = -1;
            }
        }

        return coinchangeUtil(coins, sum, n, dp);
    }

    // Utility function for memoized recursion
    public static int coinchangeUtil(int[] coins, int sum, int n, int[][] dp) {
        // Base cases
        if (sum == 0) {
            return 1; // There's one way to make sum 0 (by choosing no coins)
        }
        if (n == 0 || sum < 0) {
            return 0; // If no coins are left or sum becomes negative, no way exists
        }

        // If result is already calculated, return the stored result
        if (dp[n][sum] != -1) {
            return dp[n][sum];
        }

        // Recursive case
        if (coins[n - 1] <= sum) {
            // Option 1: Include the coin and reduce the sum
            // Option 2: Exclude the coin and solve for the remaining coins
            dp[n][sum] = coinchangeUtil(coins, sum - coins[n - 1], n, dp) // Include the coin
                    + coinchangeUtil(coins, sum, n - 1, dp); // Exclude the coin
        } else {
            // If the coin is too large to be included, exclude it
            dp[n][sum] = coinchangeUtil(coins, sum, n - 1, dp);
        }

        return dp[n][sum]; // Return the computed result
    }

    public static void main(String args[]) {
        Solution s = new Solution();
        int coins[] = { 1, 2, 3 };
        int sum = 4;
        System.out.println(coinchange(coins, sum)); // Output should be 4
    }
}
