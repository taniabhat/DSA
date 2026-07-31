class Solution {
    public int minimumPushes(String word) {

        int[] counts=new int[26];
        for(char c:word.toCharArray()) counts[c-'a']++;

        int minpush=0;
        Arrays.sort(counts);

        for(int i=0;i<26;i++){
            int freq=counts[25-i];

            if(freq==0) break;

            minpush+=freq*((i/8)+1);
        }
        return minpush;
    }
}