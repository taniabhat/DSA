class Solution {
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<int> ds;
        vector<vector<int>> result;
        printF(0,nums,ds,result);
        return result;
    }

    void printF(int idx,vector<int> &nums,vector<int> &ds, vector<vector<int>> &result){
        if(idx==nums.size()){
            result.push_back(ds);
            return;
        }
        ds.push_back(nums[idx]);
        printF(idx+1,nums,ds,result);

        ds.pop_back();
        printF(idx+1,nums,ds,result);
    }
};