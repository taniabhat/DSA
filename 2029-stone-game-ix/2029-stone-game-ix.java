class Solution {
    public boolean stoneGameIX(int[] stones) {
        int[] count = new int[3];

        for (int x : stones) {
            count[x % 3]++;
        }

        // No 1 or 2 -> Alice has to take a 0 and loses
        if (count[1] == 0 && count[2] == 0) {
            return false;
        }

        // If count[0] is even:
        // Alice wins if both types exist.
        if (count[0] % 2 == 0) {
            return count[1] > 0 && count[2] > 0;
        }

        // If count[0] is odd:
        // Alice needs a difference greater than 2.
        return Math.abs(count[1] - count[2]) > 2;
    }
}