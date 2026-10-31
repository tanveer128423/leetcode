
class Solution {
    public int uniquePaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int MOD = 1_000_000_007;

        long[] dp = new long[n];
        dp[0] = 1;

        for (int i = 0; i < m; i++) {
            long left = 0;

            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    long temp = dp[j];
                    dp[j] = left;
                    left = temp;
                } else {
                    left = (left + dp[j]) % MOD;
                    dp[j] = left;
                }
            }
        }

        return (int) dp[n - 1];
    }
}
