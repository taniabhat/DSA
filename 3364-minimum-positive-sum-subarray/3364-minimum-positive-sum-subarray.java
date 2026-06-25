class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n=nums.size();
        int[] prefix=new int[n];
        prefix[0]=nums.get(0);
        for(int i=1;i<n;i++){
            prefix[i]=prefix[i-1]+nums.get(i);
        }
        int ans=Integer.MAX_VALUE;
        for(int len=l;len<=r;len++){
            for(int start=0;len+start-1<n;start++){
                int sum;
                int end=len+start-1;
                if(start==0){
                    sum=prefix[end];
                }else sum=prefix[end]-prefix[start-1];

                if(sum>0) ans=Math.min(ans,sum);
            }
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
}