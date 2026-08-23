class Solution {
    public boolean sumGame(String num) {
        int s1=0, s2=0;
        int q1=0, q2=0;
        int n=num.length();
        for(int i=0;i<=(n/2)-1;i++){
            if(num.charAt(i)=='?') q1++;
            else s1+=(num.charAt(i)-'0');
        }
        for(int i=n/2;i<=n-1;i++){
            if(num.charAt(i)=='?') q2++;
            else s2+=(num.charAt(i)-'0');
        }
        if((q1+q2)%2!=0) return true;
        if((s1-s2) == 9*(q2-q1)/2) return false;
        return true;

    }
}