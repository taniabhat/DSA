class Solution {
    public int distinctSubseqII(String s) {
        long MOD=1000000007;
        long dp=1;
        long[] last=new long[26];

        for(char c:s.toCharArray()){
            int idx=c-'a';
            long oldDp=dp;

            dp=(2*dp-last[idx]+MOD)%MOD;

            last[idx]=oldDp;
        }
        return (int)((dp-1+MOD)%MOD);
    }
}