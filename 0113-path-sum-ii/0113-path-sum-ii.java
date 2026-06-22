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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result= new ArrayList<>();
        List<Integer> currpath=new ArrayList<>();
        dfs(root, targetSum, currpath, result);
        return result;
    }
    public void dfs(TreeNode root, int targetSum, List<Integer> currpath, List<List<Integer>> result){
        if(root==null) return;

        currpath.add(root.val);
        if(root.left==null && root.right==null && root.val==targetSum){
            result.add(new ArrayList<>(currpath));
        }
        else{
            dfs(root.left, targetSum-root.val, currpath, result);
            dfs(root.right, targetSum-root.val,currpath, result);
        }
        currpath.remove(currpath.size()-1);
    }
}