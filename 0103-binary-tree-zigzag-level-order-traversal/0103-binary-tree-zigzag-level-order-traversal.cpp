/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
        if(root==NULL) return {};
        queue<TreeNode*> q;
        vector<vector<int>> levels;
        q.push(root);
        bool ltor=true;
        while(!q.empty()){
            int sz=q.size();
            vector<int> currlev(sz);

            for(int i=0;i<sz;i++){
                TreeNode* node=q.front();
                q.pop();
                int idx= ltor? i:sz-1-i;
                currlev[idx]=node->val;
                if(node->left!=NULL) q.push(node->left);
                if(node->right!=NULL) q.push(node->right);
            }
            ltor=!ltor;
            levels.push_back(currlev);
        }
        return levels;
    }
};