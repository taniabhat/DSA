class Solution {
    public int countCommas(int n) {
        int ans=0;
        int t=1000;
        if(t<=n){
            ans=n-t+1;
        }else{
            ans=0;

        }
        return ans;
    }
}