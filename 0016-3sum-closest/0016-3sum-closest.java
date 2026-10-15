class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n=nums.length;
        int diff=0;
        int closeSum=nums[0]+nums[1]+nums[2];
        for(int i=0;i<n-2;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            int j=i+1;
            int k=n-1;
            while(j<k){
                int sum=nums[i]+nums[j]+nums[k];
                if(sum==target) return sum;

                diff=Math.abs(sum-target);
                if(diff<Math.abs(closeSum-target)) closeSum=sum;
                else if(sum<target) j++;
                else k--;
                
            }
        }
        return closeSum;
    }
}