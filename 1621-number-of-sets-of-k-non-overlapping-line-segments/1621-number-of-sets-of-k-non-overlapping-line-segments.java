class Solution {
    public int numberOfSets(int n, int k) {
        int MOD = 1000000007;

        int total = n + k - 1;
        int choose = 2 * k;

        long[][] dp = new long[total + 1][choose + 1];

        // C(0, 0) = 1
        dp[0][0] = 1;

        for (int i = 1; i <= total; i++) {
            dp[i][0] = 1;

            for (int j = 1; j <= choose && j <= i; j++) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % MOD;
            }
        }

        return (int) dp[total][choose];
    }
}