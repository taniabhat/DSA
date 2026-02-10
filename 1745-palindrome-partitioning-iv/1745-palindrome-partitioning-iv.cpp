class Solution {
public:
    vector<vector<int>> dp;
    bool pal(string &s, int i, int j){
        if(i>=j) return true;
        if(dp[i][j]!=-1) return dp[i][j];

        return dp[i][j]=((s[i]==s[j]) && pal(s,i+1,j-1));
    }
    bool checkPartitioning(string s) {
        int n=s.size();
        dp.assign(n,vector<int>(n,-1));
        pal(s,0,s.size()-1);
        for(int i=0;i<n-2;i++){
            for(int j=i+1;j<n-1;j++){
                //if(dp[0][i] && dp[i+1][j] && dp[j+1][s.size()-1]) return true;
                if(pal(s, 0, i) &&
                   pal(s, i+1, j) &&
                   pal(s, j+1, n-1)) return true;
            }
        }
        return false;
    }
};