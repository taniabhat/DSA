class Solution {
    public int[] pathsWithMaxScore(List<String> board) {
        int n=board.size();
        int MOD=1000000007;

        int[][][] dp=new int[n][n][2];
        for(int[][] row:dp){
            for(int[] cell: row){
                cell[0]=-1;
            }
        }
        dp[n-1][n-1] =new int[]{0,1};

        for(int i=n-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                char c=board.get(i).charAt(j);
                if(c=='X' || (i==n-1 && j==n-1)) continue;
                int val=(c=='E')?0:c-'0';
                int maxscore=-1;
                int cnt=0;

                int[][] neighbors={{i+1,j}, {i,j+1}, {i+1,j+1}};
                for(int[] neighbor: neighbors){
                    int ni=neighbor[0], nj=neighbor[1];
                    if(ni<n && nj<n && dp[ni][nj][0]!=-1){
                        int currscore=dp[ni][nj][0]+val;
                        if(currscore>maxscore){
                            maxscore=currscore;
                            cnt=dp[ni][nj][1];
                        }else if(currscore==maxscore) cnt=(cnt+dp[ni][nj][1])%MOD;
                    }
                }
                dp[i][j][0]=maxscore;
                dp[i][j][1]=cnt;
            }
        }
        return dp[0][0][0]==-1? new int[]{0,0} : dp[0][0];
    }
}