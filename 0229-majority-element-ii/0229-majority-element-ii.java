class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans=new ArrayList<>();
        Map<Integer, Integer> freq=new HashMap<>();
        for(int n: nums){
            freq.merge(n,1,Integer::sum);
        }
        for(Map.Entry<Integer, Integer> entry:freq.entrySet()){
            if(entry.getValue()>nums.length/3) ans.add(entry.getKey());
        }
        return ans;
    }
}