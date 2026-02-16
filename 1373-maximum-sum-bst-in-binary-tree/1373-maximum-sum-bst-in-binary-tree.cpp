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
class NodeVal{
public:
    int minval, maxval, sum;
    NodeVal(int minval, int maxval, int sum){
        this->minval=minval;
        this->maxval=maxval;
        this->sum=sum;
    }
};
class Solution {
private:
    int ans=0;
    NodeVal msbbt(TreeNode* root){
        //if NULL then we will return the INTMAX fr minval, and INTMIN for maxval
        if(!root) return NodeVal(INT_MAX,INT_MIN,0);

        //traverse throught the left and right
        auto left=msbbt(root->left);
        auto right=msbbt(root->right);

        //VALID BST
        //root should be larger than the smallest val in left tree and 
        //smaller than the largest value in right tree
        if(root->val>left.maxval && root->val<right.minval){
            int currsum=left.sum+right.sum+root->val;
            ans=max(ans,currsum);
            return NodeVal(min(root->val,left.minval), max(root->val,right.maxval), currsum);
        }
        //if none of the baove follows, return the INTMIN for minval, and INTMAX for maxval and
        //maxsize i.e. INVALID BST
        return NodeVal(INT_MIN,INT_MAX,0);

    }
public:
    int maxSumBST(TreeNode* root) {
        msbbt(root);
        return ans;
    }
};