class Solution {
    public int minElement(int[] nums) {
        int min=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            int sum=0;
            int tmp=nums[i];
            while(tmp>0){
                int r=tmp%10;
                sum+=r;
                tmp=tmp/10;
            }
            if(sum<min) min=sum;
        }
        return min;
    }

}