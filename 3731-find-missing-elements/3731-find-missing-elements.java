class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int n=nums.length;
        List<Integer> res=new ArrayList<>();
        int mini=Integer.MAX_VALUE;
        int maxi=Integer.MIN_VALUE;

        boolean[] present=new boolean[101];
        for(int i=0;i<n;i++){
            if(nums[i]<mini) mini=Math.min(nums[i], mini);
            if(nums[i]>maxi) maxi=Math.max(nums[i], maxi);
            present[nums[i]]=true;
        }
        
        for(int i=mini;i<=maxi;i++){
            if(!present[i]){
                res.add(i);
            }
        }
        return res;
    }
}