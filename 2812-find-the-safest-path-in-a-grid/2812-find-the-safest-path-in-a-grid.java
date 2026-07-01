import java.util.*;

class Solution {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        if (grid.get(0).get(0) == 1 || grid.get(n - 1).get(n - 1) == 1) return 0;

        // 1. Multi-source BFS to calculate distance to the nearest thief
        int[][] dist = new int[n][n];
        for (int[] row : dist) Arrays.fill(row, -1);
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    dist[i][j] = 0;
                    q.offer(new int[]{i, j});
                }
            }
        }

        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            for (int[] d : dirs) {
                int ni = curr[0] + d[0], nj = curr[1] + d[1];
                if (ni >= 0 && ni < n && nj >= 0 && nj < n && dist[ni][nj] == -1) {
                    dist[ni][nj] = dist[curr[0]][curr[1]] + 1;
                    q.offer(new int[]{ni, nj});
                }
            }
        }

        // 2. Max-Priority Queue to find the path with maximum safeness
        // PriorityQueue stores {safeness, r, c}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        pq.offer(new int[]{dist[0][0], 0, 0});
        
        int[][] maxSafeness = new int[n][n];
        for (int[] row : maxSafeness) Arrays.fill(row, -1);
        maxSafeness[0][0] = dist[0][0];

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int d = curr[0], r = curr[1], c = curr[2];

            if (r == n - 1 && c == n - 1) return d;

            for (int[] dir : dirs) {
                int ni = r + dir[0], nj = c + dir[1];
                if (ni >= 0 && ni < n && nj >= 0 && nj < n) {
                    // The path safeness is the minimum value encountered so far
                    int newSafeness = Math.min(d, dist[ni][nj]);
                    if (newSafeness > maxSafeness[ni][nj]) {
                        maxSafeness[ni][nj] = newSafeness;
                        pq.offer(new int[]{newSafeness, ni, nj});
                    }
                }
            }
        }
        return 0;
    }
}