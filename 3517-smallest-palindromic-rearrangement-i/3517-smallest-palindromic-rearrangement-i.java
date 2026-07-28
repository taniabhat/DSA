class Solution {
    public String smallestPalindrome(String s) {
        if(s.length()<=1) return s;
        int[] count=new int[26];
        for(char c:s.toCharArray()){
            count[c-'a']++;
        }
        StringBuilder fhalf=new StringBuilder();
        String mid="";

        for(int i=0;i<26;i++){
            if(count[i] % 2 != 0){
                mid=String.valueOf((char)(i+'a'));
            }
            for(int j=0;j<count[i]/2;j++){
                fhalf.append((char)(i+'a'));
            }
        }
        StringBuilder res=new StringBuilder(fhalf);
        res.append(mid);
        res.append(fhalf.reverse());

        return res.toString();

    }
}