class Solution {
    public int stoneGameII(int[] piles) {
        int n=piles.length;
        int[][] memo=new int[n][n+1];
        int[] suffixSum=new int[n];
        suffixSum[n-1]=piles[n-1];//last one will be same
        for(int i=n-2;i>=0;i--){
            suffixSum[i]=suffixSum[i+1]+piles[i];
        }
        return dfs(piles, 0,1, suffixSum, memo);
    }
    private int dfs(int[] piles, int i, int M, int[] suffixSum, int[][] memo){
        int n=piles.length;
        if(i==n) return 0;

        if(i+2*M>=n) return suffixSum[i];

        if(memo[i][M]!=0) return memo[i][M];

        int maxScores=0;
        for(int X=1;X<=2*M;X++){
            int oppBestScore=dfs(piles,i+X,Math.max(M,X), suffixSum, memo);

            int currScore=suffixSum[i]-oppBestScore;

            maxScores=Math.max(currScore, maxScores);
        }
        memo[i][M]=maxScores;
        return maxScores;
    }
}