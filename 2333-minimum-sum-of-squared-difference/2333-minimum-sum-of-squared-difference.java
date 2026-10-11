class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        long totalOps=(long)(k1+k2);
        int n=nums1.length;
        int maxDiff=Integer.MIN_VALUE;
        int[] count=new int[100005];
        for(int i=0;i<n;i++){
            int diff=Math.abs(nums1[i]-nums2[i]);
            count[diff]++;
            maxDiff=Math.max(maxDiff, diff);
        }

        for(int d=maxDiff;d>0 && totalOps>0;d--){
            if(count[d]==0) continue;
            long opsToUse=Math.min(totalOps, (long)count[d]);

            count[d]-=opsToUse;
            count[d-1]+=opsToUse;
            totalOps-=opsToUse; 
        }

        long minSum=0;
        for(int d=1;d<=maxDiff;d++){
            if(count[d]>0){
                minSum+=(long)count[d]*d*d;
            }
        }
        return minSum;
    }
}