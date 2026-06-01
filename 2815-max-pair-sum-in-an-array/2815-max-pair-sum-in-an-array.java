class Solution {
    private int getMaximumdigit(int n){
        int maxnum=0;
        while(n>0){
            maxnum=Math.max(maxnum, n%10);
            n=n/10;
        }
        return maxnum;
    }
    public int maxSum(int[] nums) {
        int ans=-1;
        int[] maxVal=new int[10];
        for(int n:nums){
            int maxdig=getMaximumdigit(n);
            if(maxVal[maxdig]>0) ans=Math.max(ans, n+maxVal[maxdig]);
            maxVal[maxdig]=Math.max(maxVal[maxdig],n);
        }
        return ans;
    }
}