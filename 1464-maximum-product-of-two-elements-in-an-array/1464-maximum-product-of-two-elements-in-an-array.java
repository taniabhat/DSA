class Solution {
    public int maxProduct(int[] nums) {
        int maxprod1=0;
        int maxprod2=0;
        for(int n:nums){
            if(n>maxprod1){
                maxprod2=maxprod1;
                maxprod1=n;
            }else if(n>maxprod2){
                maxprod2=n;
            }
        }
        return (maxprod1-1)*(maxprod2-1);
    }
}