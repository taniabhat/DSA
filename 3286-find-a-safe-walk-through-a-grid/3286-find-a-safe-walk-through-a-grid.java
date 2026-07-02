class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();
        
        // minHealth[i][j] stores the minimum health points lost to reach cell (i, j)
        int[][] minHealth = new int[m][n];
        for (int[] row : minHealth) Arrays.fill(row, Integer.MAX_VALUE);
        
        Deque<int[]> deque = new ArrayDeque<>();
        
        // Initial cell cost
        int startCost = grid.get(0).get(0);
        minHealth[0][0] = startCost;
        deque.offerFirst(new int[]{0, 0});
        
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        while (!deque.isEmpty()) {
            int[] curr = deque.pollFirst();
            int r = curr[0], c = curr[1];
            
            for (int[] d : directions) {
                int nr = r + d[0], nc = c + d[1];
                
                if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                    int newCost = minHealth[r][c] + grid.get(nr).get(nc);
                    
                    if (newCost < minHealth[nr][nc]) {
                        minHealth[nr][nc] = newCost;
                        if (grid.get(nr).get(nc) == 0) {
                            deque.offerFirst(new int[]{nr, nc});
                        } else {
                            deque.offerLast(new int[]{nr, nc});
                        }
                    }
                }
            }
        }
        
        return health - minHealth[m - 1][n - 1] > 0;
    }
}