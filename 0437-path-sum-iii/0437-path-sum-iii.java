/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> map=new HashMap<>();
        map.put(0L,1);
        return dfs(root, 0L, targetSum,map);
    }
    private int dfs(TreeNode root, Long currsum,int targetSum,  Map<Long, Integer> map){
        if(root==null) return 0;
        currsum+=root.val;

        int cnt=map.getOrDefault(currsum-targetSum,0);
        map.put(currsum,map.getOrDefault(currsum,0)+1);

        cnt+=dfs(root.left, currsum, targetSum,map);
        cnt+=dfs(root.right, currsum, targetSum,map);

        map.put(currsum, map.get(currsum)-1);
        return cnt;
    }
}