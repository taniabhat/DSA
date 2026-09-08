class Solution {
    public int countCommas(int n) {
        int ans=0;
        int t=999;
        if(t<=n){
            ans=n-t;
        }else{
            ans=0;

        }
        return ans;
    }
}