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
    private int res=0;
    public int averageOfSubtree(TreeNode root) {
        postOrder(root);
        return res;
        
    }
    private int[] postOrder(TreeNode node){
        int currSum=0;
        int currCnt=0;
        if(node==null) return new int[] {currSum, currCnt};

        int[] left=postOrder(node.left);
        int[] right=postOrder(node.right);

        currSum=node.val+left[0]+right[0];
        currCnt=1+left[1]+right[1];

        if(currSum/currCnt==node.val) res++;

        return new int[] {currSum, currCnt};
    }
}