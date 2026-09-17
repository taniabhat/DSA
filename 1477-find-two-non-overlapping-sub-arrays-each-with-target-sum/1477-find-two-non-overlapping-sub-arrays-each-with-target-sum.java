class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n=arr.length;

        int[] minLen=new int[n];
        int INF=Integer.MAX_VALUE/2;
        Arrays.fill(minLen,INF);

        int l=0;
        int currSum=0;

        int minSoFar=INF;
        int res=INF;

        for(int r=0;r<n;r++){
            currSum+=arr[r];

            while(currSum>=target){
                if(currSum==target){
                    int currSubArrLen=r-l+1;

                    if(l>0 && minLen[l-1]!=INF) res=Math.min(res,currSubArrLen+minLen[l-1]);
                    minSoFar=Math.min(minSoFar, currSubArrLen);
                }
                currSum-=arr[l];
                l++;
            }
            minLen[r]=minSoFar;
        }
        return res==INF?-1:res;
    }
}