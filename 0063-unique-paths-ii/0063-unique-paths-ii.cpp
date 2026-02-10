class Solution {
public:
    vector<vector<int>> dp;
    int rec(vector<vector<int>>& obstacleGrid,int i, int j){
        if(i>=0 && j>=0 && obstacleGrid[i][j]==1) return 0;
        if(i==0 && j==0) return 1;
        if(i<0 || j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int up=rec(obstacleGrid,i-1,j);
        int left=rec(obstacleGrid,i,j-1);

        return dp[i][j]=up+left;
    }
    int uniquePathsWithObstacles(vector<vector<int>>& obstacleGrid) {
        int m=obstacleGrid.size();
        int n=obstacleGrid[0].size();
        dp.assign(m,vector<int> (n,-1));
        return rec(obstacleGrid,m-1,n-1);
    }
};