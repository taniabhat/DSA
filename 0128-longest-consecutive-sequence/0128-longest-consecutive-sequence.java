class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        int maxLen=0;
        for(int i:nums){
            set.add(i);
        }
        for(int num : set){
            if(!set.contains(num-1)){
                int currNum=num;
                int currLen=1;
            
                while(set.contains(currNum+1)){
                    currNum++;
                    currLen++;
                }
                maxLen=Math.max(maxLen, currLen);
            }
        }
        return maxLen;
    }
}