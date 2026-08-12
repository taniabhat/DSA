class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> freq=new HashMap<>();
        int left=0;
        int maxlen=0;
        for(int right=0;right<nums.length;right++){
            freq.put(nums[right], freq.getOrDefault(nums[right], 0)+1);

            while(freq.get(nums[right])>k){
                freq.put(nums[left], freq.get(nums[left])-1);
                left++;
            }
            maxlen=Math.max(maxlen, right-left+1);
        }
        return maxlen;
    }
}