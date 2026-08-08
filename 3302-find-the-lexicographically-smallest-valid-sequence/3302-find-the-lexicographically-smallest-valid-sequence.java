class Solution {
    public int[] validSequence(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();

        int[] dp=new int[n+1];
        int j=m-1;
        for(int i=n-1;i>=0;i--){
            if(j>=0 && word1.charAt(i)==word2.charAt(j)) {
                dp[i]=dp[i+1]+1;
                j--;
            }else dp[i]=dp[i+1];
        } 
        int[] res=new int[m];
        boolean usedChange=false;
        j=0;
        for(int i=0;i<n&& j<m;i++){
            if(word1.charAt(i)==word2.charAt(j)){
                res[j]=i;
                j++;
            }
            else if(!usedChange){
                int remainingChars=m-1-j;
                if(dp[i+1]>=remainingChars){
                    usedChange=true;
                    res[j]=i;
                    j++;
                }
            }
        }
        if(j==m) return res;

        return new int[0]; 
    }
}