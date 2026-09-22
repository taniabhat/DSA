class Solution {
    public boolean isPalindrome(int x) {
        String s=String.valueOf(x);
        int n=s.length();
        int l=0;
        int r=n-1;
        while(l<r){
            if(s.charAt(l)!=s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}