class Solution {
    int[] memo;
    public int combinationSum4(int[] nums, int target) {
        int n=nums.length;
        int[] memo=new int[target+1];
        //Arrays.fill(memo,0);
        int cntcomb=0;
        memo[0]=1;
        for(int i=1;i<=target;i++){
            for (int num:nums){
                if((i-num)>=0) {
                    memo[i]+=memo[i-num];
                }
            }
        }
        return memo[target];
    }
}