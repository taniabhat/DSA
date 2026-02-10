class Solution {
public:
    vector<vector<int>> dp;
    int rec(vector<int> &nums,int i, int j){
        if(i>j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int ans=0;
        for(int k=i;k<=j;k++){
            int c1=rec(nums,i,k-1);
            int c2=rec(nums,k+1,j);
            int c3=nums[k]*nums[i-1]*nums[j+1];
             ans=max(ans,c1+c2+c3);
        }
        return dp[i][j]=ans;
    }
    int maxCoins(vector<int>& nums) {
        nums.insert(nums.begin(),1);
        nums.push_back(1);
        dp.resize(nums.size()+2, vector<int> (nums.size()+2,-1));
        return rec(nums,1,nums.size()-2);
    }
};