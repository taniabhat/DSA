class Solution {
    public int totalFruit(int[] fruits) {
        int n=fruits.length;
        Map<Integer, Integer> mp=new HashMap<>();
        int k=2;
        int l=0;
        int maxLen=0;
        for(int r=0;r<n;r++){
            mp.put(fruits[r], mp.getOrDefault(fruits[r], 0)+1);
            while(mp.size()>k){
                mp.put(fruits[l], mp.get(fruits[l])-1);
                if(mp.get(fruits[l])==0) mp.remove(fruits[l]);
                l++;
            }
            if(mp.size()<=k) {
                maxLen=Math.max(maxLen, r-l+1);
            }
        }
        return maxLen;
    }
}