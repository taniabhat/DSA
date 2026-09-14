class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int l1=rec1[2];
        int b1=rec1[0];
        int l2=rec2[2];
        int b2=rec2[0];

        boolean xNotOverlap=(l1<=b2 || l2<=b1);
        boolean yNotOverlap=(rec1[3]<=rec2[1] || rec2[3]<=rec1[1]);

        return !(xNotOverlap || yNotOverlap);
    }
}