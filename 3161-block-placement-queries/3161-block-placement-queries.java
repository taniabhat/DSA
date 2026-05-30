import java.util.*;

class Solution {
    // Segment Tree to maintain the maximum gap size in any range
    class SegmentTree {
        int n;
        int[] tree;

        public SegmentTree(int n) {
            this.n = n;
            this.tree = new int[4 * n];
        }

        public void update(int node, int start, int end, int idx, int val) {
            if (start == end) {
                tree[node] = val;
                return;
            }
            int mid = start + (end - start) / 2;
            if (idx <= mid) {
                update(2 * node, start, mid, idx, val);
            } else {
                update(2 * node + 1, mid + 1, end, idx, val);
            }
            tree[node] = Math.max(tree[2 * node], tree[2 * node + 1]);
        }

        public int query(int node, int start, int end, int l, int r) {
            if (r < start || end < l) {
                return 0;
            }
            if (l <= start && end <= r) {
                return tree[node];
            }
            int mid = start + (end - start) / 2;
            int p1 = query(2 * node, start, mid, l, r);
            int p2 = query(2 * node + 1, mid + 1, end, l, r);
            return Math.max(p1, p2);
        }
    }

    public List<Boolean> getResults(int[][] queries) {
        // Determine the maximum possible coordinate boundary M
        int M = 0;
        for (int[] q : queries) {
            M = Math.max(M, q[1]);
        }
        // Safely buffer the size to handle boundary cases smoothly
        int maxRange = M + 2;

        SegmentTree st = new SegmentTree(maxRange);
        TreeSet<Integer> obstacles = new TreeSet<>();
        
        // Base boundaries
        obstacles.add(0);
        obstacles.add(maxRange);
        st.update(1, 0, maxRange - 1, maxRange, maxRange);

        List<Boolean> results = new ArrayList<>();

        for (int[] q : queries) {
            int type = q[0];
            if (type == 1) {
                int x = q[1];
                
                int prev = obstacles.floor(x);
                int next = obstacles.ceiling(x);
                
                obstacles.add(x);
                
                // Update gaps in the segment tree
                st.update(1, 0, maxRange - 1, x, x - prev);
                st.update(1, 0, maxRange - 1, next, next - x);
                
            } else {
                int x = q[1];
                int sz = q[2];
                
                // Find the closest obstacle <= x
                int prev = obstacles.floor(x);
                
                // 1. Check max completely-contained gap in [0, prev]
                int maxGapInObstacles = st.query(1, 0, maxRange - 1, 0, prev);
                
                // 2. Check the remaining partial gap between 'prev' and 'x'
                int tailGap = x - prev;
                
                if (Math.max(maxGapInObstacles, tailGap) >= sz) {
                    results.add(true);
                } else {
                    results.add(false);
                }
            }
        }

        return results;
    }
}