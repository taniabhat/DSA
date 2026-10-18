class Solution {
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
               c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
    public String reverseVowels(String s) {
        char[] sarr=s.toCharArray();
        int l=0;
        int r=s.length()-1;
        while(l<r){
            while(l<r && !isVowel(sarr[l])) l++;
            while(l<r && !isVowel(sarr[r])) r--;

            char temp=sarr[l];
            sarr[l]=sarr[r];
            sarr[r]=temp;

            l++;
            r--;
        }
        String str=String.valueOf(sarr);

        return str;
        
    }
}