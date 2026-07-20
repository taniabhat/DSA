class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq=new int[26];
        int l=0;
        int ans=0;
        int maxfreq=0;

        for(int r=0;r<s.length();r++){
            char ch=s.charAt(r);
            freq[ch-'A']++;

            maxfreq=Math.max(maxfreq, freq[ch-'A']);

            while((r-l+1)-maxfreq > k){
                freq[s.charAt(l)-'A']--;
                l++;
            }
            ans=Math.max(r-l+1, ans);

        }
        return ans;
    }
}