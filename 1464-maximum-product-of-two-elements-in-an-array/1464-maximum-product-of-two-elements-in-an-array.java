class Solution {
    public int maxProduct(int[] nums) {
        int maxprod=0;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                int currprod=(nums[i]-1)*(nums[j]-1);
                if(currprod>maxprod) maxprod=Math.max(currprod, maxprod);
            }
        }
        return maxprod;
    }
}