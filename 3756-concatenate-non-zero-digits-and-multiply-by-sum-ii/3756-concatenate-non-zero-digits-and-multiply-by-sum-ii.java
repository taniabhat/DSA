class Solution {
    public int[] sumAndMultiply(String s, int[][] queries) {
        int MOD = 1000000007;
        int m = s.length();
        
        // Arrays to hold non-zero digits and their original positions
        int[] pos = new int[m];
        int[] vals = new int[m];
        int n = 0; // Count of non-zero digits
        
        // 1. Extract non-zero digits
        for (int i = 0; i < m; i++) {
            int digit = s.charAt(i) - '0';
            if (digit != 0) {
                pos[n] = i;
                vals[n] = digit;
                n++;
            }
        }
        
        // 2. Precompute Prefix Arrays (1-indexed for easier range calculations)
        long[] prefSum = new long[n + 1];
        long[] prefVal = new long[n + 1];
        long[] pow10 = new long[n + 1];
        pow10[0] = 1;
        
        for (int i = 0; i < n; i++) {
            prefSum[i + 1] = prefSum[i] + vals[i];
            prefVal[i + 1] = (prefVal[i] * 10 + vals[i]) % MOD;
            pow10[i + 1] = (pow10[i] * 10) % MOD;
        }
        
        // 3. Answer Queries
        int[] ans = new int[queries.length];
        for (int q = 0; q < queries.length; q++) {
            int l = queries[q][0];
            int r = queries[q][1];
            
            // Find the index range in our 'pos' array
            int start = lowerBound(pos, n, l);
            int end = upperBound(pos, n, r);
            
            // If no non-zero digits fall in the range [l, r]
            if (start > end || start == n || end == -1) {
                ans[q] = 0;
                continue;
            }
            
            // Calculate sum of digits in range
            long currentSum = prefSum[end + 1] - prefSum[start];
            
            // Calculate concatenated value (x) in range using modular arithmetic
            int len = end - start + 1;
            long x = (prefVal[end + 1] - (prefVal[start] * pow10[len]) % MOD + MOD) % MOD;
            
            ans[q] = (int) ((x * currentSum) % MOD);
        }
        
        return ans;
    }
    
    // Helper: Finds the first index in 'arr' where value >= target
    private int lowerBound(int[] arr, int len, int target) {
        int low = 0, high = len - 1;
        int ans = len;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
    
    // Helper: Finds the last index in 'arr' where value <= target
    private int upperBound(int[] arr, int len, int target) {
        int low = 0, high = len - 1;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] <= target) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}