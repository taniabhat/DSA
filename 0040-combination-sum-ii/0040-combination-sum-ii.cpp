class Solution {
public:
    vector<vector<int>> ans;
    void backtrack(vector<int>& candidates, int idx, int target, vector<int>& curr){
        //base case
        if(target==0){
            ans.push_back(curr);
            return;
        }

        //if(idx==candidates.size() || target<0) return;

        for(int i=idx;i<candidates.size();i++){
            //remove duplicates
            if(i>idx && candidates[i]==candidates[i-1]) continue;

            if(candidates[i]>target) break;

            //pick
            curr.push_back(candidates[i]);
            backtrack(candidates,i+1,target-candidates[i],curr);
            curr.pop_back();
        }
        
        

        //not pick
        //backtrack(candidates,idx+1,target,curr);
    }
    vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
        vector<int> curr;
        sort(candidates.begin(),candidates.end());
        backtrack(candidates,0,target,curr);
        return ans;
    }
};