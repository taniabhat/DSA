
class Solution {
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n = online.length;

        List<int[]>[] graph = new ArrayList[n];
        int[] indegree = new int[n];

        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();

        int maxEdge = 0;

        for (int[] e : edges) {
            graph[e[0]].add(new int[]{e[1], e[2]});
            indegree[e[1]]++;
            maxEdge = Math.max(maxEdge, e[2]);
        }

        // Topological Order
        Queue<Integer> q = new LinkedList<>();
        int[] topo = new int[n];
        int idx = 0;

        for (int i = 0; i < n; i++)
            if (indegree[i] == 0)
                q.offer(i);

        while (!q.isEmpty()) {
            int u = q.poll();
            topo[idx++] = u;

            for (int[] edge : graph[u]) {
                int v = edge[0];
                indegree[v]--;

                if (indegree[v] == 0)
                    q.offer(v);
            }
        }

        int low = 0;
        int high = maxEdge;
        int ans = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (check(mid, topo, graph, online, k, n)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    private boolean check(int limit,
                          int[] topo,
                          List<int[]>[] graph,
                          boolean[] online,
                          long k,
                          int n) {

        long INF = Long.MAX_VALUE / 2;

        long[] dist = new long[n];
        Arrays.fill(dist, INF);

        dist[0] = 0;

        for (int node : topo) {

            if (dist[node] == INF)
                continue;

            if (node != 0 && node != n - 1 && !online[node])
                continue;

            for (int[] edge : graph[node]) {

                int next = edge[0];
                int cost = edge[1];

                if (cost < limit)
                    continue;

                if (next != n - 1 && !online[next])
                    continue;

                dist[next] = Math.min(dist[next], dist[node] + cost);
            }
        }

        return dist[n - 1] <= k;
    }
}