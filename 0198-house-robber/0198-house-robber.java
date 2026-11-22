class Solution {
    public int rob(int[] nums) {
        int maxSum=0;
        int curr=0;
        for(int i=0;i<nums.length;i++){
            int temp;
            temp=Math.max(maxSum, curr+nums[i]);
            curr=maxSum;
            maxSum=temp;
        }
        return maxSum;


    }
}