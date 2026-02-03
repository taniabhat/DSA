class Solution {
public:
    int partsum=0;
    bool rec(vector<int>& nums, int k, int currsum,vector<bool>& vis, int idx){
        if(k==1) return true;
        if(currsum==partsum){
            return rec(nums, k-1, 0, vis,0);
        }
        for(int i=idx;i<nums.size();i++){
            if(vis[i]) continue;
            if(nums[i]+currsum>partsum) continue;

            vis[i]=true;
            if(rec(nums,k,currsum+nums[i],vis,i+1)) return true;
            vis[i]=false;

            if(currsum==0) return false;
            if(i+1<nums.size() && nums[i]==nums[i+1]) i++;
        }
        return false;
    }
    bool canPartitionKSubsets(vector<int>& nums, int k) {
        int totsum=0;
        for(int i=0;i<nums.size();i++){
            totsum+=nums[i];
        }
        if(totsum%k!=0) return false;
        partsum=totsum/k;
        vector<bool> vis(nums.size(), false);
        sort(nums.rbegin(),nums.rend());
        if(nums[0]>partsum) return false;
        return rec(nums,k,0,vis,0);
    }
};