class Solution {
    public int zigZagArrays(int n, int l, int r) {
        final long MOD = 1_000_000_007L;

        int m = r - l + 1;

        long[] up = new long[m];
        long[] down = new long[m];

        // Initialize for length = 2
        for (int b = 0; b < m; b++) {
            up[b] = b;              // values smaller than b
            down[b] = m - 1 - b;    // values greater than b
        }

        // Build lengths 3 to n
        for (int len = 3; len <= n; len++) {

            long[] prefUp = new long[m];
            long[] prefDown = new long[m];

            prefUp[0] = up[0];
            prefDown[0] = down[0];

            for (int i = 1; i < m; i++) {
                prefUp[i] = (prefUp[i - 1] + up[i]) % MOD;
                prefDown[i] = (prefDown[i - 1] + down[i]) % MOD;
            }

            long totalUp = prefUp[m - 1];

            long[] newUp = new long[m];
            long[] newDown = new long[m];

            for (int x = 0; x < m; x++) {

                // Previous move was DOWN, so next must go UP
                if (x > 0) {
                    newUp[x] = prefDown[x - 1];
                }

                // Previous move was UP, so next must go DOWN
                newDown[x] = (totalUp - prefUp[x] + MOD) % MOD;
            }

            up = newUp;
            down = newDown;
        }

        long ans = 0;

        for (int i = 0; i < m; i++) {
            ans = (ans + up[i] + down[i]) % MOD;
        }

        return (int) ans;
    }
}