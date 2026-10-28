class Solution {
    private int getSum(int temp){
        int sqSum=0;
         while(temp>0){
            int r=temp%10;
            sqSum=sqSum+(r*r);
            temp=temp/10;
        }
        return sqSum;
    }
    public boolean isHappy(int n) {
        HashSet<Integer> seen=new HashSet<>();

        while(n!=1 && !seen.contains(n)) {
            seen.add(n);
            n=getSum(n);
        }
        return n==1;
    }
}