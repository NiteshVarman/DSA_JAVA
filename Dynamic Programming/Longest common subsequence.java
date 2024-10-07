import java.util.*;

class Solution {
    public int lcs(String text1, String text2, int n, int m, int dp[][]) {
        if (n == 0 || m == 0) {
            return 0;
        }

        if (dp[n][m] != -1) {
            return dp[n][m];
        }

        if (text1.charAt(n - 1) == text2.charAt(m - 1)) {
            return dp[n][m] = lcs(text1, text2, n - 1, m - 1, dp) + 1;
        } else {
            int ans1 = lcs(text1, text2, n - 1, m, dp);
            int ans2 = lcs(text1, text2, n, m - 1, dp);
            return dp[n][m] = Math.max(ans1, ans2);
        }
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int dp[][] = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = -1;
            }
        }
        return lcs(text1, text2, n, m, dp);
    }

    public static void main(String args[]) {
        Solution s = new Solution();
        Scanner sc = new Scanner(System.in);

        // Taking input for text1
        System.out.print("Enter the first string (text1): ");
        String text1 = sc.nextLine();

        // Taking input for text2
        System.out.print("Enter the second string (text2): ");
        String text2 = sc.nextLine();
        System.out.println("Length of LCS is " + s.longestCommonSubsequence(text1, text2));
    }
}