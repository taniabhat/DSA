class Solution {
    public int maximumLengthSubstring(String s) {
        Map<Character, Integer> freq=new HashMap<>();
        int left=0;
        int maxlen=0;
        for(int right=0;right<s.length();right++){
            char rchar=s.charAt(right);
            freq.put(rchar, freq.getOrDefault(rchar,0)+1);

            while(freq.get(rchar)>2){
                char lchar=s.charAt(left);
                freq.put(lchar, freq.get(lchar)-1);
                left++;
            }
            maxlen=Math.max(maxlen, right-left+1);
        }
        return maxlen;
    }
}