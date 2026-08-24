class Solution {
    public int splitArray(int[] nums, int k) {
        int low=0;
        int high=0;

        for(int i:nums){
            low=Math.max(low,i);
            high+=i;
        }
        int ans=high;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(isFeasible(nums,k,mid)){
                ans=mid;
                high=mid-1;
            }else low=mid+1;
        }
        return ans;
    }
    private boolean isFeasible(int[] a,int k, int maxTotSum){
        int currentSum=0;
        int subTot=1;

        for(int x:a){
            if(currentSum+x > maxTotSum){
                currentSum=x;
                subTot++;
            }
            else currentSum+=x;
        }
        return subTot<=k;
    }
}