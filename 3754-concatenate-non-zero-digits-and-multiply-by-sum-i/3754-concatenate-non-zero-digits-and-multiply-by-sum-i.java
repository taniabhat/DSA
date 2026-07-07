class Solution {
    public long sumAndMultiply(int n) {
        String s=String.valueOf(n);
        long sum=0;
        long x=0;
        for(char c:s.toCharArray()){
            if(c!='0'){
                int digit=c-'0';
                x=x*10+(long)digit;
                sum=sum+digit;
            }
        }
        return x*sum;
    }
}