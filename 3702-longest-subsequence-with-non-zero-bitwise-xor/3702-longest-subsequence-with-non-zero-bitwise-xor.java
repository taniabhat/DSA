class Solution {
    public int longestSubsequence(int[] nums) {
        int totalXor=0;
        boolean hasPos=false;
        for(int n:nums){
            totalXor^=n;
            if(n!=0) hasPos=true;
        }
        if(!hasPos) return 0;
        if(totalXor!=0) return nums.length;

        return nums.length-1;

    }
}