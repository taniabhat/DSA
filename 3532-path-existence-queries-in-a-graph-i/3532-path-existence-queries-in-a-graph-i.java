class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int[] componentId = new int[n];
        int currentId = 0;
        componentId[0] = 0;
        
        // Pre-process: Assign component IDs
        for (int i = 1; i < n; i++) {
            if (nums[i] - nums[i - 1] > maxDiff) {
                currentId++;
            }
            componentId[i] = currentId;
        }
        
        // Process Queries
        boolean[] result = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            result[i] = (componentId[u] == componentId[v]);
        }
        
        return result;
    }
}