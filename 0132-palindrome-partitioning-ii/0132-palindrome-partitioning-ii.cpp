class Solution {
public:
    int minCut(string s) {
        int n=s.size();

        vector<int> dp(n);
        vector<vector<bool>> pal(n,vector<bool>(n,false));

        for(int i=0;i<n;i++){
            dp[i]=i;
            for(int j=0;j<=i;j++){
                if(s[i]==s[j] && (i-j<=2 || pal[j+1][i-1])){
                    pal[j][i] = true;
                    if(j == 0)
                        dp[i] = 0;
                    else
                        dp[i] = min(dp[i], dp[j-1] + 1);
                }
            }
        }
        return dp[n-1];
    }
};