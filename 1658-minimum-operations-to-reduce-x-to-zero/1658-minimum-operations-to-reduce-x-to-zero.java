class Solution {
    public int minOperations(int[] nums, int x) {
        int n=nums.length;
        int totalSum=0;
        for(int no: nums) totalSum+=no;

        int req=totalSum-x;
        int l=0;
        int sum=0;
        int maxLen=-1;

        if(req==0) return n;

        if(req<0) return -1;

        for(int r=0;r<n;r++){
            sum+=nums[r];

            while(l<r && sum>req){
                sum-=nums[l];
                l++;
            }

            if(sum==req) maxLen=Math.max(maxLen, r-l+1);
        }
        if(maxLen<0) return -1;

        return n-maxLen;

    }
}