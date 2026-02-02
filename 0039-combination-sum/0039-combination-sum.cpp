class Solution {
public:
    vector<vector<int>> ans;
    void backtrack(vector<int>& candidates, int idx, int target, vector<int>& curr){
        if(target==0){
            ans.push_back(curr);
            return;
        }

        if(idx==candidates.size() || target<0) return;

        curr.push_back(candidates[idx]);
        backtrack(candidates,idx,target-candidates[idx],curr);
        curr.pop_back();

        backtrack(candidates,idx+1,target,curr);
    }
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        vector<int> curr;
        backtrack(candidates,0,target,curr);
        return ans;
    }
};