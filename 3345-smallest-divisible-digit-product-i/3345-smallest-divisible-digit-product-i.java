class Solution {
    public int smallestNumber(int n, int t) {
        int min=n;
        while(min>=n){
            int prod=1;
            int temp=min;
            while(temp>0){
                int dig1=temp%10;
                prod=prod*dig1;
                temp=temp/10;
            }
            if(prod%t==0) break;
            min++;
        }
        return min;
    }
}