class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        if (n == 1) return 1;

        int minIdx = 0, maxIdx = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] < nums[minIdx]) minIdx = i;
            if (nums[i] > nums[maxIdx]) maxIdx = i;
        }

        // Ensure minIdx is the smaller index for simpler bounds
        int left = Math.min(minIdx, maxIdx);
        int right = Math.max(minIdx, maxIdx);

        // Scenario 1: Delete both from the front
        int deleteFront = right + 1;

        // Scenario 2: Delete both from the back
        int deleteBack = n - left;

        // Scenario 3: Delete one from the front and one from the back
        int deleteBoth = (left + 1) + (n - right);

        return Math.min(Math.min(deleteFront, deleteBack), deleteBoth);
    }
}