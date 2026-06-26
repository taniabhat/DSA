class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n=nums.length;
        int cnt=0;
        for(int i=0;i<n;i++){
            int currcnt=0;
            for(int j=i;j<n;j++){
                if(nums[j]==target){
                    currcnt++;
                }
                int len=j-i+1;
                if(2*currcnt>len) cnt++;
            }
        }
        return cnt;
    }
}