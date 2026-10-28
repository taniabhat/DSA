class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans=new ArrayList<>();
        Map<Integer, Integer> freq=new HashMap<>();
        for(int n: nums){
            freq.put(n, freq.getOrDefault(n,0)+1);
        }
        for(Map.Entry<Integer, Integer> entry:freq.entrySet()){
            if(entry.getValue()>nums.length/3) ans.add(entry.getKey());
        }
        return ans;
    }
}