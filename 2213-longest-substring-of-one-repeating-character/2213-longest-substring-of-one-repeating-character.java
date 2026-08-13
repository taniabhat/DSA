class Solution {
    class Node {
        char leftChar, rightChar;
        int prefixLen, suffixLen, maxLen;

        Node(char c) {
            leftChar = c;
            rightChar = c;
            prefixLen = 1;
            suffixLen = 1;
            maxLen = 1;
        }

        Node(char leftChar, char rightChar, int prefixLen, int suffixLen, int maxLen) {
            this.leftChar = leftChar;
            this.rightChar = rightChar;
            this.prefixLen = prefixLen;
            this.suffixLen = suffixLen;
            this.maxLen = maxLen;
        }
    }

    private Node[] tree;
    private char[] chars;

    private Node merge(Node left, Node right) {
        char lChar = left.leftChar;
        char rChar = right.rightChar;
        
        int pLen = left.prefixLen;
        if (left.prefixLen == (right.leftChar == left.leftChar ? 0 : -1)) { 
        }
        
        int totalLeftLen = 0;
        
        return left; 
    }

    class SegmentTree {
        int n;
        char[] s;
        int[] treeMax;
        int[] treePrefix;
        int[] treeSuffix;
        char[] treeLeftChar;
        char[] treeRightChar;

        public SegmentTree(String str) {
            s = str.toCharArray();
            n = s.length;
            treeMax = new int[4 * n];
            treePrefix = new int[4 * n];
            treeSuffix = new int[4 * n];
            treeLeftChar = new char[4 * n];
            treeRightChar = new char[4 * n];
            build(1, 0, n - 1);
        }

        private void pushUp(int node, int leftLen, int rightLen) {
            int leftNode = 2 * node;
            int rightNode = 2 * node + 1;

            treeLeftChar[node] = treeLeftChar[leftNode];
            treeRightChar[node] = treeRightChar[rightNode];

            treePrefix[node] = treePrefix[leftNode];
            if (treeLeftChar[leftNode] == treeLeftChar[rightNode] && treePrefix[leftNode] == leftLen) {
                treePrefix[node] += treePrefix[rightNode];
            }

            treeSuffix[node] = treeSuffix[rightNode];
            if (treeRightChar[rightNode] == treeRightChar[leftNode] && treeSuffix[rightNode] == rightLen) {
                treeSuffix[node] += treeSuffix[leftNode];
            }

            treeMax[node] = Math.max(treeMax[leftNode], treeMax[rightNode]);
            if (treeRightChar[leftNode] == treeLeftChar[rightNode]) {
                treeMax[node] = Math.max(treeMax[node], treeSuffix[leftNode] + treePrefix[rightNode]);
            }
        }

        private void build(int node, int start, int end) {
            if (start == end) {
                treeMax[node] = 1;
                treePrefix[node] = 1;
                treeSuffix[node] = 1;
                treeLeftChar[node] = s[start];
                treeRightChar[node] = s[start];
                return;
            }
            int mid = (start + end) / 2;
            build(2 * node, start, mid);
            build(2 * node + 1, mid + 1, end);
            pushUp(node, mid - start + 1, end - mid);
        }

        public void update(int node, int start, int end, int idx, char c) {
            if (start == end) {
                s[idx] = c;
                treeLeftChar[node] = c;
                treeRightChar[node] = c;
                return;
            }
            int mid = (start + end) / 2;
            if (idx <= mid) {
                update(2 * node, start, mid, idx, c);
            } else {
                update(2 * node + 1, mid + 1, end, idx, c);
            }
            pushUp(node, mid - start + 1, end - mid);
        }

        public int queryMax() {
            return treeMax[1];
        }
    }

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        int k = queryIndices.length;
        int[] ans = new int[k];
        SegmentTree st = new SegmentTree(s);

        for (int i = 0; i < k; i++) {
            st.update(1, 0, s.length() - 1, queryIndices[i], queryCharacters.charAt(i));
            ans[i] = st.queryMax();
        }

        return ans;
    }
}