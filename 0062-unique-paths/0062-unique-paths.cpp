class Solution {
public:
    vector<vector<int>> dp;
    int rec(int i, int j){
        if(i==0 && j==0) return 1;
        if(i<0 || j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int up=rec(i-1,j);
        int left=rec(i,j-1);
        return dp[i][j]=left+up;
    }
    int uniquePaths(int m, int n) {
        dp.assign(m,vector<int> (n,-1));
        return rec(m-1,n-1);
    }
};