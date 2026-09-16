class Solution {
    public int numberOfSets(int n, int k) {
        int MOD = 1000000007;

        long[][] dp = new long[n][k + 1];

        // With 0 segments, there is exactly 1 way
        dp[0][0] = 1;

        for (int i = 1; i < n; i++) {
            dp[i][0] = 1;
        }

        for (int j = 1; j <= k; j++) {

            long sum = 0;

            for (int i = 1; i < n; i++) {

                // Ways where we don't use point i
                dp[i][j] = dp[i - 1][j];

                // Add possible starting points of the new segment
                if (i >= 1) {
                    sum = (sum + dp[i - 1][j - 1]) % MOD;
                }

                dp[i][j] = (dp[i][j] + sum) % MOD;
            }
        }

        return (int) dp[n - 1][k];
    }
}