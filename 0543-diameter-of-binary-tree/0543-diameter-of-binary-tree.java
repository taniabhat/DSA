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
    public int diameterOfBinaryTree(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        
        int dia=0;
        while(!q.isEmpty()){
            TreeNode node=q.poll();
            int leftH=height(node.left);
            int rightH=height(node.right);

            dia=Math.max(dia, leftH+rightH);

            if(node.left!=null) q.offer(node.left);
            if(node.right!=null) q.offer(node.right);

        }
        return dia;
    }
    private int height(TreeNode root){
        if(root==null) return 0;
        int ht=0;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                if(node.left!=null) q.offer(node.left);
                if(node.right!=null) q.offer(node.right);
            }
            ht++;
        }
        return ht;
    }
}