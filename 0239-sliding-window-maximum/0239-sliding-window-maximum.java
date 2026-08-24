class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        Deque<Integer> q=new ArrayDeque<>();
        int[] res=new int[n-k+1];
        int ri=0;

        for(int i=0;i<n;i++){
            if(!q.isEmpty() && q.peekFirst()<i-k+1) q.pollFirst();

            while(!q.isEmpty() && nums[q.peekLast()]<nums[i]) q.pollLast();

            q.offerLast(i);

            if(i>=k-1) res[ri++]=nums[q.peekFirst()];
        }
        return res;
        
    }
}