class Solution {
    public int numberOfSubstrings(String s) {
        int left=0;
        int total=0;
        int[] cnt=new int[3];
        for(int right=0;right<s.length();right++){
            cnt[s.charAt(right)-'a']++;

            while(cnt[0]>=1 && cnt[1]>=1 && cnt[2]>=1){
                total+=(s.length() -right);

                cnt[s.charAt(left)-'a']--;
                left++;
            }
        }
        return total;
    }
}