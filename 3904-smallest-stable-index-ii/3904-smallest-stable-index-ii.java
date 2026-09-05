class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n=nums.length;

        int[] pref=new int[n];
        pref[0]=nums[0];
        for(int i=1;i<n;i++){
            pref[i]=Math.max(pref[i-1],nums[i]);
        }

        int[] suff=new int[n];
        suff[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--){
            suff[i]=Math.min(suff[i+1], nums[i]);
        }

        for(int i=0;i<n;i++){
            if(pref[i]-suff[i]<=k) return i;
        }
        return -1;
    }
}